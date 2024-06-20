package com.project.optimization;

import com.project.optimization.dto.OptimizationContactInfoDto;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(value = {OptimizationContactInfoDto.class})
@EnableFeignClients
public class OptimizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptimizationApplication.class, args);
	}

}
