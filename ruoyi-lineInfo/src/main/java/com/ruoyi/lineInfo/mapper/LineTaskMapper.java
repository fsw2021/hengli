package com.ruoyi.lineInfo.mapper;

import java.util.List;
import com.ruoyi.lineInfo.domain.LineTask;
import com.ruoyi.lineInfo.domain.LineTaskRaw;

/**
 * 生产任务管理Mapper接口
 * 
 * @author mazijian
 * @date 2021-12-10
 */
public interface LineTaskMapper 
{
    /**
     * 查询生产任务管理
     * 
     * @param id 生产任务管理主键
     * @return 生产任务管理
     */
    public LineTask selectLineTaskById(Long id);

    /**
     * 查询生产任务管理列表
     * 
     * @param lineTask 生产任务管理
     * @return 生产任务管理集合
     */
    public List<LineTask> selectLineTaskList(LineTask lineTask);

    /**
     * 新增生产任务管理
     * 
     * @param lineTask 生产任务管理
     * @return 结果
     */
    public int insertLineTask(LineTask lineTask);

    /**
     * 修改生产任务管理
     * 
     * @param lineTask 生产任务管理
     * @return 结果
     */
    public int updateLineTask(LineTask lineTask);

    /**
     * 删除生产任务管理
     * 
     * @param id 生产任务管理主键
     * @return 结果
     */
    public int deleteLineTaskById(Long id);

    /**
     * 批量删除生产任务管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLineTaskByIds(Long[] ids);

    /**
     * 批量删除${subTable.functionName}
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLineTaskRawByTaskIds(Long[] ids);
    
    /**
     * 批量新增${subTable.functionName}
     * 
     * @param lineTaskRawList ${subTable.functionName}列表
     * @return 结果
     */
    public int batchLineTaskRaw(List<LineTaskRaw> lineTaskRawList);
    

    /**
     * 通过生产任务管理主键删除${subTable.functionName}信息
     * 
     * @param id 生产任务管理ID
     * @return 结果
     */
    public int deleteLineTaskRawByTaskId(Long id);
}
