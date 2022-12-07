package com.csoep.backend.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * 关于Swagger的配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket docket(Environment environment) {
		//指定在dev/test环境下使用swagger
		Profiles profiles = Profiles.of("dev", "test");
		System.out.println(profiles);
		boolean flag = environment.acceptsProfiles(profiles);
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.enable(flag)//关闭swagger,默认是true
				.select()
				//RequestHandlerSelectors：配置要扫描的方式，有basePackage("路径")、any():扫描全部，none():全部不扫描
				//RequestHandlerSelectors.withMethodAnnotation():扫描方法上的注解
				//.withClassAnnotation()：扫描类上的注解
				.apis(RequestHandlerSelectors.basePackage("com.csoep.backend.controller"))//指定扫描的包
				.paths(PathSelectors.ant("/hello/**"))//设置请求路径，这里是带有hello的请求路径
				.build();
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("WA_automat", "https://github.com/WA-automat", "csoep_scnu@163.com");
		return new ApiInfo(
				"WA_automat的Api",
				"Api Documentation",
				"v1.0",
				"https://github.com/WA-automat",
				contact,
				"Apache 2.0",
				"http://www.apache.org/licenses/LICENSE-2.0",
				new ArrayList<>()
		);
	}
}
