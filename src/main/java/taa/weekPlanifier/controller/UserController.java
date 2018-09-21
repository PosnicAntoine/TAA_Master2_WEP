package taa.weekPlanifier.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import taa.weekPlanifier.entities.User;
import taa.weekPlanifier.services.UserDAO;

@RequestMapping("/user")
@Controller
public class UserController {

  /**
   * GET /create  --> Create a new user and save it in the database.
   */
  @RequestMapping(value= "/hello", method = RequestMethod.GET)
  @ResponseBody
  public String hello() {
    return "Hello";
  }

  /**
   * GET /create  --> Create a new user and save it in the database.
   */
  /**
  @RequestMapping("/create/{name}")
  @ResponseBody
  public String create(@PathVariable("name") String name) {
    String userId = "";
    try {
      User user = new User(name);
      userDao.save(user);
      userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "User succesfully created with id = " + userId;
  }
  
  /**
   * GET /delete  --> Delete the user having the passed id.
   */
  /**
  @RequestMapping("/delete/{id}")
  @ResponseBody
  public String delete(@PathVariable("id") long id) {
    try {
      userDao.delete(userDao.findById(id).get());
    }
    catch (Exception ex) {
      return "Error deleting the user:" + ex.toString();
    }
    return "User succesfully deleted!";
  }
  
  /**
   * GET /update  --> Update the name for the user in the 
   * database having the passed id.
   */
  /**
  @RequestMapping("/update/{id}/{name}")
  @ResponseBody
  public String updateUser(@PathVariable("id") long id,@PathVariable("name") String name) {
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
*/
  // Private fields

  @Autowired
  private UserDAO userDao;
  
}