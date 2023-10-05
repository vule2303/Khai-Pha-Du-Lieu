package wekaassignment26.pkg09;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NominalToBinary;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.filters.unsupervised.attribute.Remove;
import weka.filters.unsupervised.instance.RemovePercentage;
import weka.filters.unsupervised.instance.Resample;

import java.io.IOException;

import static weka.core.Utils.splitOptions;

public class MyKnowledgeModel {
    DataSource source;
    Instances dataset;
    String[] model_options;
    String[] data_options;
    Instances trainSet;
    Instances testSet;


    public MyKnowledgeModel() {}

    public MyKnowledgeModel(String filename,
                            String model_options,
                            String data_options) throws Exception {
        this.source = new DataSource(filename);
        this.dataset = source.getDataSet();
        if (model_options != null){
            this.model_options = splitOptions(model_options);
        }
       if(data_options != null){
           this.data_options = splitOptions(data_options);
       }

    }

    public Instances removeData(Instances originalData) throws Exception {
        Remove remove = new Remove();
        remove.setOptions(data_options);
        remove.setInputFormat(originalData);
        return Filter.useFilter(originalData, remove);
    }
    public void SaveData(String filename) throws IOException {
        ArffSaver saver = new ArffSaver();
        saver.setInstances(dataset);
    }

    public Instances convertData(Instances originalData) throws Exception {
        NumericToNominal n2n = new NumericToNominal();
        n2n.setOptions(data_options);
        n2n.setInputFormat(originalData);
        return Filter.useFilter(originalData, n2n);
    }

    public Instances convert2Binary(Instances originalData) throws Exception {
        NominalToBinary n2b = new NominalToBinary();
        n2b.setOptions(data_options);
        n2b.setBinaryAttributesNominal(true);
        n2b.setInputFormat(originalData);
        return Filter.useFilter(originalData,n2b);
    }

    public Instances divideTrainTest(Instances originalSet, double percent,boolean isTest) throws Exception {
        RemovePercentage rp = new RemovePercentage();
        rp.setPercentage(percent);
        rp.setInvertSelection(isTest);
        rp.setInputFormat(originalSet);

        return Filter.useFilter(originalSet, rp);
    }

    public  Instances divideTrainTestR(Instances originalSet, double percent, boolean isTest) throws Exception {
        Resample rs = new Resample();
        rs.setNoReplacement(true);
        rs.setSampleSizePercent(percent);
        rs.setInvertSelection(isTest);
        rs.setInputFormat(dataset);
        return  Filter.useFilter(originalSet,rs);
    }
    @Override
    public String toString(){
        return  dataset.toSummaryString();
    }
}