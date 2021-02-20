package com.chaochaogu.service.impl;

import com.chaochaogu.dao.db2.AddressMapper;
import com.chaochaogu.model.Address;
import com.chaochaogu.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chaochao Gu
 * @date 2021/2/20
 */
@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Address queryById(Long id) {
        return addressMapper.selectByPrimaryKey(id);
    }
}
