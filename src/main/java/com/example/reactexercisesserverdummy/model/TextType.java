package com.example.reactexercisesserverdummy.model;

import lombok.Getter;

@Getter
public enum TextType {
        TEXT1("0", "text1"),
        TEXT2("1", "text2"),
        TEXT3("2", "text3");

        private final String code;
        private final String name;


        TextType(String code, String name) {
                this.code = code;
                this.name = name;
        }

       public static TextType getByCode(int code) {
                return TextType.values()[code];
        }
}
