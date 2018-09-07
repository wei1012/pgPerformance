package com.ruoyi.project.performance.myproject.service;


import java.util.List;

import com.ruoyi.project.performance.myproject.domain.ProjectInfo;

/**
 * 项目 服务层
 * 
 * @author ruoyi
 * @date 2018-08-23
 */
public interface IProjectInfoService 
{
	/**
     * 查询项目信息
     * 
     * @param projectId 项目ID
     * @return 项目信息
     */
	public ProjectInfo selectProjectInfoById(Integer projectId);
	
	/**
     * 查询项目列表
     * 
     * @param projectInfo 项目信息
     * @return 项目集合
     */
	public List<ProjectInfo> selectProjectInfoList(ProjectInfo projectInfo);
	
	/**
     * 新增项目
     * 
     * @param projectInfo 项目信息
     * @return 结果
     */
	public int insertProjectInfo(ProjectInfo projectInfo);
	
	/**
     * 修改项目
     * 
     * @param projectInfo 项目信息
     * @return 结果
     */
	public int updateProjectInfo(ProjectInfo projectInfo);
		
	/**
     * 删除项目信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteProjectInfoByIds(String ids);
	
}
