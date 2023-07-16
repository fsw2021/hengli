package com.ruoyi.lineInfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.lineInfo.domain.LineTaskRaw;
import com.ruoyi.lineInfo.mapper.LineTaskMapper;
import com.ruoyi.lineInfo.domain.LineTask;
import com.ruoyi.lineInfo.service.ILineTaskService;

/**
 * 生产任务管理Service业务层处理
 * 
 * @author mazijian
 * @date 2021-12-10
 */
@Service
public class LineTaskServiceImpl implements ILineTaskService 
{
    @Autowired
    private LineTaskMapper lineTaskMapper;

    /**
     * 查询生产任务管理
     * 
     * @param id 生产任务管理主键
     * @return 生产任务管理
     */
    @Override
    public LineTask selectLineTaskById(Long id)
    {
        return lineTaskMapper.selectLineTaskById(id);
    }

    /**
     * 查询生产任务管理列表
     * 
     * @param lineTask 生产任务管理
     * @return 生产任务管理
     */
    @Override
    public List<LineTask> selectLineTaskList(LineTask lineTask)
    {
        return lineTaskMapper.selectLineTaskList(lineTask);
    }

    /**
     * 新增生产任务管理
     * 
     * @param lineTask 生产任务管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertLineTask(LineTask lineTask)
    {
        int rows = lineTaskMapper.insertLineTask(lineTask);
        insertLineTaskRaw(lineTask);
        return rows;
    }

    /**
     * 修改生产任务管理
     * 
     * @param lineTask 生产任务管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateLineTask(LineTask lineTask)
    {
        lineTaskMapper.deleteLineTaskRawByTaskId(lineTask.getId());
        insertLineTaskRaw(lineTask);
        return lineTaskMapper.updateLineTask(lineTask);
    }

    /**
     * 批量删除生产任务管理
     * 
     * @param ids 需要删除的生产任务管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteLineTaskByIds(Long[] ids)
    {
        lineTaskMapper.deleteLineTaskRawByTaskIds(ids);
        return lineTaskMapper.deleteLineTaskByIds(ids);
    }

    /**
     * 删除生产任务管理信息
     * 
     * @param id 生产任务管理主键
     * @return 结果
     */
    @Override
    public int deleteLineTaskById(Long id)
    {
        lineTaskMapper.deleteLineTaskRawByTaskId(id);
        return lineTaskMapper.deleteLineTaskById(id);
    }

    /**
     * 新增${subTable.functionName}信息
     * 
     * @param lineTask 生产任务管理对象
     */
    public void insertLineTaskRaw(LineTask lineTask)
    {
        List<LineTaskRaw> lineTaskRawList = lineTask.getLineTaskRawList();
        Long id = lineTask.getId();
        if (StringUtils.isNotNull(lineTaskRawList))
        {
            List<LineTaskRaw> list = new ArrayList<LineTaskRaw>();
            for (LineTaskRaw lineTaskRaw : lineTaskRawList)
            {
                lineTaskRaw.setTaskId(id);
                list.add(lineTaskRaw);
            }
            if (list.size() > 0)
            {
                lineTaskMapper.batchLineTaskRaw(list);
            }
        }
    }
}
