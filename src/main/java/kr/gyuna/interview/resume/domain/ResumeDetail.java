package kr.gyuna.interview.resume.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class ResumeDetail {
    private String resumeTitle;
    @Column(columnDefinition = "LONGTEXT")
    private String resumeContent;


}
