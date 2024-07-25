package com.study.rest.controller;

import com.study.rest.dto.ReqGetListDto;
import com.study.rest.dto.ReqRegisterComputerDto;
import com.study.rest.service.ComputerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/v1") // 이게 붙으면 개별로 다 주소 안써줘도 댐
public class ComputerController {

    @Autowired
    private ComputerServiceImpl computerService; // 쓸려고 가져옴

    @PostMapping("/computer")
    public ResponseEntity<?> registerApi(@RequestBody ReqRegisterComputerDto reqDto) {
        log.info("{}", reqDto);
        return ResponseEntity.ok().body(computerService.registerComputer(reqDto));
    }
    public ResponseEntity<?> modifyApi() {
        return ResponseEntity.ok().body(null);
    }
    @GetMapping("/computers")
    public ResponseEntity<?> getListApi(ReqGetListDto reqDto) { // 요청 데이터가 JSON일때만 requsetbody / get요청은 params임!!!
        log.info("{}", reqDto);
        return ResponseEntity.ok().body(computerService.getComputerList(reqDto));
    }
    public ResponseEntity<?> getApi() {
        return ResponseEntity.ok().body(null);
    }
    public ResponseEntity<?> removeApi() {
        return ResponseEntity.ok().body(null);
    }

}
