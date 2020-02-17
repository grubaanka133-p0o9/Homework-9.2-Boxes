public class BoxArray {
    Box[] boxes = new Box[6];

    public Box findBox(Product product) {
        if (chooseBox(product) == null) {
            System.out.println("The matching box does not exist");
            return null;
        } else {
            System.out.println("The matching box exist. Box capacity is:" + chooseBox(product).capacity());
            return chooseBox(product);
        }
    }

    private Box chooseBox(Product product) {
        Box matching = null;
        double space = 0;
        if (product instanceof BallProduct) {
            for (int i = 0; i < boxes.length; i++) {
                if (boxes[i] instanceof CylinderBox) {
                    if ((isProdSmallerThanBox(product, boxes[i])) && (isBallProdFitsToCylinderBox(product, boxes[i]))) {
                        matching = boxes[i];
                        space = freeSpace(product, boxes[i]);
                        break;
                    }
                }
            }
            for (int i = 0; i < boxes.length; i++) {
                if (boxes[i] instanceof CylinderBox) {
                    if ((isProdSmallerThanBox(product, boxes[i])) && (freeSpace(product, boxes[i]) <= space)
                            && (isBallProdFitsToCylinderBox(product, boxes[i]))) {
                        matching = boxes[i];
                        space = freeSpace(product, boxes[i]);
                    }
                }
            }
        } else {
            for (int i = 0; i < boxes.length; i++) {
                if (boxes[i] instanceof CuboidBox) {
                    if ((isProdSmallerThanBox(product, boxes[i])) && (isCubProdFitsToCubBox(product, boxes[i]))) {
                        matching = boxes[i];
                        space = freeSpace(product, boxes[i]);
                        break;
                    }
                }
            }
            for (int i = 0; i < boxes.length; i++) {
                if (boxes[i] instanceof CuboidBox) {
                    if ((isProdSmallerThanBox(product, boxes[i])) && (freeSpace(product, boxes[i]) <= space)
                            && (isCubProdFitsToCubBox(product, boxes[i]))) {
                        matching = boxes[i];
                        space = freeSpace(product, boxes[i]);
                    }
                }
            }

        }
        return matching;
    }

    private boolean isProdSmallerThanBox(Product product, Box box) {
        if (product.capacity() <= box.capacity()) {
            return true;
        }
        return false;
    }

    private boolean isBallProdFitsToCylinderBox(Product product, Box box) {
        if (((CylinderBox) box).height >= (2 * ((BallProduct) product).radius)) {
            if (((CylinderBox) box).radius >= ((BallProduct) product).radius) {
                return true;
            }
        }
        return false;
    }

    private boolean isCubProdFitsToCubBox(Product product, Box box) {
        double cubProdHeight = ((CuboidProduct) product).height;
        double cubProdWidth = ((CuboidProduct) product).width;
        double cubProdLength = ((CuboidProduct) product).length;
        double cubBoxHeight = ((CuboidBox) box).height;
        double cubBoxWidth = ((CuboidBox) box).width;
        double cubBoxLength = ((CuboidBox) box).length;

        return (cubProdHeight <= cubBoxHeight) && ((cubProdWidth <= cubBoxWidth) && (cubProdLength <= cubBoxLength)
                || (cubProdLength <= cubBoxWidth) && (cubProdWidth <= cubBoxLength))

                || (cubProdWidth <= cubBoxHeight) && ((cubProdLength <= cubBoxWidth) && (cubProdHeight <= cubBoxLength)
                || (cubProdHeight <= cubBoxWidth) && (cubProdLength <= cubBoxLength))

                || (cubProdLength <= cubBoxHeight) && ((cubProdHeight <= cubBoxWidth) && (cubProdWidth <= cubBoxLength)
                || (cubProdWidth <= cubBoxWidth) && (cubProdHeight <= cubBoxLength));

    }

    private double freeSpace(Product product, Box box) {
        return (box.capacity() - product.capacity());
    }
}


