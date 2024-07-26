package com.study.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespGetComputerDto {
    private int computerId;
    private String company;
    private String cpu;
    private int ram;
    private int ssd;
}
