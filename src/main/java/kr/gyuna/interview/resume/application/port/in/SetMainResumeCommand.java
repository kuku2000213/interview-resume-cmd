package kr.gyuna.interview.resume.application.port.in;

import kr.gyuna.interview.resume.domain.ResumeId;
import kr.gyuna.interview.resume.domain.UserId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SetMainResumeCommand {

    private ResumeId resumeId;

    public ResumeId toValue(){
        return this.resumeId;
    }

}
