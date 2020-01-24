public class Cercle extends Forme2D {
    private double rayon;

    Cercle(double rayon) {
        setRayon(rayon);
    }

    private void setRayon(double rayon) {
        assert 0.0 <= rayon;
        this.rayon = rayon;
    }

    private double getRayon() {
        return rayon;
    }

    @Override
    double aire() {
        return Math.PI * rayon * rayon;
    }
}
