package com.app.museumchatbot.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.museumchatbot.dto.MessageRequest;

@RestController
@RequestMapping("api/chat")
public class FaqController {
    @PostMapping
    public ResponseEntity<String> answerQuestion(@RequestBody MessageRequest request){
        System.out.println(request.message());
        return ResponseEntity.ok("Deu certo");
    }
}
