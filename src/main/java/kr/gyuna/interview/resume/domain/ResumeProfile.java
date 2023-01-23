package kr.gyuna.interview.resume.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class ResumeProfile {

    private String resumeProfileImgUrl;
    private String resumeProfileImgOriginalName;
}
