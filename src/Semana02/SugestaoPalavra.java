/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semana02;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class SugestaoPalavra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String palavraDigitada = JOptionPane.showInputDialog("Digite uma palavra");
        SugestaoPalavra sp = new SugestaoPalavra();
        String[] palavras = {};
        double[] palavrasPontos = new double[palavras.length];
        for (int i = 0; i < palavras.length; i++) {
            palavrasPontos[i] = sp.lerPalavra(palavras[i], palavraDigitada) / 100; 
        }
    }
    
    public int lerPalavra(String palavra, String palavraDigitada)
    {
        if(palavra.equals(palavraDigitada))
            return 100;
        int pontos = 0;
        pontos += regra1(palavra, palavraDigitada);
        pontos += regra2(palavra, palavraDigitada);
        pontos += regra3(palavra, palavraDigitada);
        return pontos;
    }
    
    public int regra1(String palavra, String palavraDigitada)
    {
        int pontos = 0;
        for(int i = 0; i < palavraDigitada.length(); i++)
        {
            for(int j = 0; j < palavra.length(); j++)
            {
                if(palavraDigitada.charAt(i) == palavra.charAt(j))
                {
                    pontos++;
                }
            }
        }
        return pontos;
    }
    
    public int regra2(String palavra, String palavraDigitada)
    {
        int pontos = 0;
        String[] letras = palavra.split("");
        List<Integer> letrasP = new ArrayList();
        Integer[] pontosLetras = new Integer[letras.length];
        for(int i = 0; i < letras.length; i++)
        {
            for(int j = 0; j < letras.length; j++)
            {
                if(letras[i] == letras[j])
                        pontosLetras[i]++;
            }
            letrasP.add(pontosLetras[i]);
        }
        String[] letrasDigitadas = palavraDigitada.split("");
        List<Integer> letrasPDigitadas = new ArrayList();
        Integer[] pontosLetrasDigitas = new Integer[letras.length];
        for(int i = 0; i < letrasDigitadas.length; i++)
        {
            for(int j = 0; j < letrasDigitadas.length; j++)
            {
                if(letrasDigitadas[i] == letrasDigitadas[j])
                        pontosLetrasDigitas[i]++;
            }
            letrasPDigitadas.add(pontosLetrasDigitas[i]);
        }
        for(int i = 0; i < letrasP.size(); i++)
        {
            if(letrasP.get(i) == letrasPDigitadas.get(i))
            {
                pontos++;
                pontos++;
            }
        }
        return pontos;
    }
    
    public int regra3(String palavra, String palavraDigitada)
    {
        int pontos = 0;
        for(int i = 0; i < palavraDigitada.length(); i++)
        {
            if(palavraDigitada.charAt(i) == palavra.charAt(i))
            {
                pontos++;                
                pontos++;
                pontos++;
            }
        }
        return pontos;
    }
    
}
