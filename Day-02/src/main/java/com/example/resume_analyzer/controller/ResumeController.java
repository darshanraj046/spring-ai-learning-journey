package com.example.resume_analyzer.controller;

import com.example.resume_analyzer.model.ResumeFeedback;
import com.example.resume_analyzer.model.ResumeRequest;
import com.example.resume_analyzer.service.ResumeAnalysisService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private final ResumeAnalysisService service;

    public ResumeController(ResumeAnalysisService service) {
        this.service = service;
    }

    @PostMapping("/analyze")
    public ResumeFeedback analyze(@RequestBody ResumeRequest request) {
        return service.analyze(request.resume(), request.jobDescription());
    }
}