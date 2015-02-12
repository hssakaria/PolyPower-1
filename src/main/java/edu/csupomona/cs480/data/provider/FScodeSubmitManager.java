package edu.csupomona.cs480.data.provider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.csupomona.cs480.data.codeSubmit;
import edu.csupomona.cs480.data.codeSubmitMap;
import edu.csupomona.cs480.util.ResourceResolver;

/**
 * The implementation of {@link codeSubmitManager} interface
 * using file system.
 * <p>
 * This class demonstrates how you can use the file system
 * as a database to store your data.
 *
 */
public  class FScodeSubmitManager implements codeSubmitManager {

	/**
	 * We persist all the user related objects as JSON.
	 * <p>
	 * For more information about JSON and ObjectMapper, please see:
	 * http://www.journaldev.com/2324/jackson-json-processing-api-in-java-example-tutorial
	 *
	 * or Google tons of tutorials
	 *
	 */
	private static final ObjectMapper JSON = new ObjectMapper();
	
	/**
	 * Load the user map from the local file.
	 *
	 * @return
	 */

	
	private codeSubmitMap getcodeSubmitMap()
	{
		codeSubmitMap codesubmitMap = null;
		codesubmitMap = new codeSubmitMap();
		File userFile = ResourceResolver.getUserFile();
        if (userFile.exists()) {
        	// read the file and convert the JSON content
        	// to the codeSubmitMap object
            try {
				codesubmitMap = JSON.readValue(userFile, codeSubmitMap.class);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
        } 
      ///  else codesubmitMap = new codeSubmitMap();
        return codesubmitMap;
	}
	
	/**
	 * Save and persist the codesubmit map in the local file.
	 *
	 * @param codesubmitMap
	 */
	private void persistcodeSubmitMap(codeSubmitMap codesubmitMap) {
		try {
			// convert the user object to JSON format
            JSON.writeValue(ResourceResolver.getUserFile(), codesubmitMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}


	@Override
	public void updatecodeSubmit(codeSubmit codesubmit) {
		codeSubmitMap codesubmitMap = getcodeSubmitMap();
		//codesubmitMap.put(codesubmit.getuserId(), codesubmit);
		//codesubmitMap.put(codesubmit.getprobId(), codesubmit);
		codesubmitMap.put(codesubmit.getFileName(), codesubmit);
		//codesubmitMap.put(codesubmit.getWeek(), codesubmit);
	//	codesubmitMap.put(codesubmit.getFilePath(), codesubmit);
		persistcodeSubmitMap(codesubmitMap);
		
	}

	@Override
	public codeSubmit getUser(String userId) {
		codeSubmitMap codesubmitMap = getcodeSubmitMap();
        return codesubmitMap.get(userId);
	}
	
	/*@Override
	public codeSubmit getprobId(String problemId) {
		codeSubmitMap probMap = getcodeSubmitMap();
        return probMap.get(problemId);
	}	

	@Override
	public codeSubmit getFilePath(String file) {
		codeSubmitMap fileMap = getcodeSubmitMap();
		return fileMap.get(file);
	}

	@Override
	public codeSubmit getFile(MultipartFile file) {
		codeSubmitMap filePath = getcodeSubmitMap();
		return filePath.get(filePath);
	}

	@Override
	public codeSubmit getWeek(String wk) {
		codeSubmitMap week = getcodeSubmitMap();
		return week.get(week);
	}*/
	@Override
	public List<codeSubmit> listAllUsers() {
		codeSubmitMap codesubmitMap = getcodeSubmitMap();
		return new ArrayList<codeSubmit>(codesubmitMap.values());
		//return new ArrayList<codeSubmit>();
	}
	
	
	@Override
	public List<codeSubmit> listAllFiles() {
		codeSubmitMap fileMap = getcodeSubmitMap();
		return new ArrayList<codeSubmit>(fileMap.values());
		//return new ArrayList<codeSubmit>(codesubmitMap.values());
	}
	/*
	@Override
	public List<codeSubmit> listAllProb() {
		codeSubmitMap problemMap = getcodeSubmitMap();		
		return new ArrayList<codeSubmit>(problemMap.values());
	}
*/

	@Override
	public codeSubmit getFilePath(String file) {
		// TODO Auto-generated method stub
		return null;
	}
}
