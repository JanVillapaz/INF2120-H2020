package tp3;

import java.util.Scanner;

public class Principale {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in );

        System.out.print("Entrez la phrase generee : ");
        String phrase1 = sc.nextLine();
        System.out.print("Entrez la phrase cible : ");
        String phrase2 = sc.nextLine();
        sc.close();

        new Texte(phrase1, phrase2);

    }
}
