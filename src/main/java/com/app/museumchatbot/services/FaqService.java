package com.app.museumchatbot.services;

import org.springframework.stereotype.Service;

import com.app.museumchatbot.utils.FaqAnswers;

@Service
public class FaqService {
    final private FaqAnswers faqAnswers = new FaqAnswers();

    public String getAnswer(String question){
        String[] words = question.toLowerCase().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if(faqAnswers.getAnswers().get(i).getKeywords().contains(words[i].toLowerCase())){
                return faqAnswers.getAnswers().get(i).getAnswer();
            }
        }
        return faqAnswers.getDefaultAnswer();
    }
}
