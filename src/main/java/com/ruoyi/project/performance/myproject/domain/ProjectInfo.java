package com.ruoyi.project.performance.myproject.domain;

import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 项目表 t_project_info
 * 
 * @author ruoyi
 * @date 2018-08-23
 */
public class ProjectInfo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 项目id */
	private Integer projectId;
	/** 项目名称 */
	private String projectName;
	/** 项目开始时间 */
	private Date projectStartDate;
	/** 项目开始时间 */
	private Date projectEndDate;
	/** 项目版本 */
	private String projectversion;
	/** 状态 */
	private Integer status;
	/** 项目描述 */
	private String projectContent;
	/** 所属控制机 */
	private Integer slaveId;

	/**
	 * 设置：项目id
	 */
	public void setProjectId(Integer projectId) 
	{
		this.projectId = projectId;
	}
	
	/**
	 * 获取：项目id
	 */
	public Integer getProjectId() 
	{
		return projectId;
	}
	
	/**
	 * 设置：项目名称
	 */
	public void setProjectName(String projectName) 
	{
		this.projectName = projectName;
	}
	
	/**
	 * 获取：项目名称
	 */
	public String getProjectName() 
	{
		return projectName;
	}
	
	/**
	 * 设置：项目开始时间
	 */
	public void setProjectStartDate(Date projectStartDate) 
	{
		this.projectStartDate = projectStartDate;
	}
	
	/**
	 * 获取：项目开始时间
	 */
	public Date getProjectStartDate() 
	{
		return projectStartDate;
	}
	
	/**
	 * 设置：项目开始时间
	 */
	public void setProjectEndDate(Date projectEndDate) 
	{
		this.projectEndDate = projectEndDate;
	}
	
	/**
	 * 获取：项目开始时间
	 */
	public Date getProjectEndDate() 
	{
		return projectEndDate;
	}
	
	/**
	 * 设置：项目版本
	 */
	public void setProjectversion(String projectversion) 
	{
		this.projectversion = projectversion;
	}
	
	/**
	 * 获取：项目版本
	 */
	public String getProjectversion() 
	{
		return projectversion;
	}
	
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) 
	{
		this.status = status;
	}
	
	/**
	 * 获取：状态
	 */
	public Integer getStatus() 
	{
		return status;
	}
	
	/**
	 * 设置：项目描述
	 */
	public void setProjectContent(String projectContent) 
	{
		this.projectContent = projectContent;
	}
	
	/**
	 * 获取：项目描述
	 */
	public String getProjectContent() 
	{
		return projectContent;
	}
	
	/**
	 * 设置：所属控制机
	 */
	public void setSlaveId(Integer slaveId) 
	{
		this.slaveId = slaveId;
	}
	
	/**
	 * 获取：所属控制机
	 */
	public Integer getSlaveId() 
	{
		return slaveId;
	}
	
}
