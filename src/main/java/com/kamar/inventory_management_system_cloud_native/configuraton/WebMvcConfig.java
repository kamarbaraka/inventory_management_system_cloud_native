package com.kamar.inventory_management_system_cloud_native.configuraton;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * a configuration class for the dispatcher servlet.
 * @author kamar baraka.*/

public class WebMvcConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {AppContextConfig.class,};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
