package com.sample.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sample.dto.ZipCodeDto;

@Service
public class ZipCodeService {

	@Autowired()
	@Qualifier("zipCodeSearchRestTemplate")
	RestTemplate restTemplate;
	
	/** 郵便番号検索API リクエストURL */
	private static final String URL = "http://zipcloud.ibsnet.co.jp/api/search?zipcode={zipcode}";

    /**
     * 
     * @param zipcode
     * @return zipCodeDto
     */
    public ZipCodeDto zipcodeConfirm(String zipcode){
        ZipCodeDto zipCodeDto = restTemplate.getForObject(URL, ZipCodeDto.class, zipcode);
        return zipCodeDto;   
    }
    
    @Bean
    public RestTemplate zipCodeSearchRestTemplate() {
      MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
      List<MediaType> supportedMediaTypes = new ArrayList<MediaType>(messageConverter.getSupportedMediaTypes());
      
      supportedMediaTypes.add(MediaType.TEXT_PLAIN);
      messageConverter.setSupportedMediaTypes(supportedMediaTypes);

      RestTemplate restTemplate = new RestTemplate();
      restTemplate.setMessageConverters(Collections.singletonList(messageConverter));
      return restTemplate;
    }

}
