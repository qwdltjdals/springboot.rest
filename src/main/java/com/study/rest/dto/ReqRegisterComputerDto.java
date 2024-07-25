package com.study.rest.dto;

import lombok.Data;

@Data
public class ReqRegisterComputerDto {
    private String company;
    private String cpu;
    private int ram;
    private int ssd;
}
