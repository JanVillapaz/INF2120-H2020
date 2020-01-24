public abstract class CylindreDroit extends Forme3D {
    private Forme2D base;
    private double hauteur;

    CylindreDroit(Forme2D base, double hauteur) {
        setBase(base);
        setHauteur(hauteur);
    }

    private void setHauteur(double hauteur) {
        assert 0.0 <= hauteur;
        this.hauteur = hauteur;
    }
    private void setBase(Forme2D base) {
        this.base = base;
    }

    @Override
    double volume() {
        return base.aire() * hauteur;
    }
}
