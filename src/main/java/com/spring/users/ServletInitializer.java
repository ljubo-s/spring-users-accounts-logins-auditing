package com.spring.users;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringUsersAccountsLoginsAuditingApplication.class);
	}

    @Configuration
    public class WebConfig implements WebMvcConfigurer {      
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //registry.addResourceHandler("/**").addResourceLocations("classpath:/static/","classpath:/webjars/")
            //registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/")
            registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/").resourceChain(false);
          //  registry.setOrder(1)
          //  .setCacheControl(CacheControl.maxAge(1, TimeUnit.DAYS));
        }
    }
}
