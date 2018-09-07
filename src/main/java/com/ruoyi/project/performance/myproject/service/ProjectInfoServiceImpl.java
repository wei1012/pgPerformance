package com.ruoyi.project.performance.myproject.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.support.Convert;
import com.ruoyi.project.performance.myproject.domain.ProjectInfo;
import com.ruoyi.project.performance.myproject.mapper.ProjectInfoMapper;

/**
 * 项目 服务层实现
 * 
 * @author ruoyi
 * @date 2018-08-23
 */
@Service
public class ProjectInfoServiceImpl implements IProjectInfoService 
{
	@Autowired
	private ProjectInfoMapper projectInfoMapper;

	/**
     * 查询项目信息
     * 
     * @param projectId 项目ID
     * @return 项目信息
     */
    @Override
	public ProjectInfo selectProjectInfoById(Integer projectId)
	{
	    return projectInfoMapper.selectProjectInfoById(projectId);
	}
	
	/**
     * 查询项目列表
     * 
     * @param projectInfo 项目信息
     * @return 项目集合
     */
	@Override
	public List<ProjectInfo> selectProjectInfoList(ProjectInfo projectInfo)
	{
	    return projectInfoMapper.selectProjectInfoList(projectInfo);
	}
	
    /**
     * 新增项目
     * 
     * @param projectInfo 项目信息
     * @return 结果
     */
	@Override
	public int insertProjectInfo(ProjectInfo projectInfo)
	{
	    return projectInfoMapper.insertProjectInfo(projectInfo);
	}
	
	/**
     * 修改项目
     * 
     * @param projectInfo 项目信息
     * @return 结果
     */
	@Override
	public int updateProjectInfo(ProjectInfo projectInfo)
	{
	    return projectInfoMapper.updateProjectInfo(projectInfo);
	}

	/**
     * 删除项目对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProjectInfoByIds(String ids)
	{
		return projectInfoMapper.deleteProjectInfoByIds(Convert.toStrArray(ids));
	}
	
}
