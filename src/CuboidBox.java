public class CuboidBox extends Box {
    double length;
    double width;
    double height;

    public CuboidBox(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    double capacity() {
        return (width * height * length);
    }
}
