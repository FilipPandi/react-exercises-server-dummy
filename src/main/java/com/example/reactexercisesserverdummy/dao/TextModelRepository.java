package com.example.reactexercisesserverdummy.dao;

import com.example.reactexercisesserverdummy.model.TextModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextModelRepository extends JpaRepository<TextModel, Long> {
}
