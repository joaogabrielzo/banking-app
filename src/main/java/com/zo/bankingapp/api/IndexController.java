package com.zo.bankingapp.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String index(){
        return "<center><h1>Banking App</h1></center>";
    }
}
