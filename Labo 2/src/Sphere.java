public class Sphere extends Forme3D {
    private double rayon;

    @Override
    double volume() {
    return 4*Math.PI/3 * Math.pow(rayon,3);
    }
}
