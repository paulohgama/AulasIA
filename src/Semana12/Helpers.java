/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semana12;

import java.util.ArrayList;

/**
 *
 * @author kbrtec
 */
public class Helpers {
    
    /**
     * Calcula a distância euclidiana entre dois vetores de características.
     *
     * @param exemplo1 Vetor contendo as características do exemplo 1.
     * @param exemplo2 Vetor contendo as características do exemplo 2.
     * @return A distância euclidiana entre os dois vetores.
     * @throws Exception Se os vetores não tiver a mesma quantidade de
     * características.
     */
    public static double obtertEuclidiana(double[] exemplo1, double[] exemplo2) throws Exception {
        if (exemplo1.length != exemplo2.length) {
            throw new Exception("Os exemplos precisam ter a mesma quantidade de atributos.");
        }
        double distancia = -1;
        for (int i = 0; i < exemplo1.length - 1; i++) {
            distancia += Math.pow((exemplo1[i] - exemplo2[i]), 2);
        }
        return Math.sqrt(distancia);
    }
    
    public static double[] ordenar(double[] conjunto, double[] distancia)
    {
        double aux;
        for (int i = 0; i < distancia.length; i++) {
            for (int j = i; j < distancia.length; j++) {
                if(distancia[j] < distancia[i])
                {
                    aux = conjunto[j];
                    conjunto[j] = conjunto[i];
                    conjunto[i] = aux;
                    aux = distancia[j];
                    distancia[j] = distancia[i];
                    distancia[i] = aux;
                }
            }
        }
        return conjunto;
    }
    
    public static double[] ordenar(double[] conjunto)
    {
        double aux;
        for (int i = 0; i < conjunto.length; i++) {
            for (int j = i; j < conjunto.length; j++) {
                if(conjunto[j] < conjunto[i])
                {
                    aux = conjunto[j];
                    conjunto[j] = conjunto[i];
                    conjunto[i] = aux;
                }
            }
        }
        return conjunto;
    }
    public static double[] filtrar(double[] conjunto, int k)
    {
        double[] novo = new double[k];
        for(int i = 0; i < novo.length; i++)
        {
            novo[i] = conjunto[i];
        }
        return novo;
    }
    
    public static double obterMaiorOcorrencia(double[] conjunto, double[] distancia, int k)
    {
        conjunto = ordenar(conjunto, distancia);
        conjunto = filtrar(conjunto, k);
        conjunto = ordenar(conjunto);
        ArrayList<Integer> pontua = new ArrayList();        
        ArrayList<Double> classe = new ArrayList();
        double classeCerta = -1;       
        int pontCerta = -1;
        int cont = 0;
        for(int i = 0; i < conjunto.length; i++)
        {
            if(i == 0)
            {
                pontua.add(1);
                classe.add(conjunto[i]);
            }
            else
            {
                if(conjunto[i] == conjunto[i-1])
                {
                    pontua.set(cont, pontua.get(cont)+1);
                }
                else
                {
                    pontua.add(1);
                    cont++;
                    classe.add(conjunto[i]);
                }   
            }
        }
        for(int i = 0; i < pontua.size(); i++)
        {
            if(classeCerta == -1 || pontua.get(i) > pontCerta)
            {
                pontCerta = pontua.get(i);
                classeCerta = classe.get(i);
            }
        }
        return classeCerta;
    }
}
