package semana06_02;

import weka.classifiers.lazy.IBk;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class UsandoWeka {
     
    public static void main(String[] args) throws Exception{
        
        //LER ARQUIVO ARFF 
        DataSource arff = new DataSource("iris.arff");
        Instances iris = arff.getDataSet();
        System.out.println(iris.instance(0));        
        
        
        
    }
    
}
