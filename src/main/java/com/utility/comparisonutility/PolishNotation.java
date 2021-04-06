package com.utility.comparisonutility;

/**
 * Created by vishal on 18/3/21.
 */
public interface PolishNotation {
    /**
     * evalPostfix method evaluate the Reverse Polish Notation
     * @argument required String expression
     * @return value is double
     */
    double evalPostfix(String exp) throws Exception;

    /**
     * runPolishNotation method is a default implementatiion to run the polish notation
     * @argument no arguments
     * @return void
     */
    void runPolishNotation();
}
