
package edu.csupomona.cs480.data;

import java.util.Date;
import org.springframework.web.multipart.MultipartFile;

/**
 * The basic user object.
 */
public class codeSubmit {


	private String id;
	private String probId;
	private String name;
	private MultipartFile file;
	/*private String filePath;
	private boolean bool;
	private String week;
	private String score;
	private String stat;

    private String creationTime = new Date(System.currentTimeMillis()).toString();

*/
  
    public String getuserId() {
        return id;    
    }
    public void setuserId(String id) {
        this.id = id;
    }
    
    public String getprobId() {
        return probId;
    }
    public void setprobId(String probId) {
        this.probId = probId;
    }
    public String getFileName()
	{
		return name;
	}
	public void setFileName(String name) {
		this.name = name;
	}
    public MultipartFile getFile(){
		return file;
	}
	public void setFile(MultipartFile file)
	{
		this.file = file;
	}
	/*
	
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    } 
    /*
    public String getScore(){
    	return score;
    }
    public void setScore(String score){
    	this.score = score;
    }
    
      
	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}
	public String getStat()
	{
		return stat;
	}	
	public void setStat(String stat){
		this.stat=stat;
	}
	
	
	public boolean getStatus()
	{
		return true;
	}
	public void setStatus(boolean bool) {
		this.bool = bool;
	}
	  public String getWeek(){
	    	return week;
	    }
	    public void setWeek(String week){
	    	this.week = week;
	    }
	    */

	public String getfile() {
		// TODO Auto-generated method stub
		return null;
	}
	
}


  
