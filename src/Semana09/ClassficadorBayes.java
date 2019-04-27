package Semana09;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * @author Paulo Henrique
 */
public class ClassficadorBayes {

    public static void main(String[] args) throws Exception {
        DataSource arff = new DataSource("data/contact-lenses.arff");
        
        Instances lenses = arff.getDataSet();
        
        lenses.setClassIndex(4);
        
        NaiveBayes bayes = new NaiveBayes();
        
        bayes.buildClassifier(lenses);
        
        /*
            {presbyopic,myope,no,reduced,?}
            {presbyopic,hypermetrope,no,normal,?}
            {young,hypermetrope,yes,normal,?}
        */
        
        //System.out.print(bayes);
        
        Instance desconhecido1 = new DenseInstance(5);
        Instance desconhecido2 = new DenseInstance(5);
        Instance desconhecido3 = new DenseInstance(5);
        
        desconhecido1.setDataset(lenses);
        desconhecido2.setDataset(lenses);
        desconhecido3.setDataset(lenses);
        
        desconhecido1.setValue(0, "presbyopic");
        desconhecido1.setValue(1, "myope");
        desconhecido1.setValue(2, "no");
        desconhecido1.setValue(3, "reduced");
        
        desconhecido2.setValue(0, "presbyopic");
        desconhecido2.setValue(1, "hypermetrope");
        desconhecido2.setValue(2, "no");
        desconhecido2.setValue(3, "normal");
        
        desconhecido3.setValue(0, "young");
        desconhecido3.setValue(1, "hypermetrope");
        desconhecido3.setValue(2, "yes");
        desconhecido3.setValue(3, "normal");
        
        double classe1 = bayes.classifyInstance(desconhecido1);
        double classe2 = bayes.classifyInstance(desconhecido2);
        double classe3 = bayes.classifyInstance(desconhecido3);
        
        System.out.println("Grupo do 1: " + classe1);
        System.out.println("Grupo do 2: " + classe2);
        System.out.println("Grupo do 3: " + classe3);
        
        desconhecido1.setClassValue(classe1);
        desconhecido2.setClassValue(classe2);
        desconhecido3.setClassValue(classe3);
        
        System.out.println("Rotulo do 1: " + desconhecido1.stringValue(4));
        System.out.println("Rotulo do 2: " + desconhecido2.stringValue(4));
        System.out.println("Rotulo do 3: " + desconhecido3.stringValue(4));
        
    }
    
}
