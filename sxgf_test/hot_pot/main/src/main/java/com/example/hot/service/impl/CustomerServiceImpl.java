package com.example.hot.service.impl;

import com.example.hot.entity.Customer;
import com.example.hot.mapper.CustomerMapper;
import com.example.hot.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author administrator
 * @since 2020-04-25
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}
