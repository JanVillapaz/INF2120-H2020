public class Rectangle extends Forme2D {
    private double hauteur;
    private double largeur;

    private void setHauteur(double hauteur) {
        assert 0 <= largeur;
        this.hauteur = hauteur;
    }

    private void setLargeur(double largeur) {
        this.largeur = largeur;
    }
    @Override
    public double aire() {
        return hauteur * largeur;
    }
}
