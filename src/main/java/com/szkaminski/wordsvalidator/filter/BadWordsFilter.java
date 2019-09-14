package com.szkaminski.wordsvalidator.filter;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BadWordsFilter {

    @Getter
    private static List<String> wordsList = new ArrayList<>();

    public BadWordsFilter() throws IOException {
        fillWordList();
    }

    private void fillWordList() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("src\\main\\resources\\static\\badwords.txt"));
        String line;
        while ((line = in.readLine()) != null) {
            wordsList.add(line);
        }
        in.close();
    }

    public Boolean isChecked(String value) {
        String lowerCaseValue = value.toLowerCase();
        String[] words = lowerCaseValue.split("\\s+");
        for (String badWord : wordsList) {
            for (String inputV : words) {
                if (inputV.equals(badWord)) {
                    return false;
                }
            }
        }
        return true;
    }

}
