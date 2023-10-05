package wekaassignment26.pkg09;
import org.omg.CORBA.WStringSeqHelper;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Debug;

import java.util.Random;

public class MyDecisionTreeModel extends MyKnowledgeModel{
    J48 tree;
    public MyDecisionTreeModel(String fileName, String model_options, String data_options) throws Exception {
        super(fileName,model_options,data_options);
    }

    public  void buildDecisionTree() throws Exception {
        //Create data train test
        this.trainSet = divideTrainTestR(this.dataset,80,false);
        this.testSet = divideTrainTestR(this.dataset,80,true);
        this.trainSet.setClassIndex(this.trainSet.numAttributes() -1);
        this.testSet.setClassIndex(this.testSet.numAttributes() -1);
        //Config object with train data

        tree = new J48();
        tree.setOptions(this.model_options);
        //training with data train
        tree.buildClassifier(this.trainSet);

    }

    public void evaluateDecisionTree() throws Exception {
        Evaluation eval = new Evaluation(this.trainSet);
        eval.evaluateModel(tree,this.testSet);
        System.out.println(eval.toSummaryString("\nResult\n-----\n",false));
    }
    public void CrossValidationDecisionTree(int folds) throws Exception {
        Random rd = new Debug.Random(1);
        Evaluation eval = new Evaluation(this.trainSet);
        eval.crossValidateModel(tree,this.testSet,folds,rd);
        System.out.println(eval.toSummaryString("\nResult Cross-Validation\n-----\n",false));
    }
    @Override
    public String toString(){
        return tree.toSummaryString();
    }
}
