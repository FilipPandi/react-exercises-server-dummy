package com.example.reactexercisesserverdummy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "calendar_model")
public class CalendarModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendar_seq")
    @SequenceGenerator(name = "calendar_seq", allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private Date date;

    private String text;
}
