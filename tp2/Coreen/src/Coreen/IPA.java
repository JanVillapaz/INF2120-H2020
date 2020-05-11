package Coreen;
import java.util.ArrayList;

public class IPA {

    public String[] texteIpa(int c, int v, int d) {
        return new String[]{ ci(c) , vi(v) , di(d) };
    }

    //a is replacement letters, b is the words before, c is the new words


    public ArrayList<String> finale(ArrayList<String> listConvertit, ArrayList<String> texteApres) {
        String before;
        String after;

        for (int j = 0 ; j < listConvertit.size(); j ++) {
            for (int k = 2; k < (texteApres.size() /3); k+= 3) {
                if (listConvertit.get(j).length() == 1 ) {

                    if (listConvertit.get(j).equals("-")) {
                    } else {
                        texteApres.set(k, listConvertit.get(j));
                        texteApres.set(k + 1, "-");
                    }

                } else if (listConvertit.get(j).charAt(k) == '+') {
                    before = listConvertit.get(j).substring(0, listConvertit.get(j).indexOf("+"));
                    after = listConvertit.get(3).substring(listConvertit.get(3).indexOf("+") + 1);

                    texteApres.set(k, before);
                    texteApres.set(k+1, after);

                }

            }
        }

        return texteApres;
    }


    public String unicodegenerator(String ipa) {
        String unicode = "";

        switch(ipa) {
            case "h":
                unicode = "\u0068";
                break;
            case "k":
                unicode = "\u006B";
                break;
            case "l":
                unicode = "\u006C";
                break;
            case "m":
                unicode = "\u006D";
                break;
            case "n":
                unicode = "\u006E";
                break;
            case "p":
                unicode = "\u0070";
                break;
            case "s":
                unicode = "\u0073";
                break;
            case "t":
                unicode = "\u0074";
                break;
            case "ŋ":
                unicode = "\u014B";
                break;
            case "ɕ":
                unicode = "\u0255";
                break;
            case "ɾ":
                unicode = "\u027E";
                break;
            case "k̤":
                unicode = "\u006B" + "\u0324";
                break;
            case "kʰ":
                unicode = "\u006B" + "\u02B0";
                break;
            case "k̚":
                unicode = "\u006B" + "\u031A";
                break;
            case "p̤":
                unicode = "\u0070" + "\u0324";
                break;
            case "pʰ":
                unicode = "\u0070" + "\u02B0";
                break;
            case "p̚":
                unicode = "\u0070" + "\u031A";
                break;
            case "s̤":
                unicode = "\u0073" + "\u0324";
                break;
            case "t̤":
                unicode = "\u0074" + "\u0324";
                break;
            case "tʰ":
                unicode = "\u0074 " + "\u02B0";
                break;
            case "t̚":
                unicode = "\u0074" + "\u031A";
                break;
            case "ɕʰ":
                unicode = "\u0255 " + "\u02B0";
                break;
            case "a":
                unicode = "\u0061";
                break;
            case "e":
                unicode = "\u0065";
                break;
            case "i":
                unicode = "\u0069";
                break;
            case "j":
                unicode = "\u006A";
                break;
            case "o":
                unicode = "\u006F";
                break;
            case "ø":
                unicode = "\u00F8";
                break;
            case "ʌ":
                unicode = "\u028C";
                break;
            case "u":
                unicode = "\u0075";
                break;
            case "w":
                unicode = "\u0077";
                break;
            case "y":
                unicode = "\u0079";
                break;
            case "ɛ":
                unicode = "\u025B";
                break;
            case "ɯ":
                unicode = "\u026F";
                break;
            case "ɰ":
                unicode = "\u0270";
                break;

            default:
                break;

        }

        return unicode;
    }

    public String conversion(int cInitiale, int cFinale) {
        String ipa = "";
        switch (cInitiale) {
            case 12:
                switch (cFinale) {
                    case 1:
                        ipa = "k";
                        break;
                    case 2:
                        ipa = "k̤+h";
                        break;
                    case 4:
                        ipa = "n";
                        break;
                    case 7:
                        ipa = "t̚";
                        break;
                    case 8:
                        ipa = "ɾ";
                        break;
                    case 16:
                        ipa = "m";
                        break;
                    case 17:
                        ipa = "p̚";
                        break;
                    case 19:
                        ipa = "s";
                        break;
                    case 20:
                        ipa = "s̤";
                        break;
                    case 21:
                        ipa = "ŋ+h";
                        break;
                    case 22:
                    case 23:
                    case 25:
                        ipa = "t̚+tɕʰ";
                        break;
                    case 24:
                        ipa = "k̚+h";
                        break;
                    case 26:
                        ipa = "p̚+h";
                        break;
                    case 27:
                        ipa = "h";
                        break;

                    case 3:
                        ipa = "k+s";
                        break;
                    case 5:
                        ipa = "n+tɕ";
                        break;
                    case 6:
                        ipa = "l+h";
                        break;
                    case 9:
                        ipa = "l+k";
                        break;
                    case 10:
                        ipa = "l+m";
                        break;
                    case 11:
                        ipa = "l+p";
                        break;
                    case 12:
                        ipa = "l+s";
                        break;
                    case 13:
                        ipa = "l+tʰ";
                        break;
                    case 14:
                        ipa = "l+pʰ";
                        break;
                    case 15:
                        ipa = "l+h";
                        break;
                    case 18:
                        ipa = "p̚+s";
                        break;
                    default:
                        ipa = "-";
                        break;
                }
                break;
            case 19:
                switch (cFinale) {
                    case 1:
                    case 24:
                        ipa = "k̚";
                        break;
                    case 2:
                        ipa = "k̤+h";
                        break;
                    case 4:
                        ipa = "n+h";
                        break;
                    case 7:
                    case 19:
                    case 25:
                        ipa = "t̚";
                        break;
                    case 8:
                        ipa = "ɾ";
                        break;
                    case 16:
                        ipa = "m+h";
                        break;
                    case 17:
                    case 26:
                        ipa = "p̚";
                        break;
                    case 21:
                        ipa = "ŋ+h";
                        break;
                    case 22:
                    case 23:
                        ipa = "t̚+tɕʰ";
                        break;
                    default:
                        ipa = "-";
                        break;
                }
                break;
            case 1:
                switch (cFinale) {
                    case 1:
                        ipa = "k̚+k̚";
                        break;
                    case 4:
                        ipa = "n+k";
                        break;
                    case 7:
                    case 19:
                    case 25:
                    case 23:
                    case 22:
                        ipa = "t̚+k";
                        break;
                    case 8:
                        ipa = "l+k";
                        break;
                    case 16:
                        ipa = "p+k";
                        break;
                    case 17:
                        ipa = "p̚";
                        break;
                    case 21:
                        ipa = "ŋ+k";
                        break;
                    case 26:
                        ipa = "p̚+k";
                        break;
                    case 27:
                        ipa = "h+k̚";
                        break;

                    default:
                        ipa = "-";
                        break;
                }

                break;
            case 3:
                switch (cFinale) {
                    case 1:
                        ipa = "ŋ";
                        break;
                    case 4:
                        ipa = "n+n";
                        break;
                    case 8:
                        ipa = "l+l";
                        break;
                    case 16:
                    case 17:
                        ipa = "m+n";
                        break;

                    case 19:
                    case 23:
                    case 22:
                    case 25:
                        ipa = "t̚+n";
                        break;
                    case 20:
                        ipa = "n+t̚";
                        break;
                    case 21:
                        ipa = "ŋ+n";
                        break;
                    case 26:
                        ipa = "p̚+n";
                        break;
                    case 27:
                        ipa = "h+n";
                        break;
                    default:
                        ipa = "-";
                        break;
                }
                break;
            case 4:
                switch (cFinale) {
                    case 1:
                    case 24:
                        ipa = "k̚+t";
                        break;
                    case 4:
                        ipa = "n+t";
                        break;
                    case 7:
                    case 19:
                    case 20:
                    case 22:
                    case 23:
                    case 25:
                        ipa = "t̚+t̚";
                        break;
                    case 8:
                        ipa = "l+t";
                        break;
                    case 15:
                    case 12:
                        ipa = "l+t̚";
                        break;
                    case 16:
                    case 10:
                        ipa = "m+t";
                        break;
                    case 17:
                    case 26:
                        ipa = "p̚+t";
                        break;
                    case 21:
                        ipa = "ŋ+t";
                        break;
                    case 27:
                        ipa = "h+t̚";
                        break;

                    case 3:
                        ipa = "k+t̚";
                        break;
                    case 5:
                        ipa = "ntɕ+t";
                        break;
                    case 6:
                        ipa = "n+t̚";
                        break;
                    case 9:
                        ipa = "k+t";
                        break;
                    case 11:
                        ipa = "p+t";
                        break;
                    case 13:
                        ipa = "l+tʰ";
                        break;
                    case 14:
                        ipa = "pʰ+t";
                        break;
                    case 18:
                        ipa = "p̚+t̚";
                        break;
                    default:
                        ipa = "-";
                        break;
                }
                break;
            case 6:
                switch (cFinale) {
                    case 1:
                        ipa = "k+n";
                        break;
                    case 4:
                    case 8:
                        ipa = "l+l";
                        break;
                    case 16:
                    case 17:
                        ipa = "m+n";
                        break;
                    case 21:
                        ipa = "n";
                        break;
                    case 27:
                        ipa = "ɾ";
                        break;
                    default:
                        ipa = "-";
                        break;
                }
                break;
            case 7:
                switch (cFinale) {
                    case 1:
                        ipa = "k+m";
                        break;
                    case 4:
                        ipa = "n+m";
                        break;
                    case 7:
                    case 25:
                    case 23:
                    case 22:
                    case 19:
                        ipa = "t̚+m";
                        break;
                    case 8:
                        ipa = "l+m";
                        break;
                    case 16:
                    case 17:
                        ipa = "m+m";
                        break;
                    case 21:
                        ipa = "ŋ+m";
                        break;
                    case 24:
                        ipa = "k̚+t";
                        break;
                    case 26:
                        ipa = "p̚+m";
                        break;
                    case 27:
                        ipa = "h+m";
                        break;

                    default:
                        ipa = "-";
                        break;
                }
                break;
            case 8:
                switch (cFinale) {
                    case 1:
                        ipa = "k+p";
                        break;
                    case 17:
                        ipa = "p̚+p̚";
                        break;
                    case 19:
                        ipa = "t̚+p";
                        break;
                    default:
                        ipa = "-";
                        break;
                }
                break;
            case 10:
                if (cFinale == 20) {
                    ipa = "s̤+s";
                } else {
                    ipa = "t̚+tɕʰ";
                }

            case 13:
                if (cFinale == 20) {
                    ipa = "t̚+tɕʰ";
                }

            default:
                break;
        }
        return ipa;
    }

    public String vi(int vi) {
        String ipa = "";

        switch (vi) {
            case 1:
                ipa = "a";
                break;
            case 2:
                ipa = "ɛ";
                break;
            case 3:
                ipa = "ja";
                break;
            case 4:
                ipa = "jɛ";
                break;
            case 5:
                ipa = "ʌ";
                break;
            case 6:
                ipa = "e";
                break;
            case 7:
                ipa = "jʌ";
                break;
            case 8:
                ipa = "je";
                break;
            case 9:
                ipa = "o";
                break;
            case 10:
                ipa = "wa";
                break;
            case 11:
                ipa = "wɛ";
                break;
            case 12:
                ipa = "ø";
                break;
            case 13:
                ipa = "jo";
                break;
            case 14:
                ipa = "u";
                break;
            case 15:
                ipa = "wʌ";
                break;
            case 16:
                ipa = "we";
                break;
            case 17:
                ipa = "y";
                break;
            case 18:
                ipa = "ju";
                break;
            case 19:
                ipa = "ɯ";
                break;
            case 20:
                ipa = "ɰi";
                break;
            case 21:
                ipa = "i";
                break;
        }

        return ipa;
    }

    public String di(int numero) {
        String ipa = "";

        switch (numero) {
            case 1:
                ipa = "k̚";
                break;
            case 2:
            case 24:
                ipa = "k̚";
                break;
            case 3:
            case 9:
                ipa = "k";
                break;
            case 4:
                ipa = "n";
                break;
            case 5:
                ipa = "ntɕ";
                break;
            case 6:
                ipa = "nh";
                break;
            case 7:
            case 19:
            case 20:
            case 22:
            case 23:
            case 27:
            case 25:
                ipa = "t̚";
                break;
            case 8:
                ipa = "l";
                break;
            case 10:
            case 16:
                ipa = "m";
                break;
            case 11:
                ipa = "p";
                break;
            case 12:
                ipa = "s";
                break;
            case 13:
                ipa = "tʰ";
                break;
            case 14:
                ipa = "pʰ";
                break;
            case 15:
                ipa = "h";
                break;
            case 17:
            case 18:
            case 26:
                ipa = "p̚";
                break;
            case 21:
                ipa = "ŋ";
                break;
            default:
                ipa = "-";
                break;
        }
        return ipa;
    }

    public String ci(int numero) {
        String ipa = "";

        switch (numero) {
            case 1:
                ipa = "k";
                break;
            case 2:
                ipa = "k̤";
                break;
            case 3:
                ipa = "n";
                break;
            case 4:
                ipa = "t";
                break;
            case 5:
                ipa = "t̤";
                break;
            case 6:
                ipa = "ɾ";
                break;
            case 7:
                ipa = "m";
                break;
            case 8:
                ipa = "p";
                break;
            case 9:
                ipa = "p̤";
                break;
            case 10:
                ipa = "s";
                break;
            case 11:
                ipa = "s̤";
                break;
            case 12:
                ipa = "";
                break;
            case 13:
                ipa = "tɕ";
                break;
            case 14:
                ipa = "t̤ɕ";
                break;
            case 15:
                ipa = "tɕʰ";
                break;
            case 16:
                ipa = "kʰ";
                break;
            case 17:
                ipa = "tʰ";
                break;
            case 18:
                ipa = "pʰ";
                break;
            case 19:
                ipa = "h";
                break;
        }

        return ipa;
    }



}
