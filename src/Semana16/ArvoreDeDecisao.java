package Semana16;

import weka.classifiers.trees.Id3;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class ArvoreDeDecisao {

    public static void main(String[] args) throws Exception {
        DataSource arff = new DataSource("data/contact-lenses.arff");
        //Instancia e reordena
        Instances contact = arff.getDataSet(4);
        //Define indice da classe
        Id3 arvore = new Id3();
        
        arvore.buildClassifier(contact);
        
        J48 arvoreJ48 = new J48();
        
        arvoreJ48.buildClassifier(contact);
        
        System.out.println(arvoreJ48);
    }
    
}
