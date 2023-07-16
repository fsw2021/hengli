package com.ruoyi.web.controller.lineInfo;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.lineInfo.domain.LineTask;
import com.ruoyi.lineInfo.service.ILineTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 生产任务管理Controller
 * 
 * @author mazijian
 * @date 2021-12-10
 */
@RestController
@RequestMapping("/lineInfo/task")
public class LineTaskController extends BaseController
{
    @Autowired
    private ILineTaskService lineTaskService;

    /**
     * 查询生产任务管理列表
     */
    @PreAuthorize("@ss.hasPermi('lineInfo:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(LineTask lineTask)
    {
        startPage();
        List<LineTask> list = lineTaskService.selectLineTaskList(lineTask);
        return getDataTable(list);
    }

    /**
     * 导出生产任务管理列表
     */
    @PreAuthorize("@ss.hasPermi('lineInfo:task:export')")
    @Log(title = "生产任务管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(LineTask lineTask)
    {
        List<LineTask> list = lineTaskService.selectLineTaskList(lineTask);
        ExcelUtil<LineTask> util = new ExcelUtil<LineTask>(LineTask.class);
        return util.exportExcel(list, "生产任务管理数据");
    }

    /**
     * 获取生产任务管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lineInfo:task:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(lineTaskService.selectLineTaskById(id));
    }

    /**
     * 新增生产任务管理
     */
    @PreAuthorize("@ss.hasPermi('lineInfo:task:add')")
    @Log(title = "生产任务管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LineTask lineTask)
    {
        return toAjax(lineTaskService.insertLineTask(lineTask));
    }

    /**
     * 修改生产任务管理
     */
    @PreAuthorize("@ss.hasPermi('lineInfo:task:edit')")
    @Log(title = "生产任务管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LineTask lineTask)
    {
        return toAjax(lineTaskService.updateLineTask(lineTask));
    }

    /**
     * 删除生产任务管理
     */
    @PreAuthorize("@ss.hasPermi('lineInfo:task:remove')")
    @Log(title = "生产任务管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(lineTaskService.deleteLineTaskByIds(ids));
    }
}
