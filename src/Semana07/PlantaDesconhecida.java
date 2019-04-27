package Semana07;

import Semana04.semana04_Patrick;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author Paulo
 */
public class PlantaDesconhecida {
    public static void main(String[] args) throws Exception {
        DataSource arff = new DataSource("data/iris.arff");
        Instances iris = arff.getDataSet();
        
        // Criar uma matriz com os dados obtidos do conjunto
        int qtExemplos = iris.numInstances();
        int qtAtributos = iris.numAttributes();
        double[][] matrizIris = new double[qtExemplos][qtAtributos];
        for (int i = 0; i < qtExemplos; i++) {
            matrizIris[i] = iris.instance(i).toDoubleArray();
        }
        
        // Vetor com as características de uma planta desconhecida
        double[] plantaDesconhecida = {5.1, 3.5, 1.4, 0.2, -1};
        
        double result = semana04_Patrick.obterNN(matrizIris, plantaDesconhecida);
        System.out.println(result);
    }
}
