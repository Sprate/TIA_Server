package qsf.service;

import qsf.entity.FeatureVector;
import qsf.entity.UserTouch;
import qsf.machinelearning.Classifier;

import java.util.HashMap;
import java.util.List;


public interface IUserClassifierService {

    HashMap<String, Classifier> classifierHashMap = new HashMap<String, Classifier>();

    //一共有三种状态：0表示未训练，1表示正在训练，2表示训练完成
    HashMap<String, Integer> classifierStateMap = new HashMap<>();

    int MIN_TRAIN_NUM = 50;

    int MAX_POS_NUM =20;
    int innitial_num=500;

    public Classifier getClassifier(String uid);

    public void put(String uid, Classifier classifier);

    public int computeUserTouchsScore(List<UserTouch> userTouches);
}
