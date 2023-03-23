package com.example.reactexercisesserverdummy.service;

import com.example.reactexercisesserverdummy.model.TextModel;
import com.example.reactexercisesserverdummy.dao.TextModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextServiceImpl implements TextService {

    private final TextModelRepository textModelRepository;

    public TextServiceImpl(TextModelRepository textModelRepository) {
        this.textModelRepository = textModelRepository;
    }

    @Override
    public void saveText(TextModel textModel) {
        textModelRepository.save(textModel);
    }

    @Override
    public List<TextModel> getAllText() {
        return textModelRepository.findAll();
    }

    @Override
    public void deleteText(Long id) {
        textModelRepository.deleteById(id);
    }
}
