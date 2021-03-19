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

/*    private static ObjectMapper mapper = new ObjectMapper();
    private static final String RESULT_COUNT = "result_count";
    private static final String RESULT = "results";
    private static final String DOCK_NBR = "dock_nbr";
    private static final String DOCK_TYPE_ID = "dock_type_id";
    private static final String MOD_USER = "mod_user";
    private static final String DOCK_REF_NBR= "dock_ref_nbr";
    private static final String RESULT_3 = "result_3";*/

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

        while(flag){
        	System.out.println("Please enter the expression:");
			try {
				System.out.println("Your result is: " + notation.evalPostfix(sc.nextLine()));
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

			System.out.println("Do you want to continue? (Y/N)");
			flag = StringUtils.equalsIgnoreCase(sc.nextLine().trim(), "Y") ? true : false;
		}

		if(!flag){
        	System.out.println("Goodbye!");
        	System.exit(0);
		}


        /**This is implemented without Java POJOs
         * I am using linux, therefore the path location of source and result file is according to Linux file system.
         *
         ArrayList<LinkedHashMap> list;
        LinkedHashMap map = readFile();
        list = extractObjectAsList(map);
		testCase1(list);
		testCase2(list);
		testCase3(list, map);

		*This can also be implemented by converting Json schema into Java POJOs.
         *
         * Please let me know if this implementation should be with Java Beans and POJOs.
*/	}

/**
     * readFile method reads the file from the given file path and converts
     * into LinkedHashMap class.Return type value LinkedHashMap
     *//*

	private static LinkedHashMap readFile(){
		LinkedHashMap map = null;
        try {
            map = mapper.readValue(new File("/tmp/sample_json.txt"), LinkedHashMap.class);

            if(map.isEmpty() || Objects.isNull(map))
                System.out.println("Source file is empty.");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }

    */
/**
     * extractObjectAsList method checks data and cast LinkedHashMap into an ArrayList
     * argument required LinkedHapMap
     * return value type of ArrayList<LinkedHashMap>
     *//*

    private static ArrayList<LinkedHashMap> extractObjectAsList(LinkedHashMap map){
        ArrayList result;

        if(((int)map.get(RESULT_COUNT)) <= 0)
            System.out.println("No data present in the file. result_count is 0.");

        result = (ArrayList)map.get(RESULT);

        return result;
    }

    */
/**
     * testCase1 method stream the list map the mod_user data, distinct the list and print it on console.
     * argument required ArrayList<LinkedHashMap>
     * return void
     *//*

    private static void testCase1(ArrayList<LinkedHashMap> list){
        System.out.println("\n==== TestCase 1 =======\n");
        list.stream().map(o -> o.get(MOD_USER)).distinct().collect(Collectors.toList()).stream().forEach(o->{System.out.println(o);});
	}

    */
/**
     * testCase2 method stream the list using forEach get the dock_type_id param reads it key checks and print dock_nbr
     * argument required ArrayList<LinkedHashMap>
     * return void
     *//*

    private static void testCase2(ArrayList<LinkedHashMap> list){
        System.out.println("\n==== TestCase 2 =======\n");

        list.forEach(o->{
            if(Arrays.asList(((LinkedHashMap) o.get(DOCK_TYPE_ID)).get("key").toString().trim().split("/")).contains("IN"))
                System.out.println(o.get(DOCK_NBR));
        });
	}

    */
/**
     * testCase3 method removes the null and empty dock_ref_nbr from the list.
     * put the list again in map with count, converts the map into json string and write json in txt file.
     * argument required ArrayList<LinkedHashMap>, LinkedHashMap
     * return void
     *//*

    private static void testCase3(ArrayList<LinkedHashMap> list, LinkedHashMap map){
        System.out.println("\n==== TestCase 3 =======\n");

        list.removeAll(list.stream().filter(o-> o.get(DOCK_REF_NBR) == null || StringUtils.isEmpty(o.get(DOCK_REF_NBR).toString())).collect(Collectors.toList()));
        map.put(RESULT_COUNT, list.size());
        map.put(RESULT, list);

        try {
            FileUtils.fileWriter(JsonUtils.ObjectToString(map), RESULT_3);
            System.out.println("Result of testcase 3 is in file: /tmp/result_3.txt\n");
        } catch (IOException e) {
            System.out.println("\n Exception Occurred while writing testcase 3 in file.\n");
            e.printStackTrace();

        }
    }
*/

}