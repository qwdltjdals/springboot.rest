package com.study.rest.service;

import com.study.rest.dto.*;
import com.study.rest.entity.Color;
import com.study.rest.entity.Product;
import com.study.rest.entity.Size;
import com.study.rest.repository.ColorMapper;
import com.study.rest.repository.ProductMapper;
import com.study.rest.repository.SizeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // IOC에 등록
public class ProductServiceImpl implements ProductService{ // 컨트롤러(요청 들어옴) - 의존, 호출 > 서비스 - 의존 > 레파짓토리
    // mybatis가 xml을 IOC에 등록해줌 - 서비스에서 가져와서 씀(autowirad 해줘야함)
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private SizeMapper sizeMapper;
    @Autowired
    private ColorMapper colorMapper;

    @Override
    public List<SizeDto.Info> getSizeListAll() {
        return SizeDto.toList(sizeMapper.findAll());
    }

    @Override
    public List<Color> getColorListAll() {
        return colorMapper.findAll();
    }

    @Override
    public CommonResponseDto registerProduct(ProductDto.Register register) {
        return CommonResponseDto.ofdefault(productMapper.save(register.toEntity()));
    }
    @Override
    public CommonResponseDto registerSize(ReqRegisterSizeDto reqRegisterSizeDto) {
//        Size size = Size.builder()
//                .sizeName(reqRegisterSizeDto.getSizeName())
//                .build();
//        int susscessCount = sizeMapper.save(size);
//        return CommonResponseDto.ofdefault(susscessCount); 아래꺼랑 같은 코드임;
        return CommonResponseDto.ofdefault(sizeMapper.save(reqRegisterSizeDto.toEntity()));
    }
    @Override
    public CommonResponseDto registerColor(ReqRegisterColorDto reqRegisterColorDto) {
        return CommonResponseDto.ofdefault(colorMapper.save(reqRegisterColorDto.toEntity()));
    }
}
