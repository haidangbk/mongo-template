package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.User;
import com.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/")
	public String getAllUser(Model model) {
		List<User> users = userService.findAllUser();
		model.addAttribute("users", users);
		return "user/listUser";
	}

	@GetMapping(value = "/detail-user")
	public String getUserById(Model model, @RequestParam(name = "id") String id) {
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		return "user/detailUser";
	}

	@GetMapping(value = "/add-user")
	public String addUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "user/addUser";
	}

	@PostMapping(value = "/add-user")
	public String addUser(@ModelAttribute(name = "user") User user) {
		if (user.getName() == null || user.getName().isEmpty()) {
			return "user/addUser";
		}
		userService.addUser(user);
		return "redirect:/";
	}
	
	
	@GetMapping(value="/update-user")
	public String updateUser(Model model,@RequestParam(name="id") String id) {
		User user = userService.findUserById(id);
		model.addAttribute("user", user);
		return "user/updateUser";
	}
	
	@PostMapping(value="/update-user")
	public String updateUser(@ModelAttribute(name = "user") User user,@RequestParam(name="id") String id) {
		user.set_id(id);
		userService.updateUser(user);
		return "redirect:/";
	}
	
	@GetMapping(value="/delete-user")
	public String deleteUser(@RequestParam(name="id") String id) {
		User user = userService.findUserById(id);
		userService.deleteUser(user);
		return "redirect:/";
	}
	
	@PostMapping(value="/search-user")
	public String searchUser(Model model,@RequestParam(name="search")String search) {
		List<User> users = userService.searchUser(search);
		model.addAttribute("users", users);
		return "user/listUser";
	}
}
