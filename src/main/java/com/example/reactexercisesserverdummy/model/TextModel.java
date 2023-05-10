package com.example.reactexercisesserverdummy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "text_model")
public class TextModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "text_seq")
    @SequenceGenerator(name = "text_seq", allocationSize = 1)
    private Long id;
    @Column
    private String text;
    @Column(unique = true)
    private TextType textType;
}
