package org.oguz.platform.controllers;

import org.oguz.platform.business.model.impl.User;
import org.oguz.platform.business.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController
{

	private IUserService userService;

	@Autowired(required=true)
	@Qualifier("userService")
	private void setUserService(IUserService userService)
	{
		this.userService = userService;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(Model model) {
 
		model.addAttribute("message", "Spring 4 MVC ");
		return "home";
 
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model)
	{

		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.listUsers());
		return "user";

	}

	// For add and update user both
	@RequestMapping(value = "/add/user", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User u)
	{

		if (u.getIdUser() == 0)
		{
			// new user, add it
			this.userService.addUser(u);
		}
		else
		{
			// existing user, call update
			this.userService.updateUser(u);
		}

		return "redirect:/users";

	}

	@RequestMapping("/remove/user/{id}")
	public String removeUser(@PathVariable("id") int id)
	{

		this.userService.removeUser(id);
		return "redirect:/users";
	}

	@RequestMapping("/edit/user/{id}")
	public String editUser(@PathVariable("id") int id, Model model)
	{
		model.addAttribute("user", this.userService.getUserById(id));
		model.addAttribute("listPersons", this.userService.listUsers());
		return "user";
	}


}
