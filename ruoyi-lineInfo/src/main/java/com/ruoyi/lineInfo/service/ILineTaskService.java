package com.ruoyi.lineInfo.service;

import java.util.List;
import com.ruoyi.lineInfo.domain.LineTask;

/**
 * 生产任务管理Service接口
 * 
 * @author mazijian
 * @date 2021-12-10
 */
public interface ILineTaskService 
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
     * 批量删除生产任务管理
     * 
     * @param ids 需要删除的生产任务管理主键集合
     * @return 结果
     */
    public int deleteLineTaskByIds(Long[] ids);

    /**
     * 删除生产任务管理信息
     * 
     * @param id 生产任务管理主键
     * @return 结果
     */
    public int deleteLineTaskById(Long id);
}
