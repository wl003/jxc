package com.atguigu.jxc.controller;

import com.atguigu.jxc.domain.ServiceVO;
import com.atguigu.jxc.entity.Customer;
import com.atguigu.jxc.service.CustomerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("customer")
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/list")
    @RequiresPermissions(value = "客户管理")
    public Map<String , Object> listCustomer(Integer page, Integer rows, @RequestParam(required = false) String customerName) {
                page=(page-1)*rows;
        return  customerService.listCustomer(page, rows, customerName);
    }
    @PostMapping("/save")
    @RequiresPermissions(value = "客户管理")
    public ServiceVO addOrUpdateCustomer(Customer customer, @RequestParam(required = false) Integer customerId) {
            if(customerId!=null){
                customerService.updateCustomer(customer);
            }else {
                customerService.addCustomer(customer);
            }
        return  new ServiceVO(100,"操作成功");
    }
    @PostMapping("/delete")
    @RequiresPermissions(value = "客户管理")
    public ServiceVO deleteCustomer(String ids) {
        String[] strings = StringUtils.split(ids, ",");
        if(strings!=null){customerService.deleteByIds(strings);}
        else {
            customerService.deleteById(ids);
        }

        return  new ServiceVO(100,"操作成功");
    }


}
