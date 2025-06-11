package com.cgr.service.impl;

import com.cgr.entity.Vehicle;
import com.cgr.mapper.VehicleMapper;
import com.cgr.service.VehicleService;
import jakarta.annotation.Resource;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Resource
    private VehicleMapper vehicleMapper;

    /**
     * 新增
     */
    public void add(Vehicle vehicle) {
        vehicleMapper.insert(vehicle);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        vehicleMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            vehicleMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Vehicle vehicle) {
        vehicleMapper.updateById(vehicle);
    }

    /**
     * 根据ID查询
     */
    public Vehicle selectById(Integer id) {
        return vehicleMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Vehicle> selectAll(Vehicle vehicle) {
        return vehicleMapper.selectAll(vehicle);
    }

    /**
     * 分页查询
     */
    public PageInfo<Vehicle> selectPage(Vehicle vehicle, Integer pageNum, Integer pageSize) {
        //TODO
        /*Account currentUser = TokenUtils.getCurrentUser();
        if (RoleEnum.USER.name().equals(currentUser.getRole())) {
            vehicle.setUserId(currentUser.getId());
        }*/
        PageHelper.startPage(pageNum, pageSize);
        List<Vehicle> list = this.selectAll(vehicle);
        return PageInfo.of(list);
    }
}
