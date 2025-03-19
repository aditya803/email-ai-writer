package com.email.email_ai.app;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailGeneratorService {

    @Value("${gemini.api.url}")
    private String geminiApiUrl;
    
    @Value("${gemini.api.key}")
    private String geminiApiKey;

    public String generateEmailReply(EmailRequest emailRequest){
        //Build the prompt
        String prompt = buildPrompt(emailRequest);
        
        //Craft a reaquest
        Map<String, Object> requestBody = Map.of(
            "contents",new Object[]{
                Map.of("parts",new Object[]{
                    Map.of("text",prompt)
                })
            }
        );

        //Do request and get response
        

        //Return the response
    }

    private String buildPrompt(EmailRequest emailRequest){
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a professional email response to the following email. Please dont generate a subject line.\n");
        if (emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()){
            prompt.append("Use a ").append(emailRequest.getTone()).append(" tone.");
        }
        prompt.append("\n Original email: ").append(emailRequest.getEmailContent());
        return prompt.toString();
    }
}
