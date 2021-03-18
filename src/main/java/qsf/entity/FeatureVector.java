package qsf.entity;

import qsf.utils.Parameters;


public class FeatureVector {

    public String uid;

    public int numFeatures = Parameters.NUM_FEATURES;

    public double[] fv = new double[numFeatures];

    public int label;


    public static FeatureVector generateFV(UserTouch userTouch) {
        FeatureVector featureVector = new FeatureVector();
        featureVector.fv[0] = Float.valueOf(userTouch.getStartX());
        featureVector.fv[1] = Float.valueOf(userTouch.getStartY());
        featureVector.fv[2] = Float.valueOf(userTouch.getEndX());
        featureVector.fv[3] = Float.valueOf(userTouch.getEndY());
        featureVector.fv[4] = Float.valueOf(userTouch.getDuration());
        featureVector.fv[5] = Float.valueOf(userTouch.getDirectEndToEndDistance());
        featureVector.fv[6] = Float.valueOf(userTouch.getMeanLength());
        featureVector.fv[7] = Float.valueOf(userTouch.getTwentyVelocity());
        featureVector.fv[8] = Float.valueOf(userTouch.getFiftyVelocity());
        featureVector.fv[9] = Float.valueOf(userTouch.getEightyVelocity());
        featureVector.fv[10] = Float.valueOf(userTouch.getTwentyAcceleration());
        featureVector.fv[11] = Float.valueOf(userTouch.getFiftyAcceleration());
        featureVector.fv[12] = Float.valueOf(userTouch.getEightyAcceleration());
        featureVector.fv[13] = Float.valueOf(userTouch.getDirectionEndToEndLine());
        featureVector.fv[14] = Float.valueOf(userTouch.getTrajectoryLength());
        featureVector.fv[15] = Float.valueOf(userTouch.getMeanVelocity());
        featureVector.fv[16] = Float.valueOf(userTouch.getPressureMiddleStroke());
        featureVector.fv[17] = Float.valueOf(userTouch.getMiddleStrokeArea());
        featureVector.fv[18] = Float.valueOf(userTouch.getPhoneOrientation());
        featureVector.fv[19] = Float.valueOf(userTouch.getFlagDirection());
        featureVector.fv[20] = Float.valueOf(userTouch.getRatioDistanceTraj());
        featureVector.fv[21] = Float.valueOf(userTouch.getLargestDeviation());
        featureVector.fv[22] = Float.valueOf(userTouch.getTwentyDeviation());
        featureVector.fv[23] = Float.valueOf(userTouch.getFiftyDeviation());
        featureVector.fv[24] = Float.valueOf(userTouch.getEightyVelocity());

        featureVector.uid = userTouch.getUserid();

        return featureVector;
    }

    public double get(int i){
        return fv[i];
    }

    public void set(int i, double value){
        fv[i] = value;
    }

    public String getUid(){
        return uid;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public int getLabel(){
        return label;

    }


}
