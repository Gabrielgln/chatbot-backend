package com.app.museumchatbot.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.museumchatbot.domain.FaqAnswer;
import com.app.museumchatbot.utils.FaqAnswers;

@Service
public class FaqService {
    final private FaqAnswers faqAnswers = new FaqAnswers();

    public String getAnswer(String question){
        String[] words = question.toLowerCase().split("\\s+");

        for (int i = 0; i < faqAnswers.getAnswers().size(); i++) {
            List<String> keywords = faqAnswers.getAnswers().get(i).getKeywords();
            for(String word : words){
                if(keywords.contains(word)){
                    return faqAnswers.getAnswers().get(i).getAnswer();
                }
            }
        }
        return faqAnswers.getDefaultAnswer();
    }
}
