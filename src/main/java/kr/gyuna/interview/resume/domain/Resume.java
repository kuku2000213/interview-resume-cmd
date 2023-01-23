package kr.gyuna.interview.resume.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Resume {

    @EmbeddedId
    private ResumeId resumeId;

    @Embedded
    private UserId userId;

    @Embedded
    private ResumeDate resumeDate;

    @Embedded
    private ResumeDetail resumeDetail;

//    @Embedded
//    private ResumeProfile resumeProfile;
    @Enumerated(value = EnumType.STRING)
    private ResumeState resumeState;

    public void toMainResume(){
        this.resumeState = ResumeState.MAIN;
    }

    public void toNormalResume(){
        this.resumeState = ResumeState.NORMAL;
    }

    public void modifyResume(ResumeDetail resumeDetail){
        this.resumeDate.modifyResume();
        this.resumeDetail = resumeDetail;
    }

}
