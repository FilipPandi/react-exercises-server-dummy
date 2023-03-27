package com.example.reactexercisesserverdummy.controller;

import com.example.reactexercisesserverdummy.model.CalendarModel;
import com.example.reactexercisesserverdummy.service.CalendarService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/calendar")
@CrossOrigin(origins = {"http://localhost:3000"})
public class CalendarController {

    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @PostMapping("/save")
    public void saveCalendarModel(@RequestBody CalendarModel calendarModel) {
        calendarService.saveCalendarText(calendarModel);
    }

    @GetMapping("/findByDate")
    public CalendarModel getCalendarModelByDate(@RequestParam String date) {
        return calendarService.findByDate(date);
    }
}
