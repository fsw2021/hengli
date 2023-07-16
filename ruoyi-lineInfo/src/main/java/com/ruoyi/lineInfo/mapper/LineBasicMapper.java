package com.ruoyi.lineInfo.mapper;

import java.util.List;
import com.ruoyi.lineInfo.domain.LineBasic;

/**
 * 产线管理Mapper接口
 * 
 * @author mazijian
 * @date 2021-11-17
 */
public interface LineBasicMapper 
{
    /**
     * 查询产线管理
     * 
     * @param id 产线管理主键
     * @return 产线管理
     */
    public LineBasic selectLineBasicById(Long id);

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
     * 删除产线管理
     * 
     * @param id 产线管理主键
     * @return 结果
     */
    public int deleteLineBasicById(Long id);

    /**
     * 批量删除产线管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLineBasicByIds(Long[] ids);
}
