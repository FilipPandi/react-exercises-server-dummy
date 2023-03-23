package com.example.reactexercisesserverdummy.service;

import com.example.reactexercisesserverdummy.model.TextModel;

import java.util.List;

public interface TextService {
   void saveText(TextModel textModel);

    List<TextModel> getAllText();

    void deleteText(Long id);
}
