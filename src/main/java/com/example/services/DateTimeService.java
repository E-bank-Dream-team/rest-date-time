package com.example.services;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public interface DateTimeService {

    public Date getCurrentDateAndTime();
}
