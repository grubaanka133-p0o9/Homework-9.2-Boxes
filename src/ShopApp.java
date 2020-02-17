public class ShopApp {
    public static void main(String[] args) {
        BoxArray boxArray = new BoxArray();
        boxArray.boxes[0] = new CuboidBox(3, 7, 5);
        boxArray.boxes[1] = new CuboidBox(6, 4, 8);
        boxArray.boxes[2] = new CuboidBox(8, 6, 4.5);
        boxArray.boxes[3] = new CylinderBox(5, 10);
        boxArray.boxes[4] = new CylinderBox(9, 5);
        boxArray.boxes[5] = new CylinderBox(3, 6);

        Product cuboid = new CuboidProduct(6, 4, 8);
        Product ball = new BallProduct(5);

        boxArray.findBox(ball);


    }
}
