import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //scanner object


        Scanner sc = new Scanner(System.in);

        //enter first rna sequence
        System.out.println("Entrez la première chaîne :");
        String a = sc.next();
        System.out.println("Entrez la deuxième chaîne");
        String b = sc.next();
        System.out.println("Entrez la distance maximale:");
        int m = sc.nextInt();

        sc.close();

        //2.
        if (!ARN.estValide(a) || !ARN.estValide(b)) {
            System.err.print("Mauvaise Sequence");
        } else {
            if (!Metrique.chiffreValide(m)) {
                System.err.print("Cette valeur doit être plus grande que 0.");
            } else {

            /*
            2. Acide amine
            System.out.println(ARN.creeSequence(a));
            System.out.println(ARN.creeSequence(b));


            //6. devMinimal
            System.out.println(Arrays.toString(Metrique.creeDevMinimal(Metrique.tabDev(ARN.creeSequence(a), ARN.creeSequence(b)), a, b)));

            //7. Somme
            System.out.println(Metrique.additionneDev(Metrique.creeDevMinimal(Metrique.tabDev(ARN.creeSequence(a), ARN.creeSequence(b)), a, b), m));

            //8. metrique
            System.out.println(Metrique.calculeMet(Metrique.additionneDev(Metrique.creeDevMinimal(Metrique.tabDev(ARN.creeSequence(a), ARN.creeSequence(b)), a, b), m), ARN.creeSequence(a).size(), ARN.creeSequence(b).size(),m ));

            //9. Petit Calcul
            */
                System.out.print("K(s,t) = ");
                Metrique.petitCalcul(Metrique.calculeMet(Metrique.additionneDev(Metrique.creeDevMinimal(Metrique.tabDev(ARN.creeSequence(a),
                        ARN.creeSequence(b)), a, b), m), ARN.creeSequence(a).size(), ARN.creeSequence(b).size(), m));

            }
        }


    }






}
