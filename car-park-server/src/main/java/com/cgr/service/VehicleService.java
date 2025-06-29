package com.cgr.service;

import com.cgr.entity.Vehicle;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface VehicleService {
    void add(Vehicle vehicle);

    void deleteById(Long id);

    void deleteBatch(List<Long> ids);

    void updateById(Vehicle vehicle);

    Vehicle selectById(Long id);

    List<Vehicle> selectAll(Vehicle vehicle);

    PageInfo<Vehicle> selectPage(Vehicle vehicle, Integer pageNum, Integer pageSize);


    void updateTypeByIds(List<Long> ids,int carType);

    void monthlyCharge(Long vehicleId);
}
