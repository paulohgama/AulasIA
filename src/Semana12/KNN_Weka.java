package Semana11;

import weka.classifiers.lazy.IBk;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author kbrtec
 */
public class KNN_Weka {
    public static void main(String[] args) throws Exception
    {
        DataSource arff = new DataSource("data/simpsons.arff");
        Instances simpsons = arff.getDataSet();
        
        simpsons.setClassIndex(3);
        
        Instance comic = new DenseInstance(4);
        comic.setDataset(simpsons);
        comic.setValue(0, 8);
        comic.setValue(1, 140); //Feminino 140 e Masculino 290 
        comic.setValue(2, 38);
        
        IBk knn = new IBk(3);
        knn.buildClassifier(simpsons);
        
        double grupo = knn.classifyInstance(comic);
        System.out.println("Grupo: " + grupo);
        comic.setClassValue(grupo);
        System.out.println("Rótulo: " + comic.stringValue(3));
    }
}
