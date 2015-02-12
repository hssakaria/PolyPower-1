package edu.csupomona.cs480.data.provider;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;



import edu.csupomona.cs480.data.codeSubmit;

public interface codeSubmitManager {

	/**
	 * Get the user information object based on
	 * the given userId.
	 * <p>
	 * If the user does not exist, simply create
	 * one.
	 *
	 * @param userId
	 * @return the User object
	 */
	public codeSubmit getUser(String userId);	
	//public codeSubmit getprobId(String problemId);
	public codeSubmit getFilePath(String file);
	//public codeSubmit getFile(MultipartFile file);
	//public codeSubmit getWeek(String week);
	
	/**
	 * Update the given user object and persist it.
	 * <p>
	 * If the user does not exist before, this
	 * method will create a new record; otherwise,
	 * it will overwrite whatever is currently
	 * being stored.
	 *
	 * @param user object
	 */
	public void updatecodeSubmit(codeSubmit codesubmit);

	/**
	 * List all the current users in the storage.
	 *
	 * @return
	 */
	public List<codeSubmit> listAllUsers();
	//public List<codeSubmit> listAllProb();
	public List<codeSubmit> listAllFiles();
	//public List<codeSubmit> listAllProblems();
	
	

}
