package wekaassignment26.pkg09;

import weka.associations.Apriori;
import weka.associations.FPGrowth;
import weka.core.Instances;

public class MyFPGrowthModel extends MyAprioriModel{
    FPGrowth fpGrowth;
    Instances newDataset;

    public MyFPGrowthModel(){}

    public MyFPGrowthModel(String filename, String model_options, String data_options) throws Exception{
        super(filename, model_options, data_options);
        this.fpGrowth = new FPGrowth();
    }

    public void MyAssociationRule() throws Exception {
        //newDataset = removeData(this.dataset);
        this.newDataset = convert2Binary(this.dataset);
        fpGrowth.setOptions(this.model_options);
        fpGrowth.buildAssociations(this.newDataset);
    }

    @Override
    public String toString(){
        return fpGrowth.toString();
    }
}
