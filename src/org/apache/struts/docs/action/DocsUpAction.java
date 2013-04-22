package org.apache.struts.docs.action;

import java.io.File;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts.dbconn.DBConn;

public class DocsUpAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1807709653998815169L;
	private File uploadFile;
    private String uploadFileContentType;
    private String uploadFileFileName;  
	private DBConn dbc; 

    public File getUploadFile() {
        return uploadFile;
    }
    public void setUploadFile(File uploadFile) {
        this.uploadFile = uploadFile;
    }
 
    public String getUploadFileContentType() {
        return uploadFileContentType;
    }
    public void setUploadFileContentType(String uploadFileContentType) {
        this.uploadFileContentType = uploadFileContentType;
    }
 
    public String getUploadFileFileName() {
        return uploadFileFileName;
    }
    public void setUploadFileFileName(String uploadFileFileName) {
        this.uploadFileFileName = uploadFileFileName;
    }
     public String execute() {
    	  try{
    	        String filePath = "C:/projectSave"; 
    	        System.out.println("Server path:" + filePath);
    	        File fileToCreate = new File(filePath, uploadFileFileName);
    	        FileUtils.copyFile(uploadFile, fileToCreate);
    			dbc = new DBConn();
    				dbc.connect(); 
    				dbc.docUp(1,uploadFileFileName,filePath+uploadFileFileName);
    				//System.out.println(dbc.lekerdezUserName());
    	  }catch(Exception e)
    	        {
    	        	System.out.println("NEM: "+e.getMessage());
    	 
    	        }
        return SUCCESS;
     }
}