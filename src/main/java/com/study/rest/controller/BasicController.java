package com.study.rest.controller;

import com.study.rest.dto.*;
import com.study.rest.entity.Product;
import com.study.rest.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Rest API
@Slf4j
@RestController // 데이터만 요청하고 데이터만 받는 것
public class BasicController {

    @Autowired
    private ProductService productService;

    /**
     * REST API
     * 데이터 통신을 위한 HTTP 요청 방식
     * HTTP(프로토콜)를 조금 더 잘 쓰기 위해서 정의된 개념
     * 1. 요청에 대한 동작은 무조건 메소드에 따라 정의하자.
     * - 데이터 추가(등록)는 POST요청으로 하자. 그리고 POST요청은 JSON데이터로 요청하자.
     * - 데이터 조회는 GET요청으로 하자.
     *      그리고 GET요청은 QueryString(params)으로 요청하자.
     *      예) 주소? key1=value1&key2=value2
     * - 데이터 수정은 PUT, PATCH 요청으로 하자. JSON으로 요청하자.
     *      PUT요청과 PATCH 요청의 차이점
     *      PUT 요청 : 공백 또는 null인 데이터드 수정을 함 / 공백이나 null이 넘어오면 기존데이터에 넣도록 코드를 짜라
     *      PATCH 요청 : 공백 또는 null인 데이터는 수정하지 않음 / 공백이나 null이 넘어오면 기존데이터 수정을 안하게 코드를 짜라
     * - 데이터 삭제는 DELETE 요청으로 하자, Params로 요청하자
     *
     * 2. 주소(URL) 요청메시지(Resourse) 자원 작성법
     *  - URL은 가능한 동사를 사용하지 않는다.
     *  계층 구조로 작성한다.
     *      예) /집/주방/가스레인지, /식당/주방/가스레인지
     *  - 요청 메소드 마다 작성하는 방법이 다르다.
     *  - 상품 등록(POST) /product
     *    상품 하나(단건) 조회(GET) /product/1(id, key)
     *    상품 여러개(다건) 조회(GET) /products(전체), /products?page=1&count=30(한페이지에 30개씩 조회)
     *    상품 수정(PUT) /product/1(id, key)
     *    상품 삭제(DELETE) /product/1(id, key)
     *
     * 3. 주소는 가능한 대문자를 사용하지 않는다.
     *  -
     */

    @CrossOrigin // 백엔드의 것을 받을 준비
    @PostMapping("/basic/student") // url은 계층구조로, 동사는 가급적 넣지 않음, POST는 등록을 위한 것
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

    @CrossOrigin
    @PostMapping("/api/v1/product")
    public ResponseEntity<?> registerProduct(@RequestBody ProductDto.Register register) {
        return ResponseEntity.ok().body(
                productService.registerProduct(register));
    }

    @CrossOrigin
    @GetMapping("/api/v1/sizes")
    public ResponseEntity<?> sizeListApi() {
        return ResponseEntity.ok().body(productService.getSizeListAll());
    }
    @CrossOrigin
    @GetMapping("/api/v1/colors")
    public ResponseEntity<?> colorListApi() {
        return ResponseEntity.ok().body(productService.getColorListAll());
    }
    @CrossOrigin
    @PostMapping("/api/v1/size")
    public ResponseEntity<?> registerSizeApi(@RequestBody ReqRegisterSizeDto reqRegisterSizeDto) {
        log.info("{}", reqRegisterSizeDto);
        return ResponseEntity.ok().body(productService.registerSize(reqRegisterSizeDto));
    }
    @CrossOrigin
    @PostMapping("/api/v1/color")
    public ResponseEntity<?> registerColorApi(@RequestBody ReqRegisterColorDto reqRegisterColorDto) {
        log.info("{}", reqRegisterColorDto);
        return ResponseEntity.ok().body(productService.registerColor(reqRegisterColorDto));
    }

}
