package com.marufcode.jobportal.controller;

import com.marufcode.jobportal.entity.Users;
import com.marufcode.jobportal.entity.UsersType;
import com.marufcode.jobportal.services.UsersService;
import com.marufcode.jobportal.services.UsersTypeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsersController {
    private final UsersTypeService usersTypeService;
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersTypeService usersTypeService, UsersService usersService){
        this.usersTypeService = usersTypeService;
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String register(Model model){
        List<UsersType> usersTypes = usersTypeService.getAll();

        model.addAttribute("getAllTypes",usersTypes);
        model.addAttribute("user", new Users());

        return "register";
    }

    @PostMapping("/register/new")
    public String userRegistraion(@Valid Users users)
    {
        System.out.println(users);

        usersService.addNew(users);

        return "dashboard";
    }





}
