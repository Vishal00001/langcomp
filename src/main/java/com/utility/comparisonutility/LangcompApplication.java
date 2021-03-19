package com.utility.comparisonutility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.utility.comparisonutility.utils.FileUtils;
import com.utility.comparisonutility.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class LangcompApplication {

    public static void main(String[] args) {

        SpringApplication.run(LangcompApplication.class, args);
        Scanner sc = new Scanner(System.in);

        Result result = JUnitCore.runClasses(com.utility.comparisonutility.PolishNotationTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());

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