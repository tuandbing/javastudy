package com.eagles.controller;


import com.eagles.pojo.User;
import com.eagles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(Model model,String username,String password){

        if(userService.login(username,password) != null){
            return this.list(model);
        }else{
            return "login";
        }
    }

    @RequestMapping("/list")
    public String list(Model model){

        model.addAttribute("userList",userService.getUserList());

        return "list";
    }

}
