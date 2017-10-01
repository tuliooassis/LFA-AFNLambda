package lfa.afnlamb;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.util.Scanner;
/**
 *
 * @author tulio
 */
public class LFAAFNLamb {
    

    public static boolean percorre (String[] vStates, String[] vAlphabet, HashMap<String, String> transitions, 
            String[] vInitialStates, String vFinalStates[], String word){
                Scanner in = new Scanner(System.in);

        ArrayList<String> vFinal = new ArrayList<String>();
        ArrayList<String> visited = new ArrayList<String>();
        Stack<String> control = new Stack<String>();
        
        //provisory
        for (int i = 0; i <vFinalStates.length; i++){
            vFinal.add(vFinalStates[i]);
        }
        
        
        for (int i = 0; i < vInitialStates.length; i++){
            if (!visited.contains(vInitialStates[i])){
                control.add(vInitialStates[i]);
                System.out.println("Control: add " + vInitialStates[i]);
                while (!control.isEmpty()){
                    String current = control.pop();
                    String next;
                    visited.add(current);
                    System.out.println("Visited: add " + current);
                    
                    // verify possibilits
                    if (!word.isEmpty()){
                        next = transitions.get(current + word.charAt(0));
                        if (next == null)
                             next = transitions.get(current + "#");

                        control.add(next);
                        System.out.println(next + " = " + current + " " + word.charAt(0));
                        System.out.println("next " + next);
                        
                        // if next transition don't is a lambda
                        if (word.charAt(0) != '#')
                            word = word.replaceFirst(String.valueOf(word.charAt(0)), "");
                    }
                                            
                    
                    System.out.println("word.isEmpty(): " + word.isEmpty() + word);

                    
                    // if word is empty and current states is final, then yes
                    if (word.isEmpty() && vFinal.contains(current))
                        return true;
                    
                           in.nextLine();

                }
            
            }
            
            
        }
        
        
        
        
        return false;
    }
    
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String word;
        
        // parsing file "JSONExample.json"
        Object obj;
        obj = new JSONParser().parse(new FileReader("concat.txt"));

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;
        // getting af
        JSONArray ja = (JSONArray) jo.get("af");

        // getting states
        String states = ja.get(0).toString();
        String vStates[] = states.split(",");
        for (int i = 0; i < vStates.length; i++) {
            vStates[i] = vStates[i].replace("\"", "").replace("[", "").replace("]", "");
            System.out.println(vStates[i]);
        }

        // getting alphabet
        String alphabet = ja.get(1).toString();
        String vAlphabet[] = alphabet.split(",");
        for (int i = 0; i < vAlphabet.length; i++) {
            vAlphabet[i] = vAlphabet[i].replace("\"", "").replace("[", "").replace("]", "");
            System.out.println(vAlphabet[i]);
        }

        // getting transations
        String transitions = ja.get(2).toString();
        //System.out.println(transations);
        String vTransitions[] = transitions.split("]");

        // map of transations
        HashMap<String, String> map = new HashMap<String, String>();

        // adding in map
        for (int i = 0; i < vTransitions.length; i++) {
            vTransitions[i] = vTransitions[i].replace("\"", "").replace("[", "").replace("]", "");
            if (vTransitions[i].charAt(0) == ',') {
                vTransitions[i] = vTransitions[i].replaceFirst(",", "");
            }

            String vTransition[] = vTransitions[i].split(",");
            map.put(vTransition[0] + vTransition[1], vTransition[2]);
            System.out.println(vTransition[0] + " " + vTransition[1] + " " + vTransition[2]);
            //System.out.println(map.get(vTransition[0] +  vTransition[1]));
            //System.out.println(vTransations[i]);
        }

        String initialStates = ja.get(3).toString();
        String vInitialStates[] = initialStates.split(",");
        for (int i = 0; i < vInitialStates.length; i++) {
            vInitialStates[i] = vInitialStates[i].replace("\"", "").replace("[", "").replace("]", "");
            System.out.println(vInitialStates[i]);
        }

        String finalStates = ja.get(4).toString();
        String vFinalStates[] = finalStates.split(",");
        for (int i = 0; i < vFinalStates.length; i++) {
            vFinalStates[i] = vFinalStates[i].replace("\"", "").replace("[", "").replace("]", "");
            System.out.println(vFinalStates[i]);
        }
        
        word = in.nextLine();
        if (percorre(vStates, vAlphabet, map, vInitialStates, vFinalStates, word))
            System.out.println("Sim");
        else
            System.out.println("Não");
                    
    }

}
