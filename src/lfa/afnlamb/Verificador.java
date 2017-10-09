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
    
        ArrayList<Aresta> m_visited;
        Stack<Aresta> m_control;

        public Verificador (){
            this.m_visited = new ArrayList();
            this.m_control = new Stack();
        }
        
        public boolean valida (ArrayList<String> p_states, ArrayList<String> p_alphabet, ArrayList<String> p_initialStates,
                    ArrayList<String> p_finalStates, ArrayList<Aresta> p_transitions){
            Scanner in = new Scanner(System.in);

            
            for (int i = 0; i < p_transitions.size(); i++){
                if (p_initialStates.contains(p_transitions.get(i).getAtual())){
                    if (m_visited.contains(p_transitions.get(i)))
                        continue;
                    else {
                        this.m_control.add(p_transitions.get(i));
                        
                        while (this.m_control.size() != 0){
                            Aresta arestaAtual = this.m_control.pop();
                            this.m_visited.add(arestaAtual);
                            
                        }
                    }
                        
                }
                
            }
            
            return false;
        }

}
