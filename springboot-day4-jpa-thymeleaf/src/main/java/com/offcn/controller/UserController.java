package com.offcn.controller;

import com.offcn.po.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "list";
    }
    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        return "add";
    }
    @PostMapping("/add")
    public String add(User user){
        userService.add(user);
        return "redirect:/";
    }
    @GetMapping("/toEdit/{id}")
    public String toEdit(Model model,@PathVariable Long id){
        User user = userService.findOne(id);
        model.addAttribute("user",user);
        return "edit";
    }
    @RequestMapping("/edit")
    public String edit(User user){
       userService.update(user);
        return "redirect:/";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        userService.delete(id);
        return "redirect:/";
    }
}
