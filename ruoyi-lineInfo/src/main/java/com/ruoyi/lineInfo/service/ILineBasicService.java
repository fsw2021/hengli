package com.ruoyi.lineInfo.service;

import com.ruoyi.lineInfo.domain.*;

import java.util.List;

/**
 * 产线管理Service接口
 * 
 * @author mazijian
 * @date 2021-11-17
 */
public interface ILineBasicService 
{
    /**
     * 查询产线管理
     * 
     * @param id 产线管理主键
     * @return 产线管理
     */
    public LineBasic selectLineBasicById(Long id);

    public List<DB00mg> selectLineBasicDB00();

    public List<DB01mg> selectLineBasicDB01();

//    public mgDB02Re selectLineBasicDB02();




    /**
     * 查询产线管理列表
     * 
     * @param lineBasic 产线管理
     * @return 产线管理集合
     */
    public List<LineBasic> selectLineBasicList(LineBasic lineBasic);

    /**
     * 新增产线管理
     * 
     * @param lineBasic 产线管理
     * @return 结果
     */
    public int insertLineBasic(LineBasic lineBasic);

    /**
     * 修改产线管理
     * 
     * @param lineBasic 产线管理
     * @return 结果
     */
    public int updateLineBasic(LineBasic lineBasic);

    /**
     * 批量删除产线管理
     * 
     * @param ids 需要删除的产线管理主键集合
     * @return 结果
     */
    public int deleteLineBasicByIds(Long[] ids);

    /**
     * 删除产线管理信息
     * 
     * @param id 产线管理主键
     * @return 结果
     */
    public int deleteLineBasicById(Long id);
}
