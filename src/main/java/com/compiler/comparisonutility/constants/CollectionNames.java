package com.compiler.comparisonutility.constants;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vishal on 24/11/20.
 */
public class CollectionNames {

    public static List<String> singleDocCollections = new LinkedList<>();
    public static List<String> multiDocCollections = new LinkedList<>();

    static{
        singleDocCollections.add("institutionConfig");
    }

    static{
        multiDocCollections.add("actionConfiguration");
    }
}
