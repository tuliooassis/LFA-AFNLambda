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

        public Verificador (){
            this.m_visited = new ArrayList();
            this.m_control = new Stack();
        }
        
        public void printVisited (){
            System.out.println("Imprimindo visitados: ");
            for (int i = 0; i < this.m_visited.size(); i++){
                System.out.println(this.m_visited.get(i).getNome() + " " + this.m_visited.get(i).getWord());
            }
            System.out.println();
        }
        
        public void printControl (){
            System.out.println("Imprimindo pilha de controle: ");
            for (int i = 0; i < this.m_control.size(); i++){
                System.out.println(this.m_control.get(i).getNome() + " " + this.m_control.get(i).getWord());
            }
            System.out.println();
        }
        
        
        public boolean valida (ArrayList<String> p_states, ArrayList<String> p_alphabet, ArrayList<String> p_initialStates,
                    ArrayList<String> p_finalStates, ArrayList<Aresta> p_transitions, String word){
            Scanner in = new Scanner(System.in);
            Estado atual;
            
            for (String s : p_initialStates){
                atual = new Estado (s, word);
                if (!this.m_visited.contains(s))
                    this.m_control.add(atual);
            }
            
            
            while (!this.m_control.empty()){
                 this.printControl();
                 
                 atual = this.m_control.pop();
                 
                 for (Aresta a : p_transitions){
                     if (a.getAtual().getNome() == atual.getNome() || atual.getNome() == "#"){
                         if (a.getConsome() != "#")
                            atual.setWord(atual.getWord().substring(1));
                     
                         if (!this.m_visited.contains(atual)){
                             this.m_control.add(atual);
                         }
                     }
                 }
                 
                 
            }
            
            
            return false;
        }

}
