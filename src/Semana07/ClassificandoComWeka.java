package Semana07;

import weka.classifiers.lazy.IBk;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Paulo
 */
public class ClassificandoComWeka {

    public static void main(String[] args) throws Exception {
        DataSource arff = new DataSource("data/iris.arff");
        
        Instances iris = arff.getDataSet();
        int indexClasse = iris.numAttributes();
        iris.setClassIndex(indexClasse-1);
        
        Instance plantaDesconhecida = new DenseInstance(indexClasse);
        double[] atributos = { 5.1, 3.5, 1.4, 0.2 };
        plantaDesconhecida.setDataset(iris);
        for(int i = 0; i < indexClasse-1; i++)
            plantaDesconhecida.setValue(i, atributos[i]);
        IBk vizinho = new IBk();
        vizinho.buildClassifier(iris);
        
        double grupo = vizinho.classifyInstance(plantaDesconhecida);
        
        System.out.println("Group: " + grupo);
        plantaDesconhecida.setClassValue(grupo);
        System.out.println("Rótulo: " + plantaDesconhecida.stringValue(4));
    }
    
}
