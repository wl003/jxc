package com.atguigu.jxc.service;

import com.atguigu.jxc.entity.Customer;

import java.util.Map;

public interface CustomerService {

    Map<String,Object> listCustomer(Integer page, Integer rows, String customerName);

    void updateCustomer(Customer customer);

    void addCustomer(Customer customer);

    void deleteByIds(String[] strings);

    void deleteById(String ids);
}
