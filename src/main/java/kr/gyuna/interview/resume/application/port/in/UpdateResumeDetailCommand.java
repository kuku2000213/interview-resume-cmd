package kr.gyuna.interview.resume.application.port.in;


import kr.gyuna.interview.resume.domain.ResumeDetail;
import kr.gyuna.interview.resume.domain.ResumeId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateResumeDetailCommand {

    private ResumeId resumeId;
    private String resumeTitle;
    private String resumeContent;

    public ResumeId getResumeId(){
        return this.resumeId;
    }

    public ResumeDetail toResumeDetail(){

        return ResumeDetail.builder()
                .resumeTitle(this.resumeTitle)
                .resumeContent(this.resumeContent)
                .build();
    }
}
