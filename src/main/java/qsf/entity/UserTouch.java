package qsf.entity;

public class UserTouch {

    private String userid; //F1

    private float startX; //F2

    private float startY; //F3

    private float endX; //F4

    private float endY; //F5

    private float directEndToEndDistance; //F6

    private float duration; //F7

    private float meanLength; //F8

    private float twentyVelocity; //F9

    private float fiftyVelocity; //F10

    private float eightyVelocity; //F11

    private float meanVelocity; //F12

    private float twentyAcceleration; //F13

    private float fiftyAcceleration; //F14

    private float eightyAcceleration; //F15

    private float directionEndToEndLine; //F16

    private float trajectoryLength; //F17

    private float pressureMiddleStroke; //F18

    private float middleStrokeArea; //F19

    private float ratioDistanceTraj; //F20

    private float phoneOrientation; //F21

    private float flagDirection; //F22

    private float largestDeviation; //F23

    private float twentyDeviation; //F24

    private float fiftyDeviation; //F25

    private float eightyDeviation; //F26

    private long timestamp; //F27


    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public float getStartX() {
        return startX;
    }

    public void setStartX(Float startX) {
        this.startX = startX;
    }

    public float getStartY() {
        return startY;
    }

    public void setStartY(Float startY) {
        this.startY = startY;
    }

    public float getEndX() {
        return endX;
    }

    public void setEndX(Float endX) {
        this.endX = endX;
    }

    public float getEndY() {
        return endY;
    }

    public void setEndY(Float endY) {
        this.endY = endY;
    }

    public float getDirectEndToEndDistance() {
        return directEndToEndDistance;
    }

    public void setDirectEndToEndDistance(Float directEndToEndDistance) {
        this.directEndToEndDistance = directEndToEndDistance;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public float getMeanLength() {
        return meanLength;
    }

    public void setMeanLength(Float meanLength) {
        this.meanLength = meanLength;
    }

    public float getTwentyVelocity() {
        return twentyVelocity;
    }

    public void setTwentyVelocity(Float twentyVelocity) {
        this.twentyVelocity = twentyVelocity;
    }

    public float getFiftyVelocity() {
        return fiftyVelocity;
    }

    public void setFiftyVelocity(Float fiftyVelocity) {
        this.fiftyVelocity = fiftyVelocity;
    }

    public float getEightyVelocity() {
        return eightyVelocity;
    }

    public void setEightyVelocity(Float eightyVelocity) {
        this.eightyVelocity = eightyVelocity;
    }

    public float getMeanVelocity() {
        return meanVelocity;
    }

    public void setMeanVelocity(Float meanVelocity) {
        this.meanVelocity = meanVelocity;
    }

    public float getTwentyAcceleration() {
        return twentyAcceleration;
    }

    public void setTwentyAcceleration(Float twentyAcceleration) {
        this.twentyAcceleration = twentyAcceleration;
    }

    public float getFiftyAcceleration() {
        return fiftyAcceleration;
    }

    public void setFiftyAcceleration(Float fiftyAcceleration) {
        this.fiftyAcceleration = fiftyAcceleration;
    }

    public float getEightyAcceleration() {
        return eightyAcceleration;
    }

    public void setEightyAcceleration(Float eightyAcceleration) {
        this.eightyAcceleration = eightyAcceleration;
    }

    public float getDirectionEndToEndLine() {
        return directionEndToEndLine;
    }

    public void setDirectionEndToEndLine(Float directionEndToEndLine) {
        this.directionEndToEndLine = directionEndToEndLine;
    }

    public float getTrajectoryLength() {
        return trajectoryLength;
    }

    public void setTrajectoryLength(Float trajectoryLength) {
        this.trajectoryLength = trajectoryLength;
    }

    public float getPressureMiddleStroke() {
        return pressureMiddleStroke;
    }

    public void setPressureMiddleStroke(Float pressureMiddleStroke) {
        this.pressureMiddleStroke = pressureMiddleStroke;
    }

    public float getMiddleStrokeArea() {
        return middleStrokeArea;
    }

    public void setMiddleStrokeArea(Float middleStrokeArea) {
        this.middleStrokeArea = middleStrokeArea;
    }

    public float getRatioDistanceTraj() {
        return ratioDistanceTraj;
    }

    public void setRatioDistanceTraj(Float ratioDistanceTraj) {
        this.ratioDistanceTraj = ratioDistanceTraj;
    }

    public float getPhoneOrientation() {
        return phoneOrientation;
    }

    public void setPhoneOrientation(Float phoneOrientation) {
        this.phoneOrientation = phoneOrientation;
    }

    public float getFlagDirection() {
        return flagDirection;
    }

    public void setFlagDirection(Float flagDirection) {
        this.flagDirection = flagDirection;
    }

    public float getLargestDeviation() {
        return largestDeviation;
    }

    public void setLargestDeviation(Float largestDeviation) {
        this.largestDeviation = largestDeviation;
    }

    public float getTwentyDeviation() {
        return twentyDeviation;
    }

    public void setTwentyDeviation(Float twentyDeviation) {
        this.twentyDeviation = twentyDeviation;
    }

    public float getFiftyDeviation() {
        return fiftyDeviation;
    }

    public void setFiftyDeviation(Float fiftyDeviation) {
        this.fiftyDeviation = fiftyDeviation;
    }

    public float getEightyDeviation() {
        return eightyDeviation;
    }

    public void setEightyDeviation(Float eightyDeviation) {
        this.eightyDeviation = eightyDeviation;
    }
}