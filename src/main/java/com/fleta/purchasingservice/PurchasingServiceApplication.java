package com.fleta.purchasingservice;

import com.fleta.purchasingservice.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackageClasses = PurchasingServiceApplication.class)
@EnableConfigurationProperties({ LiquibaseProperties.class, ApplicationProperties.class })

public class PurchasingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchasingServiceApplication.class, args);
	}

}
