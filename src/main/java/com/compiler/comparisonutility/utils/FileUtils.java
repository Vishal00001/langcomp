package com.compiler.comparisonutility.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by vishal on 25/11/20.
 */
public class FileUtils {

    private static String fileName;

    public FileUtils(String fileName){
        this.fileName = fileName;
    }

    public static void fileWriter(String data) throws IOException {

        // Creates a FileWriter
        File file = new File("/tmp/gonogo_script.txt");

        if(file.exists())
            file.delete();

        file.createNewFile();
        FileWriter output = new FileWriter(file);

        // Writes the string to the file
        output.write(data);
    }
}
