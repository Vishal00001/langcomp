package com.utility.comparisonutility;


import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import static org.mockito.Mockito.when;

/**
 * Created by vishal on 19/3/21.
 */
@RunWith(MockitoJUnitRunner.class)
class PolishNotationTest {

    @Mock
    PostfixNotation postfixNotation;

    @BeforeMethod
    public void setup() {

        // setup resources to be used in with test cases
        //postfixNotation = Mockito.mock((PostfixNotation.class));
        MockitoAnnotations.initMocks(this);

    }

    @Test(dataProvider = "dataProvider")
    public void postfixNotationTest(String expression, double result){
        try {
            Assert.assertEquals(postfixNotation.evalPostfix(expression), result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] { new Object[] { "50 % 2 *", 1.0 }, new Object[] { "3 ! 4 5 * +", 26.0 }, };
    }
}