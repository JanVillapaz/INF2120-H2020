import java.util.ArrayList;

/*
 * Ce class permet de faire les calcul de metrique
 */
public class Metrique {

    /*
     * Créer et remplir un tableau du deviation minimales en parcourant
     * les deux séquences
     *
     * @param s
     * @param t
     *      un arraylist contenant les acides aminés
     *
     * @return tabDev
     *
     */
    public static int [] tabDev(ArrayList<AcideAmine> s, ArrayList<AcideAmine> t) {
        int dev = 1000;
        int [] tabDev = new int [s.size()];
        int k = 0;

        for (int i = 0; i < s.size(); i++) {
            int min = 100;

            for ( int j=0 ; j <t.size(); j++ ) {

                if ( s.get(i).equals( t.get(j) ) ) {
                    dev = Math.abs( j - i );

                    if ( dev < min ) {
                        min = dev;
                    }

                }

                tabDev [ k ] = min;

            }

            k ++;
        }

        return tabDev;

    }

    /*
     * Permet de combiner la sequence ARN s et ARN t
     *
     * @param devS
     * @param devT
     *
     * @return devMin
     */
    public static int [] dMin(int[] devS, int[] devT) {
        int [] devMin = new int [devS.length + devT.length];

        System.arraycopy(devS, 0, devMin, 0, devS.length);
        System.arraycopy(devT, 0, devMin, devS.length, devT.length);

        return devMin;
    }

    /*
     * Permet de calculer la somme total des deviation minimal avec d
     *
     * @param tabDev
     *      un tableau int minimal avec d
     * @param d
     *      La distance maximale
     */
    public static double additionneDev(int [] tabDev, int d) {
        double somme = 0;
        for (int value : tabDev) {

            somme += Math.min(value, d);

        }
        return somme;
    }

    /*
     * Permet de calculer la petite formule qui transforme
     * la déviation en une métrique qui indique la similarité
     * entre les deux ARNs.
     *
     * @param somme
     *      La somme des deviations
     *
     */
    public static void petitCalcul(double somme) {
        System.out.println(( Math.exp((-6) * (Math.pow(somme, 2)))) );
    }

    /*
     * Creer un tableau de deviation minimal pour chaque acide de s et t
     *
     * @param tabDev
     * @param a
     * @param s
     *
     * @return tableau de deviation minimal pour chauqe acide de s et t
     */
    public static int[] creeDevMinimal (int[] tabDev, String a, String b) {
        return dMin(tabDev(ARN.creeSequence(a), ARN.creeSequence(b)),
                tabDev(ARN.creeSequence(b), ARN.creeSequence(a)));

    }

    /*
     * Permet de calculer la metrique
     *
     * @param Met
     *      La somme des deviations
     * @param m
     * @param n
     *      le nombre d'acide aminé de la chaîne s et t
     * @param d
     *      la distance maximal
     *
     * @return double
     *      La metrique
     */
    public static double calculeMet(double Met, int m, int n, int d) {
        return (Met / ( (m + n)*d) );

    }


    public static boolean chiffreValide(int m) {
        boolean valide = false;

        if (m <= 0) {

        } else {
            valide = true;
        }

        return valide;
    }



}
