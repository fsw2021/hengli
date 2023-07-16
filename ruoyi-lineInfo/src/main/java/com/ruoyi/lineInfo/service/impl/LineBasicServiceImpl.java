package com.ruoyi.lineInfo.service.impl;

import com.ruoyi.lineInfo.domain.*;
import com.ruoyi.lineInfo.mapper.LineBasicMapper;
import com.ruoyi.lineInfo.service.ILineBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产线管理Service业务层处理
 * 
 * @author mazijian
 * @date 2021-11-17
 */
@Service
public class LineBasicServiceImpl implements ILineBasicService 
{
    @Autowired
    private LineBasicMapper lineBasicMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 查询产线管理
     * 
     * @param id 产线管理主键
     * @return 产线管理
     */
    @Override
    public LineBasic selectLineBasicById(Long id)
    {
        return lineBasicMapper.selectLineBasicById(id);
    }

    /**
     * 查询MongoDB DB2000
     */

    @Override
    public List<DB00mg> selectLineBasicDB00() {
        List<DB00mg> hl = mongoTemplate.findAll(DB00mg.class, "DB2000");
//        System.out.println("789+");
        return hl;
    }
    /**
     * 查询MongoDB DB2001
     */
    @Override
    public List<DB01mg> selectLineBasicDB01() {
        List<DB01mg> hl = mongoTemplate.findAll(DB01mg.class, "DB2001");
        return hl;
    }
    /**
     * 查询MongoDB DB2002
     */
//    @Override
//    public mgDB02Re selectLineBasicDB02() {
//        /**
//         * 设置分页数据
//         */
//        Pageable pageable = PageRequest.of(1,1 );
//        Query query =new Query();
//
//        /**
//         * 满足要求的条目总数
//         */
//        long db2002 = mongoTemplate.count(query, "DB2002");
//        System.out.println("mongoTemplate.count(query, DB02mg.class)");
//        System.out.println(db2002);
//
//        List<DB02mg> h_l = mongoTemplate.find(query.with(pageable), DB02mg.class, "DB2002");
//
//        mgDB02Re hl=new mgDB02Re<DB02mg>();
//        hl.setList(h_l);
//        hl.setTotal(db2002);
//
//
////        List<DB02mg> hl = mongoTemplate.findAll(DB02mg.class, "DB2002");
//        return hl;
//    }


    /**
     * 查询产线管理列表
     * 
     * @param lineBasic 产线管理
     * @return 产线管理
     */
    @Override
    public List<LineBasic> selectLineBasicList(LineBasic lineBasic)
    {
        return lineBasicMapper.selectLineBasicList(lineBasic);
    }

    /**
     * 新增产线管理
     * 
     * @param lineBasic 产线管理
     * @return 结果
     */
    @Override
    public int insertLineBasic(LineBasic lineBasic)
    {
        return lineBasicMapper.insertLineBasic(lineBasic);
    }

    /**
     * 修改产线管理
     * 
     * @param lineBasic 产线管理
     * @return 结果
     */
    @Override
    public int updateLineBasic(LineBasic lineBasic)
    {
        return lineBasicMapper.updateLineBasic(lineBasic);
    }

    /**
     * 批量删除产线管理
     * 
     * @param ids 需要删除的产线管理主键
     * @return 结果
     */
    @Override
    public int deleteLineBasicByIds(Long[] ids)
    {
        return lineBasicMapper.deleteLineBasicByIds(ids);
    }

    /**
     * 删除产线管理信息
     * 
     * @param id 产线管理主键
     * @return 结果
     */
    @Override
    public int deleteLineBasicById(Long id)
    {
        return lineBasicMapper.deleteLineBasicById(id);
    }
}
