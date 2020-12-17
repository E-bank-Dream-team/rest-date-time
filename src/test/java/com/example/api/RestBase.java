package com.example.api;

import static org.mockito.BDDMockito.given;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.example.controllers.DateTimeController;
import com.example.services.DateTimeService;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
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
		Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		calendar.set(2020, 12, 17, 10, 0, 0);
		Date date = calendar.getTime();
		given(dateTimeService.getCurrentDateAndTime()).willReturn(date);

		RestAssuredMockMvc.standaloneSetup(
				MockMvcBuilders.standaloneSetup(dateTimeController));
	}
}
