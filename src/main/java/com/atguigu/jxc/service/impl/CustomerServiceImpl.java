package com.atguigu.jxc.service.impl;

import com.atguigu.jxc.dao.CustomerDao;
import com.atguigu.jxc.entity.Customer;
import com.atguigu.jxc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerMapper;
    @Override
    public Map<String,Object> listCustomer(Integer page, Integer rows, String customerName) {
        List<Customer> customers = customerMapper.listCustomer(page, rows, customerName);
        Integer customerCount = customerMapper.getCustomerCount(customerName);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("rows",customers);
        hashMap.put("total",customerCount);
        System.out.println(hashMap.toString());
        return hashMap;
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerMapper.addCustomer(customer);
    }

    @Override
    public void deleteByIds(String[] strings) {
        customerMapper.deleteByIds(strings);
    }

    @Override
    public void deleteById(String ids) {
        customerMapper.deleteById(ids);
    }
}
