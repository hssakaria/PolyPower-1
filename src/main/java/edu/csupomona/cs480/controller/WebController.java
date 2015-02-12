package edu.csupomona.cs480.controller;

import java.io.BufferedOutputStream;
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.IOException;
import java.util.List;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import javax.servlet.http.HttpServletResponse;


//import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import edu.csupomona.cs480.data.codeSubmit;
import edu.csupomona.cs480.data.provider.codeSubmitManager;


/**
 * This is the controller used by Spring framework.
 * <p>
 * The basic function of this controller is to map
 * each HTTP API Path to the correspondent method.
 *
 */

@RestController
public class WebController {

	/**
	 * When the class instance is annotated with
	 * {@link Autowired}, it will be looking for the actual
	 * instance from the defined beans.
	 * <p>
	 * In our project, all the beans are defined in
	 * the {@link App} class.
	 */
   
    @Autowired
    private codeSubmitManager codesubmitManager;	

    /**
     * This is a simple example of how the HTTP API works.
     * It returns a String "OK" in the HTTP response.
     * To try it, run the web application locally,
     * in your web browser, type the link:
     * 	http://localhost:8080/cs480/ping
     */
    @RequestMapping(value = "/cs480/ping", method = RequestMethod.GET)
    String healthCheck() {
    	// You can replace this with other string,
    	// and run the application locally to check your changes
    	// with the URL: http://localhost:8080/
        return "Hello World! Hetal";
    }

    /**
     * This is a simple example of how to use a data manager
     * to retrieve the data and return it as an HTTP response.
     * <p>
     * Note, when it returns from the Spring, it will be
     * automatically converted to JSON format.
     * <p>
     * Try it in your web browser:
     * 	http://localhost:8080/cs480/user/user101
     */
 /*   @RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.GET)
    User getUser(@PathVariable("userId") String userId) {
    	User user = userManager.getUser(userId);
        return user;
    }*/

    @RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.GET)
    codeSubmit getUser(@RequestParam("userId") String userId)
    {
    	codeSubmit codesubmit = codesubmitManager.getUser(userId);
    	return codesubmit;
    }

    //request to update a user's information (or create the user if not exists before)
      
     /*
    @RequestMapping(value="/cs480/user/{userId}", method = RequestMethod.POST)
    codeSubmit updateUser(@PathVariable("userId") String id,
    					  @RequestParam("problemId") String probId){
    	codeSubmit codesubmit = new codeSubmit();
    	codesubmit.setuserId(id);
    	codesubmitManager.updatecodeSubmit(codesubmit);
    	return codesubmit;
    }
    
    */
    /**
     * This API deletes the user. It uses HTTP DELETE method.
     *
     * @param userId
     */
   /* @RequestMapping(value = "/cs480/user/{userId}", method = RequestMethod.DELETE)
    void deleteUser(
    		@PathVariable("userId") String userId) {
    	userManager.deleteUser(userId);
    }
*/
    /**
     * This API lists all the users in the current database.
     *
     * @return
     */
  @RequestMapping(value = "/cs480/users/list", method = RequestMethod.GET)
  //  @RequestMapping(value = "/cs480/codeSubmit", method = RequestMethod.GET)
    List<codeSubmit> listAllUsers() {
    	return codesubmitManager.listAllUsers();
    }
    
    /*
  @RequestMapping(value = "/cs480/users/list", method = RequestMethod.GET)
    List<codeSubmit> listAllProb() {
    	return codesubmitManager.listAllProb();
    }
    
    @RequestMapping(value = "/cs480/users/list", method = RequestMethod.GET)
    List<codeSubmit> listAllFiles() {
    	return codesubmitManager.listAllFiles();
    }
    */
    /*********** Web UI Test Utility **********/

    @RequestMapping(value = "/cs480/home", method = RequestMethod.GET)
    ModelAndView getUserHomepage(){
    	ModelAndView modelAndView = new ModelAndView("home");
    	//modelAndView.addObject("users", listAllUsers());
    	return modelAndView;
    }
    
    /*
     * <tr>
			<#list users as codesubmit>
				<tr>
					<td>${codesubmit.userId}</td>
					<td>${codesubmit.problemId}</td>
					<td>${codesubmit.file}</td>
									
				</tr>		
			</#list>
		</tr>
		
     */
    @RequestMapping(value = "/cs480/codeSubmit", method = RequestMethod.GET)
    ModelAndView getUsercodeSubmit() {
        ModelAndView modelAndView = new ModelAndView("codeSubmit");

        modelAndView.addObject("users", listAllUsers());
       // modelAndView.addObject("problems", listAllUsers());
        modelAndView.addObject("files", listAllUsers());
      //  modelAndView.addObject("problemId", listAllProb());
       // modelAndView.addObject("file", listAllFiles());

       // modelAndView.addObject("files ", listAllFiles());

              
        return modelAndView;
    }
    
    
	@RequestMapping(value = "/cs480/AdminHomepage", method = RequestMethod.GET)
    ModelAndView getAdmin() {
        ModelAndView modelAndView = new ModelAndView("AdminHomepage");

       return modelAndView;
    }
    
    
	@RequestMapping(value = "/cs480/loginHome", method = RequestMethod.GET)
    ModelAndView getlogin() {
        ModelAndView modelAndView = new ModelAndView("loginHome");
     
        return modelAndView;
    }
    /********************************** Testing for Problems **********************************/
    /**
     * Below are all the methods that I am adding to work with displaying Problems.
     */
    
    /**
	 * When the class instance is annotated with
	 * {@link Autowired}, it will be looking for the actual
	 * instance from the defined beans.
	 * <p>
	 * In our project, all the beans are defined in
	 * the {@link App} class.
	 */


    /** 
     * Testing File upload
     * 
     * if you visit 
     * 
     * http://localhost:8080 /cs480/codesubmit
     * 
     * , you can see the upload page .
     * 
     * If the file was upload, 
     * 
     * it will show you the message
     * @return 
     * 
     */

	
  @RequestMapping(value="/cs480/codeSubmit", method=RequestMethod.POST)

	  public	@ResponseBody ModelAndView handleFileUpload(	
			  	@RequestParam(value ="userId" ) String id,
			  	@RequestParam(value = "problemId" ) String promb,
			  	@RequestParam(value ="file") MultipartFile file)
    		//@RequestParam(value ="Status") String stat,
    		//@RequestParam(value = "Week") String weekNo,
    		//@RequestParam(value ="fileName") String file),
          
    {
    	String name = null;

    	if (!file.isEmpty()) {
            try {
            	codeSubmit codesubmit = new codeSubmit();
            	name = file.getOriginalFilename();
             	codesubmit.setuserId(id);
             	codesubmit.setprobId(promb);
            	codesubmit.setFileName(name);
            	
            	//codesubmit.setWeek(weekNo);
            	//codesubmit.setScore("-");
            	            
            	//codesubmit.setStat(stat);
               //	codesubmit.setStatus(true);
              // 	codesubmit.setFilePath(file);
               //	codesubmit.setCreationTime(creationTime);
               	
            	codesubmitManager.updatecodeSubmit(codesubmit);// add
            	//name = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();

            
                ModelAndView modelAndView = new ModelAndView("/codeSubmit");
               return modelAndView;
                
            } catch (Exception e)
              {
            	  ModelAndView modelAndView = new ModelAndView("You failed to upload "  + " => " + e.getMessage());
                	 return modelAndView;
            	}
        }
        else
        {
         	  ModelAndView modelAndView = new ModelAndView("You failed to upload "  + " because the file was empty.");
        	  return modelAndView;
    	}	   	
    	
    } 
}
 