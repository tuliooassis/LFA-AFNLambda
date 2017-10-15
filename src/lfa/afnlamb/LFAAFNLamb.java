package lfa.afnlamb;

import java.util.Scanner;

/**
 *
 * @author tulio
 */
public class LFAAFNLamb {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        Reader reader;
        Verificador v;
        Scanner in = new Scanner(System.in);
        String word;
        boolean valido = false;
        
        reader = new Reader(args[0]);

        reader.ReadSates();
        reader.ReadAlphabet();
        reader.ReadTransition();
        reader.ReadInitialStates();
        reader.ReadFinalStates();
        
        word = in.nextLine();
        
        while (!word.isEmpty()){
            v = new Verificador();
            
            valido = v.valida(reader.getStates(), reader.getAlphabet(), reader.getInitialStates(), reader.getFinalStates(), reader.getTransitions(), word);

            if (valido) {
                System.out.println("Sim");
            } else {
                System.out.println("Não");
            }
            
            word = in.nextLine();
        }

    }

}
