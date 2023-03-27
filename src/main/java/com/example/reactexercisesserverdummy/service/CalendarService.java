package com.example.reactexercisesserverdummy.service;

import com.example.reactexercisesserverdummy.model.CalendarModel;

import java.util.Date;

public interface CalendarService {
    void saveCalendarText(CalendarModel calendarModel);

    CalendarModel findByDate(String date);
}
