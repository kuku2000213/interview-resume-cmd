package kr.gyuna.interview.resume.application.port.in;

import kr.gyuna.interview.resume.domain.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateResumeCommand {

    private UserId userId;
    private String resumeTitle;
    private String resumeContent;

    public Resume toEntity(){

        ResumeDetail resumeDetail = ResumeDetail.builder()
                .resumeContent(this.resumeContent)
                .resumeTitle(this.resumeTitle)
                .build();

        Date today = new Date();

        ResumeDate resumeDate = ResumeDate.builder()
                .resumeRecordedDate(today)
                .resumeModifiedDate(today)
                .build();

        return Resume.builder()
                .resumeId(ResumeId.uuid())
                .userId(this.userId)
                .resumeDetail(resumeDetail)
                .resumeDate(resumeDate)
                .resumeState(ResumeState.NORMAL)
                .build();
    }

    public UserId getUserId(){
        return this.userId;
    }
}
