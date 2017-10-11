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
        Verificador v = new Verificador();
        Scanner in = new Scanner(System.in);
        String file, word;
        boolean valido = false;

        //file = in.nextLine();
        reader = new Reader("concat.txt");

        reader.ReadSates();
        reader.ReadAlphabet();
        reader.ReadTransition();
        reader.ReadInitialStates();
        reader.ReadFinalStates();

        word = in.nextLine();

        valido = v.valida(reader.getStates(), reader.getAlphabet(), reader.getInitialStates(), reader.getFinalStates(), reader.getTransitions(), word);

        if (valido) {
            System.out.println("Sim");
        } else {
            System.out.println("Não");
        }

    }

}
