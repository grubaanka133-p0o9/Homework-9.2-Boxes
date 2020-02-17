public class BallProduct extends Product {
    double radius;

    public BallProduct(double radius) {
        this.radius = radius;
    }

    @Override
    double capacity() {
        return (4 / 3 * Math.PI * Math.pow(radius, 3));
    }
}
