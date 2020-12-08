package com.compiler.comparisonutility.constants;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vishal on 26/11/20.
 */
public class Keywords {

    public static List<String> literals = new LinkedList<>();

    static{
        /**
         * Source and Destination added
         */

        literals.add("dev");
        literals.add("sit");
        literals.add("uat");
        literals.add("preprod");
        literals.add("prod");

        /**
         * Actions added
         */

        literals.add("compare");
        literals.add("move");
        literals.add("dump");

    }
}
