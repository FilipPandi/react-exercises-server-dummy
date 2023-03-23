package com.example.reactexercisesserverdummy.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name= "text_model")
public class TextModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "text_seq")
    @SequenceGenerator(name = "text_seq", allocationSize = 10)
    private Long id;
    private String text;
}
