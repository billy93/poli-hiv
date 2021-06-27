package com.poli.hiv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PoliHIVApplication {
    public static void main(String[] args) {
        SpringApplication.run(PoliHIVApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
//        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
//		restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
//			public boolean hasError(ClientHttpResponse response) throws IOException {
//				HttpStatus statusCode = response.getStatusCode();
//				return statusCode.series() == HttpStatus.Series.SERVER_ERROR;
//			}
//		});
        return restTemplate;
    }
}
