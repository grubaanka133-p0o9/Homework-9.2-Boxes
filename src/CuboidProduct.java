public class CuboidProduct extends Product {
    double length;
    double width;
    double height;

    public CuboidProduct(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    double capacity() {
        return (width * height * length);
    }
}
