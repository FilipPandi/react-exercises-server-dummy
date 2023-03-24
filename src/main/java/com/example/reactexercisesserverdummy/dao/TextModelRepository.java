package com.example.reactexercisesserverdummy.dao;

import com.example.reactexercisesserverdummy.model.TextModel;
import com.example.reactexercisesserverdummy.model.TextType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TextModelRepository extends JpaRepository<TextModel, Long> {
    Optional<TextModel> findTextModelByTextType(TextType textType);
}
