/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfa.afnlamb;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 *
 * @author tulio
 */
public class Reader {

    private Object m_obj;
    private JSONObject m_jo;
    private JSONArray m_ja;
    private ArrayList<String> m_states, m_alphabet, m_initialStates, m_finalStates;
    private ArrayList<Aresta> m_transitions;

    public Reader(String p_file) throws Exception {
        this.m_obj = new JSONParser().parse(new FileReader(p_file));
        this.m_jo = (JSONObject) this.m_obj;
        this.m_ja = (JSONArray) this.m_jo.get("af");
        this.m_states = new ArrayList();
        this.m_alphabet = new ArrayList();
        this.m_initialStates = new ArrayList();
        this.m_finalStates = new ArrayList();
        this.m_transitions = new ArrayList();
    }

    public void ReadSates() {
        String v_state = this.m_ja.get(0).toString();
        String v_states[] = v_state.split(",");
        for (int i = 0; i < v_states.length; i++) {
            v_states[i] = v_states[i].replace("\"", "").replace("[", "").replace("]", "");
            this.m_states.add(v_states[i]);
            //System.out.println("Estados list: " + v_states[i]);
        }
    }

    public void ReadAlphabet() {
        String v_alphabet = this.m_ja.get(1).toString();
        String v_alphabets[] = v_alphabet.split(",");
        for (int i = 0; i < v_alphabets.length; i++) {
            v_alphabets[i] = v_alphabets[i].replace("\"", "").replace("[", "").replace("]", "");
            this.m_alphabet.add(v_alphabets[i]);
            //System.out.println("Alfabeto: " + v_alphabets[i]);
        }
    }

    public void ReadTransition() {
        String v_allTransition = this.m_ja.get(2).toString();
        String v_transitions[] = v_allTransition.split("]");
        Estado ini, fim;
        HashMap<Aresta, String> map = new HashMap<Aresta, String>();
        // adding in map
        for (int i = 0; i < v_transitions.length; i++) {
            v_transitions[i] = v_transitions[i].replace("\"", "").replace("[", "").replace("]", "");
            if (v_transitions[i].charAt(0) == ',') {
                v_transitions[i] = v_transitions[i].replaceFirst(",", "");
            }
            String transition[] = v_transitions[i].split(",");
            ini = new Estado(transition[0], "");
            fim = new Estado(transition[2], "");
            Aresta a = new Aresta(ini, transition[1], fim);
            //System.out.println("Transição: " + a.getAtual().getNome() + " " + a.getConsome() + " " + a.getProximo().getNome());
            this.m_transitions.add(a);
        }

    }

    public void ReadInitialStates() {
        String v_initialState = this.m_ja.get(3).toString();
        String v_initialStates[] = v_initialState.split(",");
        for (int i = 0; i < v_initialStates.length; i++) {
            v_initialStates[i] = v_initialStates[i].replace("\"", "").replace("[", "").replace("]", "");
            this.m_initialStates.add(v_initialStates[i]);
            //System.out.println("Estados iniciais:" + v_initialStates[i]);
        }
    }

    public void ReadFinalStates() {
        String v_finalState = this.m_ja.get(4).toString();
        String v_finalStates[] = v_finalState.split(",");
        for (int i = 0; i < v_finalStates.length; i++) {
            v_finalStates[i] = v_finalStates[i].replace("\"", "").replace("[", "").replace("]", "");
            this.m_finalStates.add(v_finalStates[i]);
            //System.out.println("Estados finais:" + v_finalStates[i]);
        }
    }

    public Object getObj() {
        return m_obj;
    }

    public void setObj(Object obj) {
        this.m_obj = obj;
    }

    public JSONObject getJo() {
        return m_jo;
    }

    public void setJo(JSONObject jo) {
        this.m_jo = jo;
    }

    public JSONArray getJa() {
        return m_ja;
    }

    public void setJa(JSONArray ja) {
        this.m_ja = ja;
    }

    public ArrayList<String> getStates() {
        return m_states;
    }

    public void setStates(ArrayList<String> states) {
        this.m_states = states;
    }

    public ArrayList<String> getAlphabet() {
        return m_alphabet;
    }

    public void setAlphabet(ArrayList<String> alphabet) {
        this.m_alphabet = alphabet;
    }

    public ArrayList<Aresta> getTransitions() {
        return m_transitions;
    }

    public void setTransitions(ArrayList<Aresta> transitions) {
        this.m_transitions = transitions;
    }

    public ArrayList<String> getInitialStates() {
        return m_initialStates;
    }

    public void setInitialStates(ArrayList<String> m_initialStates) {
        this.m_initialStates = m_initialStates;
    }

    public ArrayList<String> getFinalStates() {
        return m_finalStates;
    }

    public void setFinalStates(ArrayList<String> m_finalStates) {
        this.m_finalStates = m_finalStates;
    }

}
