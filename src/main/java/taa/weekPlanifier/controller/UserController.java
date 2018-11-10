package taa.weekPlanifier.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import taa.weekPlanifier.entities.dto.UserDTO;
import taa.weekPlanifier.services.facade.UserService;

@CrossOrigin
@RequestMapping("/user")
@Controller
public class UserController {
  // Private fields
  @Autowired
  private UserService userService;

  /**
   * GET /hello  --> return hello
   */
  //Done on front
  @RequestMapping(value= "/hello", method = RequestMethod.GET)
  @ResponseBody
  public String hello() {
    return "Hello";
  }

  /**
   * POST /create  --> Create a new user and save it in the database.
   */
  //Done on front
  @RequestMapping(value= "/create", method = RequestMethod.POST)
  @ResponseBody
  public String create(@RequestBody UserDTO user) {
	  return userService.create(user);	
  }

  /**
   * POST /update  --> Update the user in the 
   * database.
   */
  //Done on front
  @RequestMapping(value= "/update", method = RequestMethod.POST)
  @ResponseBody
  public String updateUser(@RequestParam("id") Long id,@RequestBody UserDTO user) {
      return userService.update(id, user);
  }
  

  /**
   * POST /addAddress  --> add the address passed by id in user
   * 
   */
  //TODO on front
  @RequestMapping(value= "/addAddress", method = RequestMethod.POST)
  @ResponseBody
  public String updateUser(@RequestParam("id") Long id,@RequestParam("idAddress") Long idAddress) {
      return userService.addAddress(id, idAddress);
  }
  
  /**
   * DELETE /delete  --> Delete the user having the passed id.
   */
  //Done on front
  @RequestMapping(value= "/delete", method = RequestMethod.DELETE)
  @ResponseBody
  public String delete(@RequestParam("id") Long id) {
	  return userService.delete(id);
  }
  
  /**
   * GET /getUser  --> Get the user of the passed id.
   */
  //Done on front
  @RequestMapping(value= "/getUser", method = RequestMethod.GET)
  @ResponseBody
  public UserDTO getUser(@RequestParam("id") Long id) {
	  return userService.getUser(id);
  }
  

  /**
   * GET /getAllUser  --> Get all of the users.
   */
  //Done on front
  @RequestMapping(value= "/getAllUser", method = RequestMethod.GET)
  @ResponseBody
  public java.util.List<UserDTO> getAllUser() {
	  return userService.getAllUser();
  }
}
