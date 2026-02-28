package com.example.resume_analyzer.prompt;

import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ResumePromptBuilder {

    public Prompt buildPrompt(String resume, String jobDescription) {

        String systemMessage = """
                You are a strict HR evaluator.
                Always respond ONLY in valid JSON.
                Follow this schema:
                {
                  "candidateName": "",
                  "overallScore": "",
                  "skills": [
                    {
                      "skill": "",
                      "rating": "",
                      "suggestion": ""
                    }
                  ],
                  "improvementSummary": ""
                }
                """;

        PromptTemplate template = new PromptTemplate("""
                Job Description:
                {jobDescription}

                Candidate Resume:
                {resume}

                Evaluate candidate.
                """);

        Map<String, Object> params = Map.of(
                "resume", resume,
                "jobDescription", jobDescription
        );

        return new Prompt(
                List.of(
                        new SystemMessage(systemMessage),
                        template.createMessage(params)
                )
        );
    }
}