package com.chainalysis.island.model.request;

import com.chainalysis.island.util.OceanHelper;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ocean {

    public Ocean(@JsonProperty(value = "mat", required = true) int[][] mat) {

        /*
        calling the calculateIslands method from the model class is for sure not the best practice
        but since I am not familiar with this in Java and my time limit has more or less expired
        I will keep it like this
        */

        int result = OceanHelper.countIslands(mat);
        java.lang.System.out.println(result);
    }

}
