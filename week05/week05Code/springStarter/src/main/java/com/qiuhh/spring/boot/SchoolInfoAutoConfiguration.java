

package com.qiuhh.spring.boot;


import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.qiuhh.spring.boot.prop.SpringBootPropertiesConfiguration;

import lombok.RequiredArgsConstructor;

/**
 * Spring boot starter configuration.
 */
@Configuration
@EnableConfigurationProperties(SpringBootPropertiesConfiguration.class)
@ConditionalOnProperty(prefix = "spring.week05", name = "enabled", havingValue = "true", matchIfMissing = true)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@RequiredArgsConstructor
public class SchoolInfoAutoConfiguration implements EnvironmentAware {
    
    private String schemaName;
    
    private final SpringBootPropertiesConfiguration props;

	public void setEnvironment(Environment environment) {
		System.out.println("初始化加载===================com.qiuhh.spring.boot.SchoolInfoAutoConfiguration");
		// TODO Auto-generated method stub
		
	}
    
    
 
    
   
}
