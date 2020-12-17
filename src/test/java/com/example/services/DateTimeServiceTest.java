package com.example.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DateTimeServiceTest {

    private DateTimeService dateTimeService = new DateTimeServiceImpl();

    @Test
    public void get_date_and_time_returns_current_date_and_time() {
        Date currentDateTime = new Date();
        assertThat(
                TimeUnit.SECONDS.convert(dateTimeService.getCurrentDateAndTime().getTime() - currentDateTime.getTime(),
                        TimeUnit.MILLISECONDS),
                lessThan(5L));
    }

}
