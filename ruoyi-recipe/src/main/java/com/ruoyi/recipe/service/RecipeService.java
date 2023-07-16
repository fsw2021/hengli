package com.ruoyi.recipe.service;

import com.ruoyi.recipe.domain.mgDBRe;

/**
 * 配方y Service接口
 * 
 * @author fsw
 * @date 2023-05-15
 */
public interface RecipeService
{
    public mgDBRe selectLineBasicDB02(int pageNum, int pageSize, String name);

    public mgDBRe selectLineBasicDB03(int pageNum, int pageSize, String name);

    public mgDBRe selectLineBasicDB05(int pageNum, int pageSize, String name);



}
