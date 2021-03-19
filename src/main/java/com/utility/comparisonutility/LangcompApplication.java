package com.utility.comparisonutility;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import java.util.*;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class LangcompApplication {

    public static void main(String[] args) {

        SpringApplication.run(LangcompApplication.class, args);

        runPolishNotation(new Scanner(System.in));

    }

    private static void runPolishNotation(Scanner sc){

        boolean flag = true;
        PolishNotation notation = new PostfixNotation();

        while (flag) {
            System.out.println("Please enter the expression:");
            try {
                System.out.println("Your result is: " + notation.evalPostfix(sc.nextLine()));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }

            System.out.println("Do you want to continue? (Y/N)");
            flag = StringUtils.equalsIgnoreCase(sc.nextLine().trim(), "Y") ? true : false;
        }

        if (!flag) {
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }

}