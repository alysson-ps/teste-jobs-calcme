package com.jobs.api.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.json.JSONObject;
import org.json.JSONException;

import com.jobs.api.repository.UserRepository;
import com.jobs.api.document.User;

@RestController
public class UserController{
    @Autowired
    private UserRepository repository;

    @CrossOrigin(origins = "/**")
    @GetMapping("/user")
	public String listUsersById(@RequestParam(value="id") String id) throws JSONException{
        JSONObject jsonResponse = new JSONObject();
        User user = repository.findById(id).orElse(null);

        jsonResponse.put("user", user.response());
        
		return jsonResponse.toString();
	}
    @CrossOrigin(origins = "/**")
    @PostMapping("/user")
	public String createUser(@RequestBody String resquestBody) throws JSONException{
        JSONObject jsonResponse = new JSONObject();
        JSONObject body = new JSONObject(resquestBody);
        User userSaved = repository.save(new User(body.get("name").toString()));

        jsonResponse.put("user", userSaved.response());

        return jsonResponse.toString();
	}
}