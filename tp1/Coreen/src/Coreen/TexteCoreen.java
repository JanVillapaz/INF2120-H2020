package Coreen;

import java.util.ArrayList;
import java.util.Arrays;

public class TexteCoreen {
    public static int VAL_NUM = 44032;
    public static String TEXTE_TRADUIT = "";

    public TexteCoreen(String texte) {
        ArrayList<Integer> uni = new ArrayList<>();
        ArrayList<int[]> jamo = new ArrayList<>();

        genereCodePoint(texte, uni);
        calculUnicode(uni, jamo);

        ArrayList<Integer> con = new ArrayList<>();
        ArrayList<Integer> fin = new ArrayList<>();
        ArrayList<String> alphaIn = new ArrayList<>();

        // get the jamo of the final
        int [] ok;
        for (int k = 0; k < uni.size() - 1; ++k) {
            ok = jamo.get(k);

            //System.out.print(ok[2] + " ");
            fin.add(ok[2]);
        }

        /*
         get the jamo of con + 1
         */
        int [] ok1;
        for (int l = 1; l < uni.size(); ++l) {
            ok1 = jamo.get(l);
            //System.out.print(ok1[0] + " ");
            con.add(ok1[0]);
        }

        IPA tri = new IPA();

        //New pronounciations
        for (int n = 0; n < con.size(); n++) {
            String okok;

            alphaIn.add(tri.conversion(con.get(n), fin.get(n)));

        }
        //before final
        ArrayList<String[]> AlphaB = new ArrayList<>();
        for (int[] array : jamo){
            AlphaB.add(tri.texteIpa(array[0],array[1],array[2]));

        }

        ArrayList<String> mylist = new ArrayList<>();

        //save it in one big array
        for (int i = 0; i < AlphaB.size(); i++) {
            mylist.addAll(Arrays.asList(AlphaB.get(i)));
        }

        tri.finale(alphaIn, mylist);

        ArrayList<String> finale = new ArrayList<>();

        for (int k = 0; k < mylist.size(); k++) {

            for (int l = 0; l < mylist.get(k).length(); l++) {
                finale.add(tri.unicodegenerator(mylist.get(k)));
            }

        }


        for (int j = 0; j < finale.size(); j++) {
            TEXTE_TRADUIT += finale.get(j);
        }

        System.out.println(TEXTE_TRADUIT);
    }


    public void calculUnicode(ArrayList<Integer> unicode, ArrayList<int[]> jamo) {
        for (Integer integer : unicode) {
            int d_i = noConsonneFinale(integer);
            int v_i = noVoyelle(integer);
            int c_i = noConsonneInitiale(integer);

            jamo.add(new int[] {c_i, v_i, d_i});
        }
    }

    public void genereCodePoint(String texte, ArrayList<Integer> alist) {
        int unicode;

        for (int i = 0; i < texte.length(); i++) {
            unicode = texte.codePointAt(i);
            alist.add(unicode);
        }
    }

    public int noConsonneInitiale( int position ){
        int ui = position - VAL_NUM;
        return 1 + ui / 588;
    }

    public int noVoyelle( int position ) {
        int ui = position - VAL_NUM;
        int di = ui % 28;
        return 1 + (1 + (ui - di) % 588) / 28;
    }

    public int noConsonneFinale( int position ) {
        int ui = position - VAL_NUM;
        return ui % 28;
    }

    public String traduire() {
        return TEXTE_TRADUIT;
    }
}
