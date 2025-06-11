package com.cgr.service.impl;

import com.cgr.entity.Pay;
import com.cgr.mapper.PayMapper;
import com.cgr.service.PayService;
import com.cgr.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {
    @Resource
    private PayMapper payMapper;
    @Resource
    private UserService userService;

    /**
     * 新增
     */
    public void add(Pay pay) {
        payMapper.insert(pay);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        payMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            payMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(Pay pay) {
        //TODO
        /*// 查询余额够不够
        User user = userService.selectById(pay.getUserId());
        if (user.getAccount() < pay.getPrice()) {
            throw new CustomException("500", "您的余额不足，请到个人中心充值");
        }
        user.setAccount(user.getAccount() - pay.getPrice());
        userService.updateById(user);*/

        pay.setStatus("已缴费");
        payMapper.updateById(pay);
    }

    /**
     * 根据ID查询
     */
    public Pay selectById(Integer id) {
        return payMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<Pay> selectAll(Pay pay) {
        return payMapper.selectAll(pay);
    }

    /**
     * 分页查询
     */
    public PageInfo<Pay> selectPage(Pay pay, Integer pageNum, Integer pageSize) {
        //TODO
        /*Account currentUser = TokenUtils.getCurrentUser();
        if (RoleEnum.USER.name().equals(currentUser.getRole())) {
            pay.setUserId(currentUser.getId());
        }*/
        PageHelper.startPage(pageNum, pageSize);
        List<Pay> list = this.selectAll(pay);
        return PageInfo.of(list);
    }
}
