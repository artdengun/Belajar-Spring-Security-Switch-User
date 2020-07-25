package com.deni.gunawan.belajar.spring.belajarswitchuser.config;

import com.deni.gunawan.belajar.spring.belajarswitchuser.utility.AuditTrailInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class KonfigurasiInterceptor implements WebMvcConfigurer {

    @Autowired
    private AuditTrailInterceptor auditTrailInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(auditTrailInterceptor);
    }
}
