package tp3;

import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Cette classe compare une phrase générée avec une phrase cible.
 * @author Jan Eunice Villapaz
 * Code permanent: VILJ30579403
 * date: 26 Avril 2020
 * version: 1.0.0
 */
public class Texte {

    protected int c1, c2, c3, c4;
    protected double r1, r2, r3, r4,
                  q1, q2, q3, q4,
                  F1, F2, F3, F4;
    protected ArrayList <String[]> p1g1, p1g2, p1g3, p1g4,
    p2g1, p2g2, p2g3, p2g4;

    /**
     * Un constructeur qui prend en entrees deux phrases et les transformes en 1,2,3,4-gramme
     * Il calcule ensuite les valeurs respectives à leur intersection, rappel, precision et fmesure.
     *
     * @param phrase - Première phrase d'entrée
     * @param phrase2 - Deuxième phrase d'entrée
     */
    public Texte(String phrase, String phrase2) {
        Gramme generate = new Gramme();

        p1g1 = generate.uGrammes(phrase);
        p1g2 = generate.dGrammes(p1g1);
        p1g3 = generate.tGrammes(p1g1);
        p1g4 = generate.qGrammes(p1g1);

        p2g1 = generate.uGrammes(phrase2);
        p2g2 = generate.dGrammes(p2g1);
        p2g3 = generate.tGrammes(p2g1);
        p2g4 = generate.qGrammes(p2g1);

        c1 = cardinalite(p1g1, p2g1);
        c2 = cardinalite(p1g2, p2g2);
        c3 = cardinalite(p1g3, p2g3);
        c4 = cardinalite(p1g4, p2g4);

        r1 = rappel(c1, p2g1);
        r2 = rappel(c2, p2g2);
        r3 = rappel(c3, p2g3);
        r4 = rappel(c4, p2g4);

        q1 = precision(c1, p1g1);
        q2 = precision(c2, p1g2);
        q3 = precision(c3, p1g3);
        q4 = precision(c4, p1g4);

        F1 = fMesure(r1, q1);
        F2 = fMesure(r2, q2);
        F3 = fMesure(r3, q3);
        F4 = fMesure(r4, q4);

        System.out.print("1-grammes de la phrase 1 = ");
        print(p1g1);
        System.out.print("2-grammes de la phrase 1 = ");
        print(p1g2);
        System.out.print("3-grammes de la phrase 1 = ");
        print(p1g3);
        System.out.print("4-grammes de la phrase 1 = ");
        print(p1g4);

        System.out.print("1-grammes de la phrase 2 = ");
        print(p2g1);
        System.out.print("2-grammes de la phrase 2 = ");
        print(p2g2);
        System.out.print("3-grammes de la phrase 2 = ");
        print(p2g3);
        System.out.print("4-grammes de la phrase 2 = ");
        print(p2g4);

        System.out.println("c1 = " + c1 + ", c2 = " + c2 + ", c3 = " + c3 + ", c4 = " + c4 + ".");
        System.out.println("r1 = " + r1 + ", r2 = " + r2 + ", r3 = " + r3 + ", r4 = " + r4 + ".");
        System.out.println("q1 = " + q1 + ", q2 = " + q2 + ", q3 = " + q3 + ", q4 = " + q4 + ".");
        System.out.println("F1 = " + F1 + ", c2 = " + F2 + ", F3 = " + F3 + ", F4 = " + F4 + ".");

    }

    /**
     * Cette methode calcule la valeur de F-Mesure a partir de la valeur de rappel (r) et de precision (q)
     * @param rappel - le pourcentage de n grammes de la deuxième phrase(cible) qui ont été retrouvés dans la
     * première phrase (générée).
     * @param precision - le pourcentage de n grammes de la première phrase(généré) qui ont été retrouvés dans
     * la deuxième phrase (cible).
     * @return FMesure - une combinaison du rappel et de la précision
     */
    public double fMesure(double rappel, double precision) {
        return ( rappel == 0.0 ? 0.0 : (2 * ((rappel*precision)/(rappel + precision))) );
    }

    /**
     * Cette methode calcule la valeur de precision d'une phrase en format List
     * @param cardinal - la cardinalité (taille, nombre d’éléments) de l'ensemble
     * @param gramme - nGramme
     * @return precision
     */
    public double precision(double cardinal, ArrayList<String[]> gramme) {
        return (cardinal == 0.0 ? 0.0 : cardinal / Math.abs(gramme.size()));
    }

    /**
     * Cette methode calcule la valeur de rappel d'une phrase n-gramme en format List
     * @param cardinal - la cardinalité (taille, nombre d’éléments) de l'ensemble
     * @param gramme - nGramme
     * @return rappel
     */
    public double rappel(double cardinal, ArrayList<String[]> gramme) {
        return ( cardinal == 0 ? 0.0 : cardinal / Math.abs(gramme.size()));
    }

    /**
     * Cette methode calcule la valeur de rappel d'une phrase n-gramme en format List
     * @param a - n-Gramme de la phrase entree
     * @param b - n-Gramme de la phrase cible
     * @return cardinalite
     */
    public int cardinalite(ArrayList<String[]> a, ArrayList<String[]> b) {
        ArrayList<String[]> lower1 = lowerCase(a);
        ArrayList<String[]> lower2 = lowerCase(b);
        ArrayList<List<String>> list1 = transformList(lower1);
        ArrayList<List<String>> list2 = transformList(lower2);

        list1.retainAll(list2);

        return Math.abs(Math.min(list2.size(), list1.size()));
    }

    /**
     * Cette methode transforme les elements dans un Arraylist en lettre minuscule
     * @param gramme - nGramme
     * @return gramme
     */
    public ArrayList<String[]> lowerCase(ArrayList<String []> gramme) {

        for (String[] strings : gramme) {
            for (int j = 0; j < strings.length; j++) {
                strings[j] = strings[j].toLowerCase();
            }
        }
        return gramme;
    }

    /**
     * Cette méthode convertit le datatype d'un arraylist de String[]
     * en List <String>
     * @param gramme - nGramme
     * @return convert
     */
    public ArrayList <List<String>> transformList(ArrayList<String[]> gramme) {
        ArrayList <List<String>> convert = new ArrayList<>();

        for (String[] strings : gramme) {
            convert.add(Arrays.asList(strings));
        }

        return convert;
    }


    /**
     * Cette methode imprime le nGramme
     * @param gramme - nGramme
     */
    public void print(ArrayList <String[]> gramme) {
        for (String[] strings : gramme) {
            System.out.print(Arrays.toString(strings));
        }
        System.out.println();
    }

}
