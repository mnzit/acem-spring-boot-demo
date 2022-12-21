package com.acem.demo.controller;

import com.acem.demo.request.UserSaveRequest;
import com.acem.demo.response.Response;
import com.acem.demo.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response users() {
        return userService.getAll();
    }


    @PostMapping
    public Response save(@RequestBody @Validated UserSaveRequest request) {
        return userService.save(request);
    }

    @PutMapping
    public String update() {
        return "This is user put request";
    }

}
