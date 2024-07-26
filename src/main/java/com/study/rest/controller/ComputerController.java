package com.study.rest.controller;

import com.study.rest.dto.ReqGetListDto;
import com.study.rest.dto.ReqRegisterComputerDto;
import com.study.rest.dto.ReqUpdateComputerDto;
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
    @PutMapping("/computer/{computerId}")
    public ResponseEntity<?> modifyApi(@PathVariable int computerId, @RequestBody ReqUpdateComputerDto reqDto) {
        return ResponseEntity.ok().body(computerService.updateComputer(reqDto));
    }
    @GetMapping("/computers")
    public ResponseEntity<?> getListApi(ReqGetListDto reqDto) { // 요청 데이터가 JSON일때만 requsetbody / get요청은 params임!!!
        log.info("{}", reqDto);
        return ResponseEntity.ok().body(computerService.getComputerList(reqDto));
    }
    //http://localhost:8080/api/v1/computer/3 ... ?형식이 아니라 경로 자체에 변수를 씀
    @GetMapping("/computer/{computerId}") // /뒤에 번호나 키값
    public ResponseEntity<?> getApi(@PathVariable int computerId) { // 위에꺼랑 같은 변수명
        log.info("{}", computerId);
        return ResponseEntity.ok().body(computerService.getComputer(computerId));
    }
    @DeleteMapping("/computer/{computerId}")
    public ResponseEntity<?> removeApi(@PathVariable int computerId) {
        log.info("{}", computerId);
        return ResponseEntity.ok().body(computerService.deleteComputer(computerId));
    }

}
