package qsf.utils;

import qsf.entity.FeatureVector;


public class Standardization {


    public static double[] maxValues = new double[Parameters.NUM_FEATURES];
    public static double[] minValues = new double[Parameters.NUM_FEATURES];

    public static boolean hasMinMaxArrays=false;

    public static void generateMinMaxArrays(FeatureVector[] data){
        if (data == null || data.length==0)
            return;

        hasMinMaxArrays = true;
        int numFeature = Parameters.NUM_FEATURES;
        System.out.println("Standardization initialize...");

        double value;

        for (int i=1; i < data.length; ++i){

            for (int j=0; j < numFeature; ++j){
                value = data[i].get(j);
                if (value > maxValues[j]){
                    maxValues[j] = value;
                }

                if (value < minValues[j])
                    minValues[j] =value;
            }
        }
    }

    public static FeatureVector[] minMaxStandardize(FeatureVector[] data){
        int numFeature = Parameters.NUM_FEATURES;

        System.out.println("Standardization initialize...");
        for (int i=0; i < data.length; ++i){
            for (int j=0; j < numFeature; ++j){
                data[i].set(j, (data[i].get(j)-minValues[j]+1) / (maxValues[j]-minValues[j]+1));
            }
        }

        return data;
    }
}
