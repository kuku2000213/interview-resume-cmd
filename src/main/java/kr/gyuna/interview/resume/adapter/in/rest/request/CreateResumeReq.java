package kr.gyuna.interview.resume.adapter.in.rest.request;

import lombok.Getter;

@Getter
public class CreateResumeReq {

    private String userId;
    private String title;
    private String content;

}
