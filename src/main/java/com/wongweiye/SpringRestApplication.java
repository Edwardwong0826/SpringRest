package com.wongweiye;

import com.wongweiye.security.RSAKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@EnableConfigurationProperties(RSAKeyProperties.class)
@SpringBootApplication
public class SpringRestApplication {


	public static void main(String[] args) {

		SpringApplication.run(SpringRestApplication.class, args);



	}

}
