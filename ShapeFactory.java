import java.awt.Color;
import java.util.Random;

public class ShapeFactory {
    private ShapeType shapeType;
    private final Random random;

    public ShapeFactory() {
        this.shapeType = ShapeType.RECTANGLE;
        this.random = new Random();
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public Shape createShape(int x, int y) {
        Color color = generateRandomColor();
        switch (shapeType) {
            case RECTANGLE:
                return new RectangleShape(x, y, 100, 50, color);
            case CIRCLE:
                return new CircleShape(x, y, 50, color);
            default:
                throw new IllegalArgumentException("Unsupported shape type: " + shapeType);
        }
    }

    private Color generateRandomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}
