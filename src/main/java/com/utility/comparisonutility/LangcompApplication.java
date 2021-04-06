package com.utility.comparisonutility;

public class LangcompApplication {

    public static void main(String[] args) {

        /**
         * No need of the SpringApplication context as this is console based program.
         */
        //SpringApplication.run(PolishnotationApplication.class, args);

        PolishNotation polishNotation = new PostfixNotation();
        polishNotation.runPolishNotation();

    }
}