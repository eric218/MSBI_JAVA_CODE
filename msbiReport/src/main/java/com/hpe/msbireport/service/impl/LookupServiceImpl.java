package com.hpe.msbireport.service.impl;

import com.hpe.msbireport.domain.Lookup;
import com.hpe.msbireport.mapper.LookupMapper;
import com.hpe.msbireport.service.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 27/12/17
 * Description: ...
 */
@Service
public class LookupServiceImpl implements LookupService{

    @Autowired
    LookupMapper lookupMapper;

    @Override
    public List<Lookup> selectAllLookup() {
        return this.lookupMapper.selectAllLookup();
    }
}
