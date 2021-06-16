package com.atguigu.jxc.dao;

import com.atguigu.jxc.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CustomerDao {
    public List<Customer> listCustomer(@Param("page") Integer page, @Param("rows") Integer rows, @Param("customerName") String customerName);
    public Integer getCustomerCount(@Param("customerName") String customerName);

    void updateCustomer(Customer customer);

    void addCustomer(Customer customer);

    void deleteByIds(@Param("strings") String[] strings);

    void deleteById(String ids);
}
