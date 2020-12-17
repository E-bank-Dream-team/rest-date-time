package com.example.services;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateTimeServiceImpl implements DateTimeService {

	@Override
	public Date getCurrentDateAndTime() {
		return new Date();
	}
}
