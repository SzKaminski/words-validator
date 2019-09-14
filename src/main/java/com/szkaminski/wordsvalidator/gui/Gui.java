package com.szkaminski.wordsvalidator.gui;

import com.szkaminski.wordsvalidator.model.Content;
import com.szkaminski.wordsvalidator.validator.WordsValidator;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

import java.io.IOException;

@Route(value = "")
public class Gui extends Div {

    public Gui() throws IOException {
        TextField field = getTextField();
        add(field);

        Binder<Content> binder = new Binder<>();
        binder.forField(field)
                .withValidator(new WordsValidator("Its not a good word"))
                .bind(Content::getContent, Content::setContent);


    }

    private TextField getTextField() {
        return new TextField("Try to type good content");
    }

}
