package com.hpe.msbireport.viewResolver;

import com.hpe.msbireport.view.ExcelView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * Project:
 * Author: HONGMIN GAO
 * Date: 27/12/17
 * Description: ...
 */
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
