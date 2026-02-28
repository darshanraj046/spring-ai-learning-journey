package com.example.resume_analyzer.model;

import java.util.List;

public record ResumeFeedback(
        String candidateName,
        String overallScore,
        List<SkillFeedback> skills,
        String improvementSummary
) {}