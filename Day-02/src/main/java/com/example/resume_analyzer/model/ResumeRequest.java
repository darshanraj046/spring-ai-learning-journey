package com.example.resume_analyzer.model;

public record ResumeRequest(
        String resume,
        String jobDescription
) {}
