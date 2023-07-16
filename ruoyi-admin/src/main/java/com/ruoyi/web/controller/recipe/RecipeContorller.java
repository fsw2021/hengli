
package com.ruoyi.web.controller.recipe;

        import com.ruoyi.common.core.controller.BaseController;
        import com.ruoyi.common.core.page.PageDomain;
        import com.ruoyi.common.core.page.TableDataInfo;
        import com.ruoyi.common.core.page.TableSupport;
        import com.ruoyi.recipe.domain.*;

        import com.ruoyi.recipe.service.RecipeService;
        import org.springframework.beans.factory.annotation.Autowired;


        import org.springframework.web.bind.annotation.*;

/**
 * 配方管理Controller
 *
 * @author fsw
 * @date 2023-05-15
 */
@RestController
@RequestMapping("/recipe")
public class RecipeContorller extends BaseController
{
    @Autowired
    private RecipeService recipeService;
    /**
     * 获取DB2002
     */
//    @PreAuthorize("@ss.hasPermi('lineInfo:basic:query')")
    @GetMapping("/entrarecipe")
    public TableDataInfo getInDB02(queryParams queryparams)
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer page_Num = pageDomain.getPageNum();
        Integer page_Size = pageDomain.getPageSize();
        int pageNum = page_Num.intValue();
        int pageSize = page_Size.intValue();
        String name=queryparams.getErstrDataSetName();
//        String name=erstrDataSetName;
        System.out.println("控制层获取的配方名为:"+name);
        System.out.println("===>获取页数和页码");
        System.out.println("===>获取页数和页码");
        System.out.println(pageSize);
        System.out.println(pageNum);

        mgDBRe mgDB02Re = recipeService.selectLineBasicDB02(pageNum-1,pageSize,name);
        return getDataTableDB02(mgDB02Re.getList(),mgDB02Re.getTotal());
    }

    /**
     * 获取DB2003
     */
//    @PreAuthorize("@ss.hasPermi('lineInfo:basic:query')")
    @GetMapping("/stackerrecipe")
    public TableDataInfo getInDB03(queryParams queryparams)
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer page_Num = pageDomain.getPageNum();
        Integer page_Size = pageDomain.getPageSize();
        int pageNum = page_Num.intValue();
        int pageSize = page_Size.intValue();
        String name=queryparams.getStrDataSetName();
//        String name=erstrDataSetName;
        System.out.println("控制层获取的配方名为:"+name);
        System.out.println("===>获取页数和页码");
        System.out.println("===>获取页数和页码");
        System.out.println(pageSize);
        System.out.println(pageNum);

        mgDBRe mgDB02Re = recipeService.selectLineBasicDB03(pageNum-1,pageSize,name);
        return getDataTableDB02(mgDB02Re.getList(),mgDB02Re.getTotal());
    }

    /**
     * 获取DB2005
     */
//    @PreAuthorize("@ss.hasPermi('lineInfo:basic:query')")
    @GetMapping("/pressrecipe")
    public TableDataInfo getInDB05(queryParams queryparams)
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer page_Num = pageDomain.getPageNum();
        Integer page_Size = pageDomain.getPageSize();
        int pageNum = page_Num.intValue();
        int pageSize = page_Size.intValue();
        String name=queryparams.getDie_DieName();
//        String name=erstrDataSetName;
        System.out.println("pressrecipe控制层获取的配方名为:"+name);
        System.out.println("===>获取页数和页码");
        System.out.println("===>获取页数和页码");
        System.out.println(pageSize);
        System.out.println(pageNum);

        mgDBRe mgDBRe = recipeService.selectLineBasicDB05(pageNum-1,pageSize,name);
        return getDataTableDB05(mgDBRe.getList(),mgDBRe.getTotal());
    }

}

