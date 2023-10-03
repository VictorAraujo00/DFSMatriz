package com.atividade;

import java.util.LinkedList;

public class Solucao {


    private static final int BRANCO = -1;
    private static final int CINZA = 0;
    private static final int PRETO = 1;
    
    public int[] ante;
    public int[] i;
    public int[] f;
    public int[] cor;
    public int tempo;
    private boolean [][] grafo;

    public Solucao(boolean [][] grafo){

        this.grafo = grafo;

    }

    public void dfs_start(int s){

        this.ante = new int[grafo.length];
        this.i = new int[grafo.length];
        this.f = new int[grafo.length];
        this.cor = new int[grafo.length];

        for(int j = 0; j < grafo.length; j++){

            cor[j] = BRANCO;
            i[j] = -2;
            f[j] = -2;
            ante[j] = -2;
        }

        tempo = -1;
        dfs_visit(s);


    }

    public void dfs_visit(int u){

        tempo++;
        i[u] = tempo;
        cor[u] = CINZA;

        LinkedList<Integer> adj = new LinkedList<Integer>();

        for(int i = 0; i < grafo.length; i++){

            if(grafo[u][i] == true){
                adj.add(i);
            }

        }

        for(int v : adj){

            if(cor[v] == BRANCO){
                ante[v] = u;
                dfs_visit(v);
            }

        }

        tempo++;
        f[u] = tempo;
        cor[u] = PRETO;



    }

}
