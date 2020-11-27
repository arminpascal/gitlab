package com.chainalysis.island;

import com.chainalysis.island.model.request.Ocean;
import com.chainalysis.island.util.OceanHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
public class IslandApplication {

	private static int [][] parseCommandLineArgument(String[] args) {
		// reducing args to one string and remove all: '{'
		String argsAsString = String.join("", args).replace("{","");
		// splitting string at '},' and remove the '}}' at the end of the string
		String grid[] = argsAsString.substring(0,argsAsString.length()-2).split("},");

		int xDim = grid.length;
		int yDim = grid[0].replace(",","").length();

		int mat[][] = new int[xDim][yDim];

		// in case the args 2d array is non-rectangular the grid gets expand to a rectangular grid
		// and the missing fields are initiated with ocean
		for (int i = 0; i < xDim; i++) {
			// splitting the grid elements into an array of numbers
			String numbers[] = grid[i].split(",");
			for (int j = 0; j < numbers.length; j++) {
				mat[i][j] = Integer.parseInt(numbers[j]);
			}
		}

		return mat;
	}


	public static void main(String[] args) {

		SpringApplication.run(IslandApplication.class, args);
		/*
		Since it says the application should take a 2d array as an input,
		it is possible to parse a 2d array with the help program arguments
		usage e.g.: { {0, 0, 0}, {0, 0, 0}, {0, 0, 0} }.

		But since this is also Java using Spring Boot application
		I thought you maybe want to use an api call to input data
		usage in this case use: POST localhost:8080/api/v1/ocean
		with a json request body like e.g.
		{
			"mat": [
				[1, 1, 0, 0, 0],
				[0, 1, 0, 0, 1],
				[0, 0, 0, 1, 1]
			]
		}
		 */
		if (args.length != 0) {
			int mat[][] = parseCommandLineArgument(args);
			int result = OceanHelper.countIslands(mat);
			java.lang.System.out.println(result);
		}
	}

}
