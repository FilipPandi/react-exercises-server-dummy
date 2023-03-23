package com.example.reactexercisesserverdummy.controller;

import com.example.reactexercisesserverdummy.model.TextModel;
import com.example.reactexercisesserverdummy.service.TextService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/text")
public class TextController {
    private final TextService textService;

    public TextController(TextService textService) {
        this.textService = textService;
    }

    @PostMapping("/save")
    public void saveText(@RequestBody TextModel textModel) {
        textService.saveText(textModel);
    }

    @GetMapping("/getAllText")
    public List<TextModel> getAllText() {
        return textService.getAllText();
    }

    @DeleteMapping("/delete")
    public void delete(Long id) {
        textService.deleteText(id);
    }
}
