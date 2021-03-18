package qsf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qsf.entity.User;
import qsf.entity.UserTouch;
import qsf.service.IUserService;
import qsf.service.IUserTouchService;

import java.util.List;


@RestController
@RequestMapping("hh")
public class TestControl {
    @Autowired
    private IUserTouchService userTouchService;

    @GetMapping(value = "/test")
    public String hello(){
//        System.out.println(userTouchService.selectUid("a", 2).size());
        System.out.println(userTouchService.countUserTouchByUid("test"));

        return "test";
    }
}
