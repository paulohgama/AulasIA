package Semana14;

import java.util.Random;
import weka.classifiers.lazy.IBk;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author PauloHGama
 */
public class AvaliaçãoDeClassificadores {

    public static void main(String[] args) throws Exception {
        DataSource arff = new DataSource("data/diabetes.arff");
        
        Instances diabetes = arff.getDataSet();
        
        diabetes.setClassIndex(8);
        
        int k = diabetes.numInstances(); // Quantidade de partições
        System.out.println("real;vizinho;knn3;knn7");
        for (int i = 0; i < k; i++) {
            Instances diabetesTreino = diabetes.trainCV(k, i); // Treina
            Instances diabetesTeste = diabetes.testCV(k, i); // Testa
            
            //Instanciando classificadores
            IBk vizinho = new IBk(); // Vizinho mais proximo
            IBk knn3 = new IBk(3); // 3 Vizinhos
            IBk knn7 = new IBk(7); // 7 Vizinhos
            
            //Treinando os classificadores
            vizinho.buildClassifier(diabetesTreino);
            knn3.buildClassifier(diabetesTreino);
            knn7.buildClassifier(diabetesTreino);
            
            for (int j = 0; j < diabetesTeste.numInstances(); j++) {
                Instance teste = diabetesTeste.instance(j);
                System.out.print(teste.value(8));
                teste.setClassMissing();
                double cVizinho = vizinho.classifyInstance(teste);
                double cKnn3 = knn3.classifyInstance(teste);
                double cKnn7 = knn7.classifyInstance(teste);
                System.out.println(";" + cVizinho + ";" + cKnn3 + ";" + cKnn7);
            }
        }
    }
    
}
