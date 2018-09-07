package com.ruoyi.project.performance.slave.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;



import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;

import com.mongodb.gridfs.GridFSInputFile;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.constant.BusinessType;
import com.ruoyi.framework.mongo.MongoFileUtils;
import com.ruoyi.project.performance.slave.domain.Slave;
import com.ruoyi.project.performance.slave.service.ISlaveService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.gridfs.GridFsCriteria.whereFilename;

/**
 * 执行机 信息操作处理
 * 
 * @author ruoyi
 * @date 2018-08-24
 */
@Controller
@RequestMapping("/performance/slave")
public class SlaveController extends BaseController
{
    private String prefix = "performance/slave";
	
	@Autowired
	private ISlaveService slaveService;
	@Autowired
	private MongoTemplate  mongoTemplate;
	  @Autowired
	 private GridFsTemplate gridFsTemplate;
	  @Autowired
	  private MongoDbFactory mongoDbFactory;
/*	  @Autowired
	  private  GridFSBucket gridFSBucket;*/
	@RequiresPermissions("performance:slave:view")
	@GetMapping()
	public String slave()
	{
	    return prefix + "/slave";
	}
	
	/**
	 * 查询执行机列表
	 * @throws IOException 
	 */
	@RequiresPermissions("performance:slave:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Slave slave) throws IOException
	{
		
		/*Resource file = new ClassPathResource("C:\\weiji.jtl");*/
		/* String path="C:\\weiji1.jtl";
         path=path.replace("\\\\", "/");
       File file=  new File(path);
       

       InputStream input = new FileInputStream(file);
       
        try {
          gridFsTemplate.store(input, file.getName(), "jtl");
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        //下载
        String file1=file.getName();
        GridFSFindIterable result = gridFsTemplate.find(query(whereFilename().is(file1)));
       
        GridFSFile gridFsFile=  result.first();
        
        MongoDatabase db = mongoDbFactory.getDb();
      
        
        
        GridFSDownloadStream gridFSDownloadStream = GridFSBuckets.create(db).openDownloadStream(gridFsFile.getObjectId());
        GridFsResource  gr=   new GridFsResource(gridFsFile, gridFSDownloadStream);
        File file3=new File("C:\\ceshi\\weiji2.jtl");
        file3.createNewFile();
        OutputStream os = new FileOutputStream(file);
 
        InputStream inputStream=gr.getInputStream();
        OutputStream os = new FileOutputStream(file3);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        while ((bytesRead =inputStream.read(buffer, 0, 8192)) != -1) {
        os.write(buffer, 0, bytesRead);
        }
        os.close();
        inputStream.close();
      */
		MongoFileUtils.addFileMongo("C:\\ceshi\\jojo1.txt");
		/*MongoFileUtils.getFileMongo("jojo", "C:\\ceshi\\jojo1.txt");*/
   
       
		
		startPage();
        List<Slave> list = slaveService.selectSlaveList(slave);
		return getDataTable(list);
	}
	
	/**
	 * 新增执行机
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存执行机
	 */
	@RequiresPermissions("performance:slave:add")
	@Log(title = "执行机", action = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Slave slave)
	{		
		return toAjax(slaveService.insertSlave(slave));
	}

	/**
	 * 修改执行机
	 */
	@GetMapping("/edit/{slaveId}")
	public String edit(@PathVariable("slaveId") Integer slaveId, ModelMap mmap)
	{
		Slave slave = slaveService.selectSlaveById(slaveId);
		mmap.put("slave", slave);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存执行机
	 */
	@RequiresPermissions("performance:slave:edit")
	@Log(title = "执行机", action = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Slave slave)
	{		
		return toAjax(slaveService.updateSlave(slave));
	}
	
	/**
	 * 删除执行机
	 */
	@RequiresPermissions("performance:slave:remove")
	@Log(title = "执行机", action = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(slaveService.deleteSlaveByIds(ids));
	}
	
}
