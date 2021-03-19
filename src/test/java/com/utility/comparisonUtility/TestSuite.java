package com.utility.comparisonUtility;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by vishal on 19/3/21.
 */
public class TestSuite {
    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(PolishNotationSuite.class);
        for(Failure failure : result.getFailures()){

            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}
