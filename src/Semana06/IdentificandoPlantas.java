package Semana06;

import weka.classifiers.lazy.IBk;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class IdentificandoPlantas {
    public static void main(String[] args) throws Exception {
        //LER ARQUIVO ARFF
        DataSource arff = new DataSource("iris.arff");
        //INSTANCIAR CONJUNTODE DADOS COM BASE N ARQUIVO 
        Instances iris = arff.getDataSet();
        //DEFINITIR ÍNDICE DO ATRIBUTO CLASSE
        iris.setClassIndex(4);
        //INSTANCIAR VIZINHO MAIS PROXIMO
        IBk vizinho = new IBk();
        //TRINAR CLASSIFICADOR
        vizinho.buildClassifier(iris);
        //MOSTRAR MODELO APRENDIDO
        System.out.println(vizinho);
        
    }
}
