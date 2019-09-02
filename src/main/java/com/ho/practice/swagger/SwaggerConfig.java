package com.ho.practice.swagger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	/**
	 * @return
	 */
	@Bean
    public Docket api() {
		List<ResponseMessage> responseMessageStatus =  Arrays.asList(
				new ResponseMessageBuilder()   
		        .code(200)
		        .message("OK")
		        .build(),
		        new ResponseMessageBuilder()   
		        .code(400)
		        .message("Bad Request")
		        .build(),
		        new ResponseMessageBuilder()   
		        .code(401)
		        .message("Unauthorized")
		        .build(),
		        new ResponseMessageBuilder() 
                .code(404)
                .message("Not Found")
                .build(),
		        new ResponseMessageBuilder()   
		        .code(500)
		        .message("Internal Server Error")
//		        .responseModel(new ModelRef("Error"))
		        .build()
			  );
		
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(apiInfo())
        		.select()                                  
//          .apis(RequestHandlerSelectors.any())
          .apis(RequestHandlerSelectors.basePackage("com.ho.practice.swagger.controller.open"))
//          .paths(PathSelectors.any())
          .paths(PathSelectors.ant("/open/member/**"))
          .build()
          .useDefaultResponseMessages(false)                                   
          .globalResponseMessage(RequestMethod.GET, responseMessageStatus)
        	.globalResponseMessage(RequestMethod.POST, responseMessageStatus)
	        .globalResponseMessage(RequestMethod.PUT, responseMessageStatus)
	        .globalResponseMessage(RequestMethod.DELETE, responseMessageStatus);
    }
	
	private ApiInfo apiInfo() {
		/*
		 * return new ApiInfoBuilder() .title("Test Swagger2")
		 * .description("Swagger2 사용해 봅니다.") .version("0.1") // 화면 타이틀 우측에 표시됨 .build();
		 */
		return new ApiInfo(
			      "Test Swagger2", 
			      "Swagger2 사용해 봅니다.", 
			      "0.1", 
			      "Terms of service", 
			      new Contact("hhsung", "www.example.com", "hhsung@micube.co.kr"), 
			      "License of API", "API license URL", Collections.emptyList());
 
    }
	
}
