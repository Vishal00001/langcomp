package com.utility.comparisonUtility;

import com.utility.comparisonutility.PostfixNotation;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by vishal on 19/3/21.
 */

public class PostfixNotationTest {

    @MockBean
    public PostfixNotation postfixNotation;

    public PostfixNotationTest(){
        //code here
    }

    @BeforeAll
    void setUp(){
        //MockBean itself create a bean.
        //this.postfixNotation = Mockito.mock(PostfixNotation.class);
    }

    @Test
    public void postfixNotationTest(){
        try {
            assertEquals(postfixNotation.evalPostfix("50 % 2 *"), 2.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}