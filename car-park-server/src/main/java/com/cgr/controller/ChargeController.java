package com.cgr.controller;

import com.cgr.ResponseModel;
import com.cgr.aop.annotation.HasRole;
import com.cgr.entity.Charge;
import com.cgr.mapper.ChargeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/charge")
public class ChargeController {

    @Autowired
    private ChargeMapper chargeMapper;

    @PostMapping("/update")
    @HasRole("ADMIN")
    public ResponseModel update(@RequestBody Charge charge){
        chargeMapper.updateCharge(charge);
        return ResponseModel.success();
    }

    @GetMapping("/getInfo")
    public ResponseModel getInfo(){
        return ResponseModel.success(chargeMapper.getInfo());
    }
}
