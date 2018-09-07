package com.ruoyi.project.performance.myproject.controller;

import java.util.List;

import javax.security.auth.Subject;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.constant.BusinessType;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.performance.myproject.domain.ProjectInfo;
import com.ruoyi.project.performance.myproject.service.IProjectInfoService;
import com.ruoyi.framework.web.domain.AjaxResult;

/**
 * 项目 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-08-23
 */
@Controller
@RequestMapping("/module/projectInfo")
public class ProjectInfoController extends BaseController
{
    private String prefix = "performance/projectInfo";
	
	@Autowired
	private IProjectInfoService projectInfoService;
	
	@RequiresPermissions("module:projectInfo:view")
	@GetMapping()
	public String projectInfo()
	{
	    return prefix + "/projectInfo";
	}
	
	/**
	 * 查询项目列表
	 */
	@RequiresPermissions("performance:projectInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ProjectInfo projectInfo)
	{
		
		org.apache.shiro.subject.Subject subject=ShiroUtils.getSubjct();
		System.out.println(subject.isPermitted("module:projectInfo:add"));
		System.out.println(subject.isPermitted("module:projectInfo:remove"));
		startPage();
        List<ProjectInfo> list = projectInfoService.selectProjectInfoList(projectInfo);
		return getDataTable(list);
	}
	
	/**
	 * 新增项目
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存项目
	 */
	@RequiresPermissions("performance:projectInfo:add")
	@Log(title = "项目", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ProjectInfo projectInfo)
	{		
		return toAjax(projectInfoService.insertProjectInfo(projectInfo));
	}

	/**
	 * 修改项目
	 */
	@GetMapping("/edit/{projectId}")
	public String edit(@PathVariable("projectId") Integer projectId, ModelMap mmap)
	{
		ProjectInfo projectInfo = projectInfoService.selectProjectInfoById(projectId);
		mmap.put("projectInfo", projectInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存项目
	 */
	@RequiresPermissions("performance:projectInfo:edit")
	@Log(title = "项目", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ProjectInfo projectInfo)
	{		
		return toAjax(projectInfoService.updateProjectInfo(projectInfo));
	}
	
	/**
	 * 删除项目
	 */
	@RequiresPermissions("performance:projectInfo:remove")
	@Log(title = "项目", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(projectInfoService.deleteProjectInfoByIds(ids));
	}
	
}
