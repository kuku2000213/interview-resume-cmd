package kr.gyuna.interview.resume.application.port.in;

import kr.gyuna.interview.common.response.DefaultResponse;

public interface SetMainResumeUseCase {
    DefaultResponse setMainResume(SetMainResumeCommand command);
}
