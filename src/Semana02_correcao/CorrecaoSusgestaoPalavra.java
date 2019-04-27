package Semana02_correcao;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Semana02.SugestaoPalavra;

/**
 *
 * @author PAULO
 */
public class CorrecaoSusgestaoPalavra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        String palavraDigitada = "Palmeiras";
        CorrecaoSusgestaoPalavra sp = new CorrecaoSusgestaoPalavra();
        String palavra1 = "Palmeiras";
        String palavra2 = "Corinthians";
        
        double palavrasPontos = sp.lerPalavra(palavra1, palavraDigitada); 
        System.out.println(palavrasPontos);
        palavrasPontos = sp.lerPalavra(palavra2, palavraDigitada);         
        System.out.println(palavrasPontos);
    }
    
    public double lerPalavra(String palavra, String palavraDigitada)
    {
        if(palavra.equals(palavraDigitada))
            return 0;
        double max = regra1(palavra, palavra) + regra2(palavra, palavra) + regra3(palavra, palavra);
        double pontos = (regra1(palavra, palavraDigitada) + regra2(palavra, palavraDigitada) + regra3(palavra, palavraDigitada)) / max;
        return 1 - pontos;
    }
    
    public int regra1(String palavra, String palavraDigitada)
    {
        int pontos = 0;
        for(int i = 0; i < palavra.length(); i++)
        {
            char l1 = palavra.charAt(i);
            for(int j = 0; j < palavraDigitada.length(); j++)
            {
                char l2 = palavraDigitada.charAt(j);
                pontos += l1 == l2 ? 1 : 0;
            }
        }
        return pontos;
    }
    
    public int regra2(String palavra, String palavraDigitada)
    {
        int pontos = 0;
        String[] letras = palavra.split("");
        int qtdL1 = 0;
        int qtdL2 = 0;
        for(int i = 0; i < palavraDigitada.length(); i++)
        {
            char letra = palavraDigitada.charAt(i);
            qtdL1 = contaLetras(palavra, letra);
            qtdL2 = contaLetras(palavra, letra);
            pontos += qtdL1 == qtdL2 ? 2 : 0;
        }
        return pontos;
    }
    
    public int contaLetras(String palavra, char letra)
    {
        int qnts = 0;
        for(int j = 0; j < palavra.length(); j++)
        {
            char letraP = palavra.charAt(j);
            qnts += letraP == letra ? 1 : 0;
        }
        return qnts;
    }
    
    public int regra3(String palavra, String palavraDigitada)
    {
        int pontos = 0;
        for(int i = 0; i < palavraDigitada.length(); i++)
        {
            char l2 = palavraDigitada.charAt(i);
            if(i >= palavra.length()) break;
            char l1 = palavra.charAt(i);
            pontos += l1 == l2 ? 3 : 0;
        }
        return pontos;
    }
}
