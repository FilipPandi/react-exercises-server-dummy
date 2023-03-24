package com.example.reactexercisesserverdummy.service;

import com.example.reactexercisesserverdummy.model.TextModel;
import com.example.reactexercisesserverdummy.model.TextType;

import java.util.List;

public interface TextService {
   void saveText(TextModel textModel);

    List<TextModel> getAllText();

    void deleteText(Long id);

    TextModel findTextByTextType(String textType);
}
