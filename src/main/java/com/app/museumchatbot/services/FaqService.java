package com.app.museumchatbot.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.app.museumchatbot.utils.FaqAnswers;

@Service
public class FaqService {
    final private FaqAnswers faqAnswers = new FaqAnswers();

    public String getAnswer(String question){
        String[] words = question.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");

        for (int i = 0; i < faqAnswers.getAnswers().size(); i++) {
            List<String> keywords = faqAnswers.getAnswers().get(i).getKeywords();
            for(String word : words){
                System.out.println(word);
                if(keywords.contains(word)){
                    return faqAnswers.getAnswers().get(i).getAnswer();
                }
            }
        }
        return faqAnswers.getDefaultAnswer();
    }
}
