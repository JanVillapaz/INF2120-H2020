package tp3;

import java.util.ArrayList;
import java.util.Arrays;

public class Gramme {

    /**
     * Cette methode prend en entrees une phrase et le transforme en 1-gramme
     *
     * @param phrase - La phrase d'entrée
     * @return gramme
     */
    public ArrayList<String[]> uGrammes(String phrase) {
        String[] words = phrase.split("[^A-Za-z]+");
        ArrayList<String[]> gramme = new ArrayList<>();

        for (String word : words) {
            gramme.add(new String[]{word});
        }

        return gramme;
    }

    /**
     * Cette methode prend en entrees une phrase et le transforme en 2-gramme
     *
     * @param uGramme - Le 1-gramme
     * @return gramme
     */
    public ArrayList<String[]> dGrammes(ArrayList<String[]> uGramme) {
        ArrayList<String[]> gramme = new ArrayList<>();

        for (int i = 0; i < uGramme.size() - 1; i++) {
            gramme.add(new String[] {Arrays.toString(uGramme.get(i)),
                    Arrays.toString(uGramme.get(i + 1))}
            );
        }
        return gramme;
    }

    /**
     * Cette methode prend en entrees une phrase et le transforme en 3-gramme
     *
     * @param dGramme - le 2-gramme
     * @return tGramme
     */
    public ArrayList<String[]> tGrammes(ArrayList<String[]> dGramme) {
        ArrayList<String[]> tGramme = new ArrayList<>();

        for (int i = 0; i < dGramme.size() - 2; i++) {
            tGramme.add(new String[] {Arrays.toString(dGramme.get(i)),
                    Arrays.toString(dGramme.get(i + 1)),
                    Arrays.toString(dGramme.get(i + 2))}
            );
        }

        return tGramme;
    }

    /**
     * Cette methode prend en entrees une phrase et le transforme en 4-gramme
     *
     * @param tGramme - le 3-gramme
     * @return gramme
     */
    public ArrayList<String[]> qGrammes(ArrayList<String[]> tGramme) {
        ArrayList<String[]> gramme = new ArrayList<>();

        for (int i = 0; i < tGramme.size() - 3; i++) {
            gramme.add(new String[] {
                    Arrays.toString(tGramme.get(i)),
                    Arrays.toString(tGramme.get(i + 1)),
                    Arrays.toString(tGramme.get(i + 2)),
                    Arrays.toString(tGramme.get(i + 3))} );
        }
        return gramme;
    }

}
