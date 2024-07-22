package com.study.rest.controller;

import com.study.rest.dto.ReqStudentDto;
import com.study.rest.dto.ReqTeacherDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Rest API
@Slf4j
@RestController // 데이터만 요청하고 데이터만 받는 것
public class BasicController {

    @CrossOrigin
    @PostMapping("/basic/student") // url은 계층구조로, 동사는 가급적 넣지 않음
    public ResponseEntity<?> basicPost(@RequestBody ReqStudentDto reqStudentDto) { // 제이슨으로 요청 들어오면 무조건 RequestBody / params는 아님
        log.info("Student : {}", reqStudentDto); // 콘솔 찍기( 중괄호 안으로 객체가 들어감.sysout = 모든 요청에 대해 콘솔을 출력, 저장이 안됨 log = 저장가능

        return ResponseEntity.ok().body(reqStudentDto); // ok = 상태코드 200
    }

    @CrossOrigin
    @PostMapping("/basic/teacher")
    public ResponseEntity<?> basicPost(@RequestBody ReqTeacherDto reqTeacherDto) {
        log.info("teacher : {}", reqTeacherDto);

        return ResponseEntity.ok().body(reqTeacherDto);
    }
}
