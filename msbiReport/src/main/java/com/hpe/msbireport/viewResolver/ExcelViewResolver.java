package com.hpe.msbireport.viewResolver;

import java.util.Locale;

import org.junit.Ignore;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import com.hpe.msbireport.view.ExcelView;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 27/12/17
 * Description: ...
 */
@Deprecated
@Ignore
public class ExcelViewResolver implements ViewResolver {

    /*
     * Extend view resolver, call ExcelView to generate .xlsx report file.
     */
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        ExcelView view = new ExcelView();
        return view;
    }
}
