package com.ruoyi.recipe.service.impl;


import com.ruoyi.recipe.domain.DB202mg;
import com.ruoyi.recipe.domain.DB203mg;
import com.ruoyi.recipe.domain.DB205mg;
import com.ruoyi.recipe.domain.mgDBRe;
import com.ruoyi.recipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 产线管理Service业务层处理
 * 
 * @author mazijian
 * @date 2021-11-17
 */
@Service
public class RecipeServiceImpl implements RecipeService
{


    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * 查询MongoDB DB2002
     */
    @Override
    public mgDBRe selectLineBasicDB02(int pageNum, int pageSize, String name) {
        /**
         * 设置分页数据
         */

        Pageable pageable = PageRequest.of(pageNum,pageSize);

        /**
         * 设置查询条件
         */
        Query query =new Query();
        System.out.println("服务层中的name:"+name);
        if(name!=null){
            Pattern pattern=Pattern.compile("^.*"+name+".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("info.arsEntraRecipe_strDataSetName").regex(pattern));
        }

        /**
         * 满足要求的条目总数
         */
        long db2002 = mongoTemplate.count(query, "DB2002");
        /**
         * 返回分页后的数据
         */
        List<DB202mg> h_l = mongoTemplate.find(query.with(pageable), DB202mg.class, "DB2002");

        mgDBRe hl=new mgDBRe<DB202mg>();
        hl.setList(h_l);
        hl.setTotal(db2002);


//        List<DB02mg> hl = mongoTemplate.findAll(DB02mg.class, "DB2002");
        return hl;
    }


    /**
     * 查询MongoDB DB2003
     */
    @Override
    public mgDBRe selectLineBasicDB03(int pageNum, int pageSize, String name) {
        /**
         * 设置分页数据
         */
        Pageable pageable = PageRequest.of(pageNum,pageSize);

        /**
         * 设置查询条件
         */
        Query query =new Query();
        System.out.println("服务层中的name:"+name);
        if(name!=null){
            Pattern pattern=Pattern.compile("^.*"+name+".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("info.arsEntraRecipe_sMinor_strDataSetName").regex(pattern));
        }

        /**
         * 满足要求的条目总数
         */
        long db2003 = mongoTemplate.count(query, "DB2003");
        /**
         * 返回分页后的数据
         */
        List<DB203mg> h_l = mongoTemplate.find(query.with(pageable), DB203mg.class, "DB2003");

        mgDBRe hl=new mgDBRe<DB203mg>();
        hl.setList(h_l);
        hl.setTotal(db2003);

//        List<DB02mg> hl = mongoTemplate.findAll(DB02mg.class, "DB2002");
        return hl;
    }

    /**
     * 查询MongoDB DB2005
     */
    @Override
    public mgDBRe selectLineBasicDB05(int pageNum, int pageSize, String name) {
        /**
         * 设置分页数据
         */
        Pageable pageable = PageRequest.of(pageNum,pageSize);

        /**
         * 设置查询条件
         */
        Query query =new Query();
        System.out.println("服务层中的name:"+name);
        if(name!=null){
            Pattern pattern=Pattern.compile("^.*"+name+".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("info.PressRecipe_die_DieName").regex(pattern));
        }

        /**
         * 满足要求的条目总数
         */
        long db2005 = mongoTemplate.count(query, "DB2005");
        /**
         * 返回分页后的数据
         */
        List<DB205mg> h_l = mongoTemplate.find(query.with(pageable), DB205mg.class, "DB2005");

        mgDBRe hl=new mgDBRe<DB205mg>();
        hl.setList(h_l);
        hl.setTotal(db2005);

//        List<DB02mg> hl = mongoTemplate.findAll(DB02mg.class, "DB2002");
        return hl;
    }


}
