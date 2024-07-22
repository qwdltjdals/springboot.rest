package com.study.rest.dto;

import lombok.Data;
import lombok.ToString;

@Data
public class ReqStudentDto { // 요청 정보
    private String SchoolName;
    private String department;
    private int grade;
    private String Name;
}
