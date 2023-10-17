/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wekaassignment26.pkg09;

/**
 *
 * @author ITD
 */
public class WekaAssignment2609 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

//        MyKnowledgeModel model = new MyKnowledgeModel("C:\\Program Files\\Weka-3-9-6\\data\\iris.arff", null,null);
//        model.trainSet = model.divideTrainTestR(model.dataset,80,false);
//        model.testSet = model.divideTrainTestR(model.dataset,80,true);
//        System.out.println(model);
//        System.out.println(model.trainSet.toSummaryString());
//        System.out.println(model.testSet.toSummaryString());

//        MyDecisionTreeModel model = new MyDecisionTreeModel("C:\\Program Files\\Weka-3-9-6\\data\\iris.arff", "-C 0.25 -M 2",null);
//        model.buildDecisionTree();
//        model.CrossValidationDecisionTree(10);
//        System.out.println(model);

        MyKMeansModel model = new MyKMeansModel();
        model.buildKmeansModel("D:\\Hoàng 12208124\\iris_train.arff");
        System.out.println(model);

    }
}
