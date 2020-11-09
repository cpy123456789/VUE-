package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/childrenmanagement/api/axios")

public class AxiosController {

    @GetMapping("/noparams1")
    @CrossOrigin
    public List<User> noparams1(){

        List<User> list = new ArrayList<>();
        list.add(new User("cpya",18));
        list.add(new User("cpyb",19));
        list.add(new User("cpyc",20));
        return list;
    }
    //localhost:8080/axios/{name}

    @GetMapping("/getName1")
    @CrossOrigin
    public List<User> getName1(String name) {
        System.out.println(name);
        List<User> list = new ArrayList<>();
        list.add(new User(name,18));
        list.add(new User("cpyb",19));
        list.add(new User("cpyc",20));
        return list;
    }

    @PostMapping("/noparams2")
    @CrossOrigin
    public List<User> noparams2(){

        List<User> list = new ArrayList<>();
        list.add(new User("cpya",18));
        list.add(new User("cpyb",19));
        list.add(new User("cpyc",20));
        return list;
    }

    @PostMapping("/getName2")
    @CrossOrigin
    public List<User> getName2(String name) {
        System.out.println(name);
        List<User> list = new ArrayList<>();
        list.add(new User(name,18));
        list.add(new User("cpyb",19));
        list.add(new User("cpyc",20));
        return list;
    }

}
