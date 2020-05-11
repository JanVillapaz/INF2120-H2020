import java.util.ArrayList;

public class ARN {



    /*
     * Permet valider si l'entrée correspond à certains critères
     *
     * @param input
     *      un String Une chaîne représentant un ARN
     *
     * @return valide
     *      un boolean qui confirme la validité de la chaîne
     */
    public static boolean estValide(String input) {
        boolean valide = false;

        if((input.length() % 3) != 0) {

        } else {
            //validates if A,G,C,U
            for (int i= 0; i < input.length(); i ++) {

                valide = (input.charAt(i) == 'A') || (input.charAt(i) == 'G')
                        || (input.charAt(i) == 'U' || (input.charAt(i) == 'C'));

            }

        }
        return valide;
    }


    /*
     * Permet de diviser le String en codon
     *
     * @param input
     *      un String Une chaîne représentant un ARN
     *
     * @return arn
     *      un arraylist contenant les codons
     */
    static ArrayList<String> splitString(String input) {
        ArrayList<String> arn = new ArrayList<>();

        for (int i = 0; i < input.length(); i += 3) {

            arn.add(input.substring(i, Math.min(input.length(), i + 3)));

        }

        return arn;
    }

    /*
     * Permet de convertir les nucléotides en acide aminé
     *
     * @param arn
     *      un arraylist contenant les codons
     *
     * @return temp
     *      un arraylist contenant les acides aminés
     */
    static ArrayList<AcideAmine> amino(ArrayList<String> arn) {
        ArrayList<AcideAmine> temp = new ArrayList<>();

        for (String s : arn) {

            switch (s) {
                case "GCU":
                case "GCC":
                case "GCA":
                case "GCG":

                    temp.add(AcideAmine.Ala);

                    break;
                case "CGU":
                case "CGC":
                case "CGA":
                case "CGG":
                case "AGA":
                case "AGG":

                    temp.add(AcideAmine.Arg);

                    break;
                case "AAU":
                case "AAC":

                    temp.add(AcideAmine.Asn);

                    break;
                case "GAU":
                case "GAC":

                    temp.add(AcideAmine.Asp);
                    break;
                case "UGU":
                case "UGC":

                    temp.add(AcideAmine.Cys);
                    break;
                case "GAA":
                case "GAG":

                    temp.add(AcideAmine.Glu);
                    break;
                case "CAA":
                case "CAG":

                    temp.add(AcideAmine.Gln);
                    break;
                case "GGU":
                case "GGC":
                case "GGA":
                case "GGG":

                    temp.add(AcideAmine.Gly);
                    break;
                case "CAU":
                case "CAC":

                    temp.add(AcideAmine.His);
                    break;
                case "AUU":
                case "AUC":
                case "AUA":

                    temp.add(AcideAmine.Ile);
                    break;
                case "UUA":
                case "UUG":
                case "CUU":
                case "CUC":
                case "CUA":
                case "CUG":

                    temp.add(AcideAmine.Leu);
                    break;
                case "AAA":
                case "AAG":

                    temp.add(AcideAmine.Lys);
                    break;
                case "AUG":

                    temp.add(AcideAmine.Met);
                    break;
                case "UUU":
                case "UUC":

                    temp.add(AcideAmine.Phe);
                    break;
                case "CCU":
                case "CCC":
                case "CCA":
                case "CCG":

                    temp.add(AcideAmine.Pro);
                    break;
                case "UAG":

                    temp.add(AcideAmine.Pyl);
                    break;
                case "UGA":

                    temp.add(AcideAmine.Sec);
                    break;
                case "UCU":
                case "UCC":
                case "UCA":
                case "UCG":
                case "AGU":
                case "AGC":

                    temp.add(AcideAmine.Ser);
                    break;
                case "ACU":
                case "ACC":
                case "ACA":
                case "ACG":

                    temp.add(AcideAmine.Thr);
                    break;
                case "UGG":

                    temp.add(AcideAmine.Trp);
                    break;
                case "UAU":
                case "UAC":

                    temp.add(AcideAmine.Tyr);
                    break;
                case "GUU":
                case "GUC":
                case "GUA":
                case "GUG":

                    temp.add(AcideAmine.Val);
                    break;
                case "UAA":

                    temp.add(AcideAmine.Fin);
                    break;

            }

        }

        return temp;

    }

    /*
     * Créer la séquence d'amino acide
     *
     * @param a
     *      un String Une chaîne représentant un ARN
     *
     * @return arnA
     *      La séquence d’acides aminés contenus dans l’ARN
     */
    static ArrayList<AcideAmine> creeSequence(String a){

        ArrayList<AcideAmine> arnA = amino(splitString(a));

        estValide(a);

        if (estValide(a)) {

            splitString(a);
            amino(splitString(a));
            //System.out.println(ARN.splitString(a));

        } else {
            System.err.print("Mauvaise sequence");
            System.exit(0);
        }

        return arnA;
    }

}
