package qsf.machinelearning;

import libsvm.*;
import org.apache.log4j.Logger;
import qsf.entity.FeatureVector;
import qsf.utils.Standardization;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class SVMClassifier implements Classifier{

    private static Logger logger = Logger.getLogger(SVMClassifier.class);


    public svm_parameter parameter;

    public svm_model model;

    public int numFeatures;

    private String FILE_DIRECT = "E:\\project\\log-info\\"+"svm"+File.separator;

    public SVMClassifier(int numFeatures)	throws IllegalArgumentException {
        if (numFeatures < 1)
            throw new IllegalArgumentException("numFeatures must be greater " +
                    "than zero");
        this.numFeatures = numFeatures;

        this.parameter = new svm_parameter();
        setSVMParameter(
                1,
                0.5,
                0.5,
                1,
                svm_parameter.C_SVC,
                svm_parameter.RBF,
                20000,
                0.001
        );

    }
    /**
     *
     * @param probability SVM param -- see SVMlib doc for details
     * @param gamma SVM param -- see SVMlib doc for details
     * @param nu SVM param -- see SVMlib doc for details
     * @param C SVM param -- see SVMlib doc for details
     * @param svmType SVM param -- see SVMlib doc for details
     * @param kernelType SVM param -- see SVMlib doc for details
     * @param cacheSize SVM param -- see SVMlib doc for details
     * @param eps SVM param -- see SVMlib doc for details
     */
    public void setSVMParameter(int probability, double gamma,
                                double nu, double C, int svmType, int kernelType,
                                double cacheSize, double eps) {
        this.parameter.probability = probability;
        this.parameter.gamma = gamma;
        this.parameter.nu = nu;
        this.parameter.C = C;
        this.parameter.svm_type = svmType;
        this.parameter.kernel_type = kernelType;
        this.parameter.cache_size = cacheSize;
        this.parameter.eps = eps;
    }


    @Override
    public boolean train(FeatureVector[] data)
            throws IllegalArgumentException, IOException {

        if (data == null || data.length < 1)
            throw new IllegalArgumentException("Invalid data");

        // 判断是否存储训练模型的参数，如果已经存储过，则恢复
        if (hasTrain(data[0].getUid())) {
            return true;
        }

        System.out.println("训练开始。。。。");
        //if (!Standardization.hasMinMaxArrays)
          //  Standardization.generateMinMaxArrays(data);

        data = Standardization.minMaxStandardize(data);

        int nums = data.length;
        logger.warn("hello: "+nums);

        svm_problem problem = new svm_problem();

        problem.l = nums;
        problem.y = new double[nums];
        problem.x = new svm_node[nums][this.numFeatures];

        for (int i = 0; i < nums; ++i){
            problem.x[i] = new svm_node[this.numFeatures];
            for (int j = 0; j < this.numFeatures; ++j){
                svm_node node = new svm_node();
                node.index = j;
                node.value = data[i].get(j);
                problem.x[i][j] = node;
            }
            problem.y[i] = (double) data[i].getLabel();
        }
        System.out.println(problem);
        this.model = svm.svm_train(problem, this.parameter);
        if (this.model == null)
            throw new IllegalArgumentException("Malformed data. "
                    + "Failed to train");


        String directName = FILE_DIRECT+data[0].getUid();
        File file = new File(directName);
        if (!file.exists())
            file.mkdirs();
        file = new File(directName+"/parameter");
        if (!file.exists())
            file.createNewFile();

        svm.svm_save_model(directName+"/parameter", model);

        return true;
    }

    @Override
    public int[] predict(FeatureVector[] featureVectors) throws IllegalStateException {
        if (this.model == null )
            throw new IllegalArgumentException("Ivalid state of classifier");


        featureVectors = Standardization.minMaxStandardize(featureVectors);
        System.out.println("预测开始。。。。");
        int[] results = new int [featureVectors.length];

        svm_node[] nodes = new svm_node[this.numFeatures];
        for (int i=0; i < featureVectors.length; ++i) {
            for (int j = 0; j < this.numFeatures; ++j) {
                svm_node node = new svm_node();
                node.index = j;
                node.value = featureVectors[i].get(j);
                nodes[j] = node;
            }
            System.out.println(svm.svm_predict(this.model, nodes));
            results[i] = (int) svm.svm_predict(this.model, nodes);
        }

        return results;
    }

    @Override
    public boolean hasTrain(String uid) {
        String filename = FILE_DIRECT+uid+File.separator+"parameter";
        File file  = new File(filename);
        if (file.exists()) {
            try {
                this.model = svm.svm_load_model(filename);
                return true;
            } catch (IOException e) {
                logger.error("getModel error!");
            }

        }

        return false;

    }


}
