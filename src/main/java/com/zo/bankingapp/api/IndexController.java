package com.zo.bankingapp.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("<center><h1>Banking App</h1></center>");
    }
}
