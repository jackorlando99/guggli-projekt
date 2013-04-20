package org.apache.struts.docs.action;

import java.io.File;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;


public class DocsUpAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1807709653998815169L;
	private File uploadFile;
    private String uploadFileContentType;
    private String uploadFileFileName;  
 
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
    	        String filePath = "C:/projectSave";  // Path where uploaded file will be stored
    	        System.out.println("Server path:" + filePath); // check your path in console
    	        //adatbbe menten az filePath+fileName? es majd az lesz a linkben 
    	        // meg amit meg kel menteni adatbbe
    	        File fileToCreate = new File(filePath, uploadFileFileName);// Create file name  same as original
    	        FileUtils.copyFile(uploadFile, fileToCreate); // Just copy temp file content tos this file      
    	 
    	        }catch(Exception e)
    	        {
    	            
    	 
    	        }
        return SUCCESS;
     }
}