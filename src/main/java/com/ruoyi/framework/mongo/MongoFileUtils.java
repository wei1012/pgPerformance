package com.ruoyi.framework.mongo;

import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.gridfs.GridFsCriteria.whereFilename;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.GridFSFindIterable;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.ruoyi.project.performance.slave.service.ISlaveService;
@Component
public class MongoFileUtils {
	/*@Autowired
	private ISlaveService slaveService;
	@Autowired
	private MongoTemplate  mongoTemplate;
	  @Autowired
	 private GridFsTemplate gridFsTemplate;
	  @Autowired
	  private MongoDbFactory mongoDbFactory;*/
	

	private static ISlaveService slaveService;

	private  static MongoTemplate  mongoTemplate;

	 private static GridFsTemplate gridFsTemplate;
	
	  private static MongoDbFactory mongoDbFactory;	
	  @Autowired(required = true)
	    public  void setSlaveService(ISlaveService slaveService) {
	        this.slaveService = slaveService;
	    }
	  
	  @Autowired(required = true)
	    public  void setMongoTemplate(MongoTemplate mongoTemplate) {
	        this.mongoTemplate = mongoTemplate;
	    }
	  @Autowired(required = true)
	    public  void setGridFsTemplate(GridFsTemplate gridFsTemplate) {
	        this.gridFsTemplate = gridFsTemplate;
	    }
	  @Autowired(required = true)
	    public  void setMongoDbFactory(MongoDbFactory mongoDbFactory) {
	        this.mongoDbFactory = mongoDbFactory;
	    }
	  
	  
	  /**
	     * 根据文件路径上传至mongo
	     *
	     * @param localpath 路径
	     * @param args 参数
	     * @return
	     */ 
	  public static boolean addFileMongo(String localpath) throws FileNotFoundException {;
	  
	  localpath=localpath.replace("\\\\", "/");
    File file=  new File(localpath);
    

    InputStream input = new FileInputStream(file);
    
     try {
       gridFsTemplate.store(input, file.getName().substring(0, file.getName().lastIndexOf(".")), "jtl");
     } catch (Exception e) {
         e.printStackTrace();
         return false;
     }
     return true;
	  }
	  
	  /**
	     * 获取mongodb文件
	     *
	     * @param filename 获取文件名id(唯一)
	     * @param savePath 保存路径名称
	     * @return
	     */ 
	  public static File getFileMongo(String filename,String savePath) throws IOException {
		  /*  //下载
	        String file1=file.getName();*/
	        GridFSFindIterable result = gridFsTemplate.find(query(whereFilename().is(filename)));
	       
	        GridFSFile gridFsFile=  result.first();
	        
	        MongoDatabase db = mongoDbFactory.getDb();
	      
	        
	        
	        GridFSDownloadStream gridFSDownloadStream = GridFSBuckets.create(db).openDownloadStream(gridFsFile.getObjectId());
	        GridFsResource  gr=   new GridFsResource(gridFsFile, gridFSDownloadStream);
	        File file=new File(savePath);
            file.createNewFile();
	        InputStream inputStream=gr.getInputStream();
	        OutputStream os = new FileOutputStream(file);
	        int bytesRead = 0;
	        byte[] buffer = new byte[8192];
	        while ((bytesRead =inputStream.read(buffer, 0, 8192)) != -1) {
	        os.write(buffer, 0, bytesRead);
	        }
	        os.close();
	        inputStream.close();
	      
		  return file;
		  
		  
		
	}
	  
}
