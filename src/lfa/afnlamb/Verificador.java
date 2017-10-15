/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfa.afnlamb;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author tulio
 */
public class Verificador {

    ArrayList<Estado> m_visited;
    Stack<Estado> m_control;

    public Verificador() {
        this.m_visited = new ArrayList();
        this.m_control = new Stack();
    }

    public void printVisited() {
        System.out.println("Imprimindo visitados: ");
        for (int i = 0; i < this.m_visited.size(); i++) {
            System.out.println(this.m_visited.get(i).getNome() + " " + this.m_visited.get(i).getWord());
        }
        System.out.println();
    }

    public void printControl() {
        System.out.println("Imprimindo pilha de controle: ");
        for (int i = 0; i < this.m_control.size(); i++) {
            System.out.println(this.m_control.get(i).getNome() + " " + this.m_control.get(i).getWord());
        }
        System.out.println();
    }

        
    public boolean valida (ArrayList<String> p_states, ArrayList<String> p_alphabet, ArrayList<String> p_initialStates,
                    ArrayList<String> p_finalStates, ArrayList<Aresta> p_transitions, String word){
        Scanner in = new Scanner(System.in);
        Estado atual;
       //Adiciona na pilha de controle todos os estados iniciais
        for (String s : p_initialStates) {
            atual = new Estado(s, word);
            if (!this.m_visited.contains(s)) {
                this.m_control.add(atual);
            }
        }

        while (!this.m_control.empty()) { //Enquanto a pilha de controle nao for consumida permanece
            
            atual = this.m_control.pop();
            
            this.m_visited.add(atual);
            
            
            for (Aresta a : p_transitions) {
                if(word.equals("#"))
                        if (p_finalStates.contains(a.getProximo().getNome()) || p_finalStates.contains(a.getAtual().getNome()))
                            return true;
                        else
                            return false;
                       
                
                 
                
                if (atual.getWord().isEmpty() && p_finalStates.contains(atual.getNome()))
                    return true;
                else if (atual.getWord().isEmpty())
                    break; 
                
                if (a.getConsome().isEmpty())
                    continue;
                
                if (a.getAtual().getNome().equals(atual.getNome())) {
                    if (a.getConsome().equals(atual.getWord().charAt(0) + "")||a.getConsome().equals("#")) {
                        
                        Estado prox = new Estado (a.getProximo().getNome(), atual.getWord());

                        if (!a.getConsome().equals("#")){
                            if (atual.getWord().length() == 1)
                                prox.setWord("");
                            else if (atual.getWord().length() > 1)
                                prox.setWord(atual.getWord().substring(1));
                        }
                        
                        if (!this.m_visited.contains(prox)){
                            this.m_control.add(prox);
                        }
                    }
                }
            }

        }

        return false;
    }

}
