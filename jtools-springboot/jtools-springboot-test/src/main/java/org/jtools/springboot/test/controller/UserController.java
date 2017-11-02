package org.jtools.springboot.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.jtools.springboot.test.entity.User;
import org.jtools.springboot.test.service.IUserService;
import org.jtools.springboot.test.service.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<User> getUsers() {
		return userService.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") int id) {
		Map<Object, Object> paramsMap = new HashMap<Object, Object>();
		paramsMap.put("id", id);
		return userService.findEntityByCondition(paramsMap);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateUser(@PathVariable("id") int id,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "age", required = true) int age) {
		User user = this.getUserById(id);
		user.setAge(age);
		user.setName(name);
		userService.updateEntity(user);
		return "success";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String addUser(@RequestParam(value = "name") String name,
			@RequestParam(value = "age") int age) {
		User user = new User();
		user.setId(UUID.randomUUID().toString().replace("-", ""));
		user.setAge(age);
		user.setName(name);
		userService.saveEntity(user);
		return "success";
	}
}
