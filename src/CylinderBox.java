public class CylinderBox extends Box {
    double radius;
    double height;

    public CylinderBox(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    double capacity() {
        return (Math.PI*Math.pow(radius, 2)*height);
    }
}
