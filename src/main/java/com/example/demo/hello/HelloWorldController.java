package com.example.demo.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController{

@RequestMapping(method = RequestMethod.GET, path= "/helloworld1")
public String helloworld(){
    return "hello world";
}
@GetMapping("/helloworld-bean")
public UserDetails helloWorldBean(){

    return new UserDetails("gyan","prakash","Bangalore");
}
}

