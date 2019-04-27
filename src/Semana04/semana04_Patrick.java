/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semana04;

import javax.swing.JOptionPane;

/**
 *
 * @author Patrick
 */
public class semana04_Patrick 
{
    public static void main(String[] args) 
    {
        double[][] simpsons = {
               {0, 250, 36, 1,},
               {10, 150, 34, 0},
               {2, 90, 10, 1},          
               {6, 78, 8, 0},          
               {4, 20, 1, 0},          
               {1, 170, 70, 1},          
               {8, 160, 41, 0},          
               {10, 180, 38, 1},          
               {6, 200, 45, 1}          
        }; 
        String[] simpsonsNome = {
            "Homer",
            "Marge",
            "Bart",
            "Lisa",
            "Maggie",
            "Abe",
            "Selma",
            "Otto",
            "Krusty"
        };
        double[] comic = {
          8,
          290,
          38,
          -1
        };
        double menor = 0;
        double d = 0;
        int escolha = 0;
        for(int i = 0; i < simpsons.length; i++)
        {
            d = nn(simpsons[i], comic);
            if(menor > d || i == 0)
            {
                menor = d;
                escolha = i;
            }
        }
        System.out.println("Comic é mais parecido com " + simpsonsNome[escolha] + " portanto pertence ao grupo de " + (simpsons[escolha][3] == 0 ? "Mulheres" : "Homens"));
    }
    
    public static double obterEuclidiana(double c1, double c2) 
    {
        double distancia = 0;
        distancia = Math.sqrt(Math.pow(c1 - c2, 2));
        return distancia;
    }
    
    public static double nn(double[] c1, double[] c2) 
    {
        double distancia = 0;
        for(int i = 0; i < c1.length-1; i++)
        {
            distancia += Math.pow(c1[i] - c2[i], 2);
        }
        distancia = Math.sqrt(distancia);
        return distancia;
    }
    
    public static double obterNN(double[][] matriz, double[] desconhecido)
    {
        double menor = 0;
        double d = 0;
        int escolha = 0;
        for(int i = 0; i < matriz.length; i++)
        {
            d = nn(matriz[i], desconhecido);
            if(menor > d || i == 0)
            {
                menor = d;
                escolha = i;
            }
        }
        int classe = matriz[0].length - 1;
        return matriz[escolha][classe];
    }
    
}
