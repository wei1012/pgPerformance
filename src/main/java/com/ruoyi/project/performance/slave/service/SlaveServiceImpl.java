package com.ruoyi.project.performance.slave.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.performance.slave.mapper.SlaveMapper;
import com.ruoyi.project.performance.slave.domain.Slave;
import com.ruoyi.project.performance.slave.service.ISlaveService;
import com.ruoyi.common.support.Convert;

/**
 * 执行机 服务层实现
 * 
 * @author ruoyi
 * @date 2018-08-24
 */
@Service
public class SlaveServiceImpl implements ISlaveService 
{
	@Autowired
	private SlaveMapper slaveMapper;

	/**
     * 查询执行机信息
     * 
     * @param slaveId 执行机ID
     * @return 执行机信息
     */
    @Override
	public Slave selectSlaveById(Integer slaveId)
	{
	    return slaveMapper.selectSlaveById(slaveId);
	}
	
	/**
     * 查询执行机列表
     * 
     * @param slave 执行机信息
     * @return 执行机集合
     */
	@Override
	public List<Slave> selectSlaveList(Slave slave)
	{
	    return slaveMapper.selectSlaveList(slave);
	}
	
    /**
     * 新增执行机
     * 
     * @param slave 执行机信息
     * @return 结果
     */
	@Override
	public int insertSlave(Slave slave)
	{
	    return slaveMapper.insertSlave(slave);
	}
	
	/**
     * 修改执行机
     * 
     * @param slave 执行机信息
     * @return 结果
     */
	@Override
	public int updateSlave(Slave slave)
	{
	    return slaveMapper.updateSlave(slave);
	}

	/**
     * 删除执行机对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSlaveByIds(String ids)
	{
		return slaveMapper.deleteSlaveByIds(Convert.toStrArray(ids));
	}
	
}
