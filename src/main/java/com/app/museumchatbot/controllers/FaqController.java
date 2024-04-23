package com.app.museumchatbot.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.museumchatbot.dto.MessageRequest;
import com.app.museumchatbot.dto.MessageResponse;
import com.app.museumchatbot.services.FaqService;

@RestController
@RequestMapping("api/chat")
public class FaqController {
    final private FaqService faqService;

    public FaqController(FaqService faqService){
        this.faqService = faqService;
    }

    @PostMapping
    public ResponseEntity<MessageResponse> answerQuestion(@RequestBody MessageRequest request){
        String answer = this.faqService.getAnswer(request.message());
        return ResponseEntity.ok(new MessageResponse(answer));
    }
}
