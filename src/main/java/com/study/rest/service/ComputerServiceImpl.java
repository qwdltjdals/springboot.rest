package com.study.rest.service;

import com.study.rest.dto.*;
import com.study.rest.entity.Computer;
import com.study.rest.repository.ComputerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComputerServiceImpl {

    @Autowired
    private ComputerMapper computerMapper;

    public int registerComputer(ReqRegisterComputerDto reqDto) {
        Computer computer = Computer.builder()
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .ram(reqDto.getRam())
                .ssd(reqDto.getSsd())
                .build();

        return computerMapper.save(computer); // save는 DTO를 받는게 아니라 entity를 받음
    }
    
    public List<RespGetListDto> getComputerList(ReqGetListDto reqdto) {
        List<RespGetListDto> respDtos = new ArrayList<>(); //비어있는 리스트 만듦
        
        Computer computer = Computer.builder()
                .company(reqdto.getCompany())
                .cpu(reqdto.getCpu())
                .build();
        
        List<Computer> computers = computerMapper.findComputerByCompanyAndCpu(computer); // 데이터베이스에서 리스트 가져와서 넣어줘야함
        
        for(Computer com : computers) { // 포이치 반복
            RespGetListDto dto = RespGetListDto.builder()
                    .computerId(com.getComputerId())
                    .company(com.getCompany())
                    .build();

            respDtos.add(dto); // 만들고 나서 respDtos 에 다 넣어줌
        }
        
        return respDtos;
    }

                        // 위에꺼랑 같은 것
    public List<RespGetListDto> getComputerList2(ReqGetListDto reqdto) {

        Computer computer = Computer.builder()
                .company(reqdto.getCompany())
                .cpu(reqdto.getCpu())
                .build();

        List<Computer> computers = computerMapper.findComputerByCompanyAndCpu(computer); // 데이터베이스에서 리스트 가져와서 넣어줘야함


        return computers.stream().map(com -> RespGetListDto.builder() 
                .computerId(com.getComputerId())
                .company(com.getCompany())
                .build()
        ).collect(Collectors.toList());
    }

    public RespGetComputerDto getComputer(int computerId) {
        Computer computer = computerMapper.findComputerById(computerId);
        return RespGetComputerDto.builder()
                .computerId(computer.getComputerId())
                .company(computer.getCompany())
                .cpu(computer.getCpu())
                .ram(computer.getRam())
                .ssd(computer.getSsd())
                .build();
    }

    public int deleteComputer(int computerId) {
        return computerMapper.delete(computerId);
    }

    public int updateComputer(ReqUpdateComputerDto reqDto) {
        Computer computer = Computer.builder() // dto를 entity로 변환
                .computerId(reqDto.getComputerId())
                .company(reqDto.getCompany())
                .cpu(reqDto.getCpu())
                .ram(reqDto.getRam())
                .ssd(reqDto.getSsd())
                .build();

        return computerMapper.update(computer);
    }
}
