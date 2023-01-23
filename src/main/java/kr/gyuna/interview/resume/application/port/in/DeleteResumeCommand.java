package kr.gyuna.interview.resume.application.port.in;

import kr.gyuna.interview.resume.domain.ResumeId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteResumeCommand {

    private ResumeId resumeId;

    public ResumeId toResumeId(){
        return this.resumeId;
    }
}
