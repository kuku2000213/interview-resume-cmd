package kr.gyuna.interview.resume.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class ResumeDate {

    private Date resumeRecordedDate;
    private Date resumeModifiedDate;

    protected void modifyResume(){
        this.resumeModifiedDate = new Date();
    }
}
