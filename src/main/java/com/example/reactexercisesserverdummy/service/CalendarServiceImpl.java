package com.example.reactexercisesserverdummy.service;

import com.example.reactexercisesserverdummy.dao.CalendarModelRepository;
import com.example.reactexercisesserverdummy.model.CalendarModel;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class CalendarServiceImpl implements CalendarService {

    private final CalendarModelRepository calendarModelRepository;

    public CalendarServiceImpl(CalendarModelRepository calendarModelRepository) {
        this.calendarModelRepository = calendarModelRepository;
    }

    @Override
    public void saveCalendarText(CalendarModel calendarModel) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(calendarModel.getDate());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        calendarModel.setDate(cal.getTime());

        Optional<CalendarModel> existingCalendarModel =
                calendarModelRepository.findCalendarModelByDate(calendarModel.getDate());

        if (existingCalendarModel.isPresent()) {
            existingCalendarModel.get().setDate(cal.getTime());

            calendarModelRepository.save(new CalendarModel(
                    existingCalendarModel.get().getId(),
                    existingCalendarModel.get().getDate(),
                    calendarModel.getText()
            ));
        } else {
            cal.setTime(calendarModel.getDate());
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            calendarModel.setDate(cal.getTime());
            calendarModelRepository.save(calendarModel);
        }
    }

    @Override
    public CalendarModel findByDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateResult;

        try {
            dateResult = dateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Optional<CalendarModel> existingCalendarModel =
                calendarModelRepository.findCalendarModelByDate(dateResult);
        return existingCalendarModel.orElseGet(() -> (CalendarModel) Optional.empty().get());
    }
}
