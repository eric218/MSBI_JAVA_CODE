package com.hpe.msbireport.service.impl;

import com.hpe.msbireport.domain.TotalTitle;
import com.hpe.msbireport.mapper.TotalTitleMapper;
import com.hpe.msbireport.service.TotalTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 2/1/18
 * Description: ...
 */
@Service
public class TotalTitleServiceImpl implements TotalTitleService {

    @Autowired
    TotalTitleMapper totalTitleMapper;

    @Override
    public List<TotalTitle> selectAllTotalTitle() {
        return this.totalTitleMapper.selectAllTotalTitle();
    }
}
