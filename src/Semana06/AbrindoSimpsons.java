package Semana06;

import java.util.Arrays;
import static Semana04.semana04_Patrick.nn;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
/**
 *
 * @author Paulo
 */
public class AbrindoSimpsons {
    public static void main(String[] args) throws Exception
    {
        DataSource arff = new DataSource("data/simpsons.arff");
        Instances simpsons = arff.getDataSet();
        simpsons.setClassIndex(3);
        Instance selma = simpsons.instance(6);
        System.out.println(selma);
        System.out.println("Peso: " + selma.value(1));
        
        Instance comic = new DenseInstance(4);
        comic.setDataset(simpsons);
        comic.setValue(0, 8);
        comic.setValue(1, 290);
        comic.setValue(2, 38);
        comic.setClassMissing();
        System.out.println(comic);
        
        double[] vComic = comic.toDoubleArray();
        System.out.println(Arrays.toString(vComic));
        
        double menor = 0;
        double d = 0;
        int escolha = 0;
        for(int i = 0; i < simpsons.numInstances(); i++)
        {
            d = nn(simpsons.instance(i).toDoubleArray(), vComic);
            if(menor > d || i == 0)
            {
                menor = d;
                escolha = i;
            }
        }
        comic.setClassValue(simpsons.instance(escolha).value(3));
        System.out.println(comic);
        System.out.println("Comic é mais parecido com " + simpsons.instance(escolha).stringValue(4) + " portanto pertence ao grupo de " + simpsons.instance(escolha).stringValue(3));
    }
}
