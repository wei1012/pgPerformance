package com.ruoyi.project.performance.slave.domain;

import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 执行机表 t_slave
 * 
 * @author ruoyi
 * @date 2018-08-24
 */
public class Slave extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private Integer slaveId;
	/** 远程ip */
	private String remoteIP;
	/** 远程ip */
	private String lanIP;
	/** 端口 */
	private Integer sshPort;
	/** 用户名 */
	private String userName;
	/** 密码 */
	private String password;
	/** 内存 */
	private Integer memory;
	/** cpu */
	private Integer cpu;
	/** 机器状态 */
	private Integer status;
	/** 1 控制机 2执行机 */
	private Integer type;

	/**
	 * 设置：id
	 */
	public void setSlaveId(Integer slaveId) 
	{
		this.slaveId = slaveId;
	}
	
	/**
	 * 获取：id
	 */
	public Integer getSlaveId() 
	{
		return slaveId;
	}
	
	/**
	 * 设置：远程ip
	 */
	public void setRemoteIP(String remoteIP) 
	{
		this.remoteIP = remoteIP;
	}
	
	/**
	 * 获取：远程ip
	 */
	public String getRemoteIP() 
	{
		return remoteIP;
	}
	
	/**
	 * 设置：远程ip
	 */
	public void setLanIP(String lanIP) 
	{
		this.lanIP = lanIP;
	}
	
	/**
	 * 获取：远程ip
	 */
	public String getLanIP() 
	{
		return lanIP;
	}
	
	/**
	 * 设置：端口
	 */
	public void setSshPort(Integer sshPort) 
	{
		this.sshPort = sshPort;
	}
	
	/**
	 * 获取：端口
	 */
	public Integer getSshPort() 
	{
		return sshPort;
	}
	
	/**
	 * 设置：用户名
	 */
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getUserName() 
	{
		return userName;
	}
	
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	/**
	 * 获取：密码
	 */
	public String getPassword() 
	{
		return password;
	}
	
	/**
	 * 设置：内存
	 */
	public void setMemory(Integer memory) 
	{
		this.memory = memory;
	}
	
	/**
	 * 获取：内存
	 */
	public Integer getMemory() 
	{
		return memory;
	}
	
	/**
	 * 设置：cpu
	 */
	public void setCpu(Integer cpu) 
	{
		this.cpu = cpu;
	}
	
	/**
	 * 获取：cpu
	 */
	public Integer getCpu() 
	{
		return cpu;
	}
	
	/**
	 * 设置：机器状态
	 */
	public void setStatus(Integer status) 
	{
		this.status = status;
	}
	
	/**
	 * 获取：机器状态
	 */
	public Integer getStatus() 
	{
		return status;
	}
	
	/**
	 * 设置：1 控制机 2执行机
	 */
	public void setType(Integer type) 
	{
		this.type = type;
	}
	
	/**
	 * 获取：1 控制机 2执行机
	 */
	public Integer getType() 
	{
		return type;
	}
	
}
