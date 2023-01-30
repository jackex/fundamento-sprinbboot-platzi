package com.fundamentosplatzi.springboot.fundamentos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class TestController {

    @RequestMapping("/app")
    @ResponseBody
    public ResponseEntity<String> function(){
        return new ResponseEntity<String>("Hello from controller with devtools!!!", HttpStatus.OK);
    }
}
