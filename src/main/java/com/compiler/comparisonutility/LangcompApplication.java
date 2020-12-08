package com.compiler.comparisonutility;

import com.compiler.comparisonutility.controllers.ServiceController;
import com.compiler.comparisonutility.utils.Analysers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class LangcompApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LangcompApplication.class, args);

		Analysers.argsAnalyser(args); // Analysing passed arguments and storing them in static field;
		Analysers.lexicalAnalyser();  // Analysing passed arguments lexicals whether they are familiar or not;
		Analysers.institutionIdAnalyser(); // Analysing passed source and destination's institution Id;
		ServiceController serviceController = new ServiceController(Analysers.action);
		serviceController.execute();
		System.out.print("\nDone!\n");
		System.exit(0);

	}



}