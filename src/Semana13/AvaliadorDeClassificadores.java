package Semana13;

import java.util.Random;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Paulo
 */
public class AvaliadorDeClassificadores {

    public static void main(String[] args) throws Exception {
        //Pega a base
        DataSource arff = new DataSource("data/iris.arff");
        //Instancia e reordena
        Instances iris = arff.getDataSet();
        //Define indice da classe
        iris.setClassIndex(4);
        int k = 3; // Quantidade de partições
        int i = 0; // Quantidade de interações
        Instances irisTreino = iris.trainCV(k, i); // Treina
        Instances irisTeste = iris.testCV(k, i); // Testa
        
        System.out.println(irisTreino);
        System.out.println(irisTeste);
    }
    
}
