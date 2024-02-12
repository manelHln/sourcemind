package com.phonebook;

import java.io.BufferedReader;
import java.util.Scanner;

public abstract class PhonebookActions implements SearchWithName, SearchWithNumber {
    public boolean validateFileData(int count){
        return count < 5;
    }

    public boolean validateName(String str){
        return str.length() >= 3;
    }
}
