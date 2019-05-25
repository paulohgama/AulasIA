package Semana16;

import weka.classifiers.trees.Id3;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class ArvoreDeDecisao {

    public static void main(String[] args) throws Exception {
        DataSource arff = new DataSource("data/contact-lenses.arff");
        DataSource arff2 = new DataSource("data/iris.arff");
        //Instancia e reordena
        Instances contact = arff.getDataSet(4);
        Instances iris = arff2.getDataSet(4);
        //Define indice da classe
        Id3 arvore = new Id3();
        J48 arvoreJ48 = new J48();
        J48 arvoreirisJ48 = new J48();

        arvore.buildClassifier(contact);
        arvoreJ48.buildClassifier(contact);
        arvoreirisJ48.buildClassifier(iris);
        
        System.out.println(arvore + "\n");
        System.out.println("-----------------------------------------------");
        System.out.println(arvoreJ48);
        System.out.println("-----------------------------------------------");
        System.out.println(arvoreirisJ48);
        
}
    
}
