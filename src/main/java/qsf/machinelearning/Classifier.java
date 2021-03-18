package qsf.machinelearning;

import qsf.entity.FeatureVector;

import java.io.IOException;
import java.util.List;


public interface Classifier {

    public boolean train(FeatureVector[] data) throws IOException;

    public int[] predict(FeatureVector[] featureVector);

    public boolean hasTrain(String uid);

}
