package com.prowings.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@PropertySource("classpath:app.properties")
@EnableWebMvc
@ComponentScan(basePackages="com.prowings")
public class WebAppConfig implements WebMvcConfigurer{
@Autowired
Environment environment;
@Bean
public CloseableHttpClient httpClient() {
	return HttpClients.createDefault();
}
@Bean
public RestTemplate restTemplate() {
	RestTemplate restTemplate=new RestTemplate(clientHttpRequestFactory());
	return restTemplate;
}
@Bean
public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
	HttpComponentsClientHttpRequestFactory clientHttpRequestFactory=new HttpComponentsClientHttpRequestFactory();
	return clientHttpRequestFactory;
}
}
