package qsf.controller;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import qsf.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import qsf.service.IUserService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/register")
    @ResponseBody
    public String getUser(@RequestBody User user){

        userService.insert(user);
        return "ok";
    }

    @GetMapping(value = "/test")
    public String hello(){
        return "test";
    }
}
