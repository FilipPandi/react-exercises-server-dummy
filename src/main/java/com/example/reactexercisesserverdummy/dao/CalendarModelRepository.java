package com.example.reactexercisesserverdummy.dao;

import com.example.reactexercisesserverdummy.model.CalendarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface CalendarModelRepository extends JpaRepository<CalendarModel, Long> {
    Optional<CalendarModel> findCalendarModelByDate(Date date);
}
