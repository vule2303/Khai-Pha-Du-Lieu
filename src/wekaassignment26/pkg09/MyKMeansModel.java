package wekaassignment26.pkg09;

import weka.classifiers.Evaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.EuclideanDistance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class MyKMeansModel extends MyKnowledgeModel{
    SimpleKMeans kmeans;
    Evaluation eval;
    public MyKMeansModel(){

    }
    public MyKMeansModel(String filename, String m_opts, String d_opts) throws Exception{
        super(filename,m_opts,d_opts);
    }

    public void buildKmeansModel (String filename) throws Exception{
        setTrainSet(filename);

        kmeans = new SimpleKMeans();
        kmeans.setNumClusters(3);
        kmeans.setDistanceFunction(new EuclideanDistance());
        kmeans.buildClusterer(trainSet);

        System.out.println(kmeans);
    }

    public void predictCluster(String filename) throws Exception{
        DataSource ds = new DataSource(filename);
        Instances unlabel = ds.getDataSet();

        for (int i = 0; i< unlabel.numInstances();i++){
            double predict = kmeans.clusterInstance(unlabel.instance(i));
            System.out.println("Instance "+ i + " belongs to cluster "+predict);
        }
    }
}
