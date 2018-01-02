package com.hpe.msbireport.service;

import com.hpe.msbireport.domain.Lookup;
import com.hpe.msbireport.mapper.LookupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 27/12/17
 * Description: ...
 */

public interface LookupService {

    List<Lookup> selectAllLookup();

}
