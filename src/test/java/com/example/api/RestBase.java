package com.example.api;

import static org.mockito.BDDMockito.given;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.example.controllers.DateTimeController;
import com.example.services.DateTimeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(MockitoJUnitRunner.class)
public abstract class RestBase {

	@Mock
	DateTimeService dateTimeService;

	@InjectMocks
	DateTimeController dateTimeController;

	@Before
	public void setup() {
		given(dateTimeService.getCurrentDateAndTime()).willReturn(new Date());

		// For date formatting
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		messageConverter.setObjectMapper(new ObjectMapper().disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
				.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX")));
		RestAssuredMockMvc.standaloneSetup(
				MockMvcBuilders.standaloneSetup(dateTimeController).setMessageConverters(messageConverter));
	}
}
