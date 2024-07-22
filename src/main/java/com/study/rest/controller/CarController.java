package com.study.rest.controller;

import com.study.rest.entity.Car;
import com.study.rest.repository.CarRepository;
import com.study.rest.service.CarService;
import com.study.rest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @ResponseBody
    @GetMapping("/car")
    public Car getCar(@RequestParam String model) {
        return carService.getCar(model);
    }
}






/**
 * 요청 GET - /car
 * CarEntity            -> model, color
 * CarRepository        -> Car findCarByModel(String model)
 * -> List<Car>         -> index0: Car(modell: "쏘나타", color : "화이트")
 * -> List<Car>         -> index1: Car(modell: "K5", color : "블랙")
 * CarService           -> Car getCar(String model)
 * CarController        -> Car getCar(@RequestParam String model)
 * CarController -> CarService -> CarRepository
 */