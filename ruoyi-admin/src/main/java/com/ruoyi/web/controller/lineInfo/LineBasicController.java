package com.ruoyi.web.controller.lineInfo;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.page.TableSupport;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.sql.SqlUtil;
import com.ruoyi.lineInfo.domain.*;
import com.ruoyi.lineInfo.service.ILineBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 产线管理Controller
 * 
 * @author mazijian
 * @date 2021-11-17
 */
@RestController
@RequestMapping("/lineInfo/basic")
public class LineBasicController extends BaseController
{
    @Autowired
    private ILineBasicService lineBasicService;



    /**
     * 导出产线管理列表
     */
    @PreAuthorize("@ss.hasPermi('lineInfo:basic:export')")
    @Log(title = "产线管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(LineBasic lineBasic)
    {
        List<LineBasic> list = lineBasicService.selectLineBasicList(lineBasic);
        ExcelUtil<LineBasic> util = new ExcelUtil<LineBasic>(LineBasic.class);
        return util.exportExcel(list, "产线管理数据");
    }

    /**
     * 获取产线管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lineInfo:basic:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(lineBasicService.selectLineBasicById(id));
    }

    /**
     * 获取DB2000
    */
    @PreAuthorize("@ss.hasPermi('lineInfo:basic:query')")
    @GetMapping()
    public TableDataInfo getInfoDB00()
    {
        List<DB00mg> list= lineBasicService.selectLineBasicDB00();
        return getDataTable(list);
    }
    /**
     * 获取DB2001
     */
//    @PreAuthorize("@ss.hasPermi('lineInfo:basic:query')")
    @GetMapping("/db01")
    public TableDataInfo getInDB01()
    {
        List<DB01mg> list= lineBasicService.selectLineBasicDB01();
        return getDataTable(list);
    }

    /**
     * 查询产线管理列表
     */
    @PreAuthorize("@ss.hasPermi('lineInfo:basic:list')")
    @GetMapping("/list")
    public TableDataInfo list(LineBasic lineBasic)
    {
        startPage();
        List<LineBasic> list = lineBasicService.selectLineBasicList(lineBasic);
        return getDataTable(list);
    }
    /**
     * 获取DB2002
     */
//    @PreAuthorize("@ss.hasPermi('lineInfo:basic:query')")
//    @GetMapping("/db02")
//    public TableDataInfo getInDB02()
//    {
//        mgDB02Re mgDB02Re = lineBasicService.selectLineBasicDB02();
//        return getDataTableDB02(mgDB02Re.getList(),mgDB02Re.getTotal());
//    }

    /**
     * 新增产线管理
     */
    @PreAuthorize("@ss.hasPermi('lineInfo:basic:add')")
    @Log(title = "产线管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LineBasic lineBasic)
    {
        return toAjax(lineBasicService.insertLineBasic(lineBasic));
    }

    /**
     * 修改产线管理
     */
    @PreAuthorize("@ss.hasPermi('lineInfo:basic:edit')")
    @Log(title = "产线管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LineBasic lineBasic)
    {
        return toAjax(lineBasicService.updateLineBasic(lineBasic));
    }

    /**
     * 删除产线管理1
     */
    @PreAuthorize("@ss.hasPermi('lineInfo:basic:remove')")
    @Log(title = "产线管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lineBasicService.deleteLineBasicByIds(ids));
    }
}
