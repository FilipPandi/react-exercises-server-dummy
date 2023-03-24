package com.example.reactexercisesserverdummy.service;

import com.example.reactexercisesserverdummy.model.TextModel;
import com.example.reactexercisesserverdummy.dao.TextModelRepository;
import com.example.reactexercisesserverdummy.model.TextType;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TextServiceImpl implements TextService {

    private final TextModelRepository textModelRepository;

    public TextServiceImpl(TextModelRepository textModelRepository) {
        this.textModelRepository = textModelRepository;
    }

    @Override
    public void saveText(TextModel textModel) {
        Optional<TextModel> existingTextModels =
                textModelRepository.findTextModelByTextType(textModel.getTextType());

        if (existingTextModels.isPresent()) {
            textModelRepository.save(
                    new TextModel(existingTextModels.get().getId(),
                    textModel.getText(),
                    existingTextModels.get().getTextType())
            );
        } else {
            textModelRepository.save(textModel);
        }
    }

    @Override
    public List<TextModel> getAllText() {
        return textModelRepository.findAll();
    }

    @Override
    public void deleteText(Long id) {
        textModelRepository.deleteById(id);
    }

    @Override
    public TextModel findTextByTextType(String textType) {
        TextType textTypeResult = TextType.getByCode(Integer.parseInt(textType));
        Optional<TextModel> existingTextModels =
                textModelRepository.findTextModelByTextType(textTypeResult);

        return existingTextModels.orElseGet(() -> (TextModel) Optional.empty().get());
    }
}
