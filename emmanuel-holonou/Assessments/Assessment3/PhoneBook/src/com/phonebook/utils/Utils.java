package com.phonebook.utils;

import java.util.Arrays;

public class Utils {

    public static String removeSpaces(String str){
        String[] temp = str.split(" ");
        String word = "";
        for(String w : temp){
            word = word.concat(w);
        }
        return word;
    }
}
