package Semana09;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Paulo
 */
public class CancerMapear {

    public static void main(String[] args) throws Exception {
        DataSource arff = new DataSource("data/breast-cancer.arff");
        
        Instances breast = arff.getDataSet();
        
        breast.setClassIndex(9);
        NaiveBayes bayes = new NaiveBayes();
        
        bayes.buildClassifier(breast);
        
        Instance desconhecido = new DenseInstance(10);
        
        desconhecido.setDataset(breast);
        
        desconhecido.setValue(0, "50-59");
        desconhecido.setValue(1, "premeno");
        desconhecido.setValue(2, "25-29");
        desconhecido.setValue(3, "0-2");
        desconhecido.setValue(4, "yes");
        desconhecido.setValue(5, "1");
        desconhecido.setValue(6, "right");
        desconhecido.setValue(7, "left_low");
        desconhecido.setValue(8, "no");
        
        double classe = bayes.classifyInstance(desconhecido);
        desconhecido.setClassValue(classe);
        System.out.println("Rotulo: " + desconhecido.stringValue(9));
    }
    
}
