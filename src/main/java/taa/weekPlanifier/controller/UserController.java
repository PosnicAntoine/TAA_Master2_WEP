package taa.weekPlanifier.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import taa.weekPlanifier.entities.Activity;
import taa.weekPlanifier.entities.User;
import taa.weekPlanifier.services.ActivityDAO;
import taa.weekPlanifier.services.UserDAO;

@RequestMapping("/user")
@Controller
public class UserController {
  // Private fields

  @Autowired
  private UserDAO userDao;
  
  @Autowired
  private ActivityDAO activityDao;

  /**
   * GET /hello  --> return hello
   */
  @RequestMapping(value= "/hello", method = RequestMethod.GET)
  @ResponseBody
  public String hello() {
    return "Hello";
  }

  /**
   * POST /create  --> Create a new user and save it in the database.
   */
 
  @RequestMapping(value= "/create", method = RequestMethod.POST)
  @ResponseBody
  public String create(@RequestParam("user") User user) {
    String userId = "";
    try {
      userDao.save(user);
      userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "User succesfully created with id = " + userId;
  }

  /**
   * POST /update  --> Update the name for the user in the 
   * database having the passed id.
   */
  
  @RequestMapping(value= "/update", method = RequestMethod.POST)
  @ResponseBody
  public String updateUser(@RequestParam("id") long id,@RequestParam("name") String name) {
    try {
      User user = userDao.findById(id).get();
      user.setName(name);
      userDao.save(user);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "User succesfully updated!";
  }
  
  /**
   * DELETE /delete  --> Delete the user having the passed id.
   */
  
  @RequestMapping(value= "/delete", method = RequestMethod.DELETE)
  @ResponseBody
  public String delete(@RequestParam("id") long id) {
    try {
      userDao.delete(userDao.findById(id).get());
    }
    catch (Exception ex) {
      return "Error deleting the user:" + ex.toString();
    }
    return "User succesfully deleted!";
  }
  
  /**
   * GET /getUser  --> Get the user of the passed id.
   */
  
  @RequestMapping(value= "/getUser", method = RequestMethod.GET)
  @ResponseBody
  public User getUser(@RequestParam("id") long id) {
	  try {
		  return userDao.findById(id).get();
	  }
	  catch (Exception ex) {
	      System.out.println("Error getting the user:" + ex.toString());
	  }
	  return null;
  }
  

  /**
   * GET /getAllUser  --> Get all of the users.
   */
  
  @RequestMapping(value= "/getAllUser", method = RequestMethod.GET)
  @ResponseBody
  public java.util.List<User> getAllUser() {
	  try {
		  return userDao.findAll();
	  }
	  catch (Exception ex) {
	      System.out.println("Error getting the users:" + ex.toString());
	  }
	  return null;
  }
}