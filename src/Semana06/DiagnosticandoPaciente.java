package Semana06;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;


public class DiagnosticandoPaciente {
    public static void main(String[] args) throws Exception {
        //LER ARQUIVO ARFF
        DataSource arff = new DataSource("contact-lenses.arff");
        //OBTER DADOS DO ARQUIVO E INSTANCIAR CONJUNTO DE DADOS
        Instances lenses = arff.getDataSet();
        //DEFINIR ÍNDICE DO ATRIBUTO CLASSE
        lenses.setClassIndex(4);
        //DEFINIR EXEMPLO A SER CLASSIFICADO
        Instance desconhecido = new DenseInstance(5); //qt atributos
        desconhecido.setDataset(lenses); //como serão esses atributos
        desconhecido.setValue(0, "presbyopic");
        desconhecido.setValue(1, "myope");
        desconhecido.setValue(2, "no");
        desconhecido.setValue(3, "normal");
        desconhecido.setClassMissing();
        //instanciar classificador
        NaiveBayes nb = new NaiveBayes();
        //treinar classificador
        nb.buildClassifier(lenses);
        //classificar exemplo desconhecido
        double diagnostico = nb.classifyInstance(desconhecido);
        //exibir classe econtrada
        System.out.println("Classe: " + diagnostico);
        desconhecido.setClassValue(desconhecido.stringValue(4) + "Rótulo:");
        
    }

}
