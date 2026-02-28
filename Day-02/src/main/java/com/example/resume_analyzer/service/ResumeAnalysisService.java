package com.example.resume_analyzer.service;

import com.example.resume_analyzer.model.ResumeFeedback;
import com.example.resume_analyzer.model.SkillFeedback;
import com.example.resume_analyzer.prompt.ResumePromptBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeAnalysisService {

    private final ChatClient chatClient;
    private final ResumePromptBuilder promptBuilder;

    public ResumeFeedback analyze(String resume, String jd) {

        Prompt prompt = promptBuilder.buildPrompt(resume, jd);

        ChatOptions options = ChatOptions.builder()
                .temperature(0.1)
                .maxTokens(1000)
                .build();

        return chatClient.prompt(prompt)
                .options(options)
                .call()
                .entity(ResumeFeedback.class);
    }

    public List<SkillFeedback> extractSkills(String resume) {

        Prompt prompt = new Prompt("""
                Extract skills from the resume.
                Respond in JSON array format.
                """ + resume);

        return chatClient.prompt(prompt)
                .call()
                .entity(new ParameterizedTypeReference<List<SkillFeedback>>() {});
    }
}
