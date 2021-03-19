package com.utility.comparisonutility.utils;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Created by vishal on 25/02/21.
 */
public class FileUtils {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(FileUtils.class);

    private static String fileName;

    private static Date runningDate;


    static {
        File parentPath = new File("/tmp/gonogo_comparison_utility/");

        if(!parentPath.exists()){
            parentPath.mkdir();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateWithoutTime = new Date();
        try {
            dateWithoutTime = sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            logger.error("Exception occurred while creating folder by date: {}", e.getStackTrace());
           System.exit(0);
        }

        File childPath = new File("/tmp/gonogo_comparison_utility/"+ dateWithoutTime);

        if(!childPath.exists()){
            childPath.mkdir();
        }

        runningDate = dateWithoutTime;

    }

    public static void fileWriter(String data, String filename) throws IOException {

        // Creates a FileWriter
        File file = new File("/tmp/"+filename+".txt");

        if(file.exists())
            file.delete();

        file.createNewFile();
        FileWriter output = new FileWriter(file);

        // Writes the string to the file
        output.write(data);
        output.close();
    }

}
