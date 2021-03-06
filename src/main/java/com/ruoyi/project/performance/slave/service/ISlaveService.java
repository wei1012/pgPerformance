package com.ruoyi.project.performance.slave.service;

import com.ruoyi.project.performance.slave.domain.Slave;
import java.util.List;

/**
 * 执行机 服务层
 * 
 * @author ruoyi
 * @date 2018-08-24
 */
public interface ISlaveService 
{
	/**
     * 查询执行机信息
     * 
     * @param slaveId 执行机ID
     * @return 执行机信息
     */
	public Slave selectSlaveById(Integer slaveId);
	
	/**
     * 查询执行机列表
     * 
     * @param slave 执行机信息
     * @return 执行机集合
     */
	public List<Slave> selectSlaveList(Slave slave);
	
	/**
     * 新增执行机
     * 
     * @param slave 执行机信息
     * @return 结果
     */
	public int insertSlave(Slave slave);
	
	/**
     * 修改执行机
     * 
     * @param slave 执行机信息
     * @return 结果
     */
	public int updateSlave(Slave slave);
		
	/**
     * 删除执行机信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSlaveByIds(String ids);
	
}
