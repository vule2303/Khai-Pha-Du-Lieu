package wekaassignment26.pkg09;

import weka.associations.Apriori;
import weka.core.Instances;

public class MyAprioriModel extends MyKnowledgeModel{
    Apriori apriori;
    Instances newDataset;

    public MyAprioriModel(){}

    public MyAprioriModel(String filename, String model_options, String data_options) throws Exception{
        super(filename, model_options, data_options);
        this.apriori = new Apriori();
    }

    public void MyAssociationRule() throws Exception {
        //newDataset = removeData(this.dataset);
        this.newDataset = convertData(this.dataset);
        apriori.setOptions(this.model_options);
        apriori.buildAssociations(this.newDataset);
    }

    @Override
    public String toString(){
        return apriori.toString();
    }
}