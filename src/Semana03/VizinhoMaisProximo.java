package Semana03;

import javax.swing.JOptionPane;
import Semana02_correcao.CorrecaoSusgestaoPalavra;

/**
 *
 * @author aluno
 */
public class VizinhoMaisProximo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] palavras = new String[5];
        Double[] palavrasInt = new Double[5];
        String palavra = "";
        for(int i = 0; i < palavras.length; i++)
        {
            palavras[i] = JOptionPane.showInputDialog("Digite um palavra");
            if(i == palavras.length-1)
            {
                palavra = JOptionPane.showInputDialog("Digite uma palavra pra comparação");
            }
        }
        
        CorrecaoSusgestaoPalavra cs = new CorrecaoSusgestaoPalavra();
        for(int i = 0; i < palavras.length; i++)
        {
            palavrasInt[i] = cs.lerPalavra(palavras[i], palavra);
        }
        double aux = 0;
        String auxx = "";
        for(int i = 0; i < palavrasInt.length; i++)
        {
            for(int j = 0; j < palavrasInt.length; j++)
            {
                if(palavrasInt[i] > palavrasInt[j])
                {
                    auxx = palavras[j];
                    aux = palavrasInt[j];
                    palavras[j] = palavras[i];
                    palavrasInt[j] = palavrasInt[i];
                    palavras[i] = auxx;
                    palavrasInt[i] = aux;
                }
            }
        }
        System.out.println("Você quis dizer " + palavras[palavras.length-1]);
    }
    
}
