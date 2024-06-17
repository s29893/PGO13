import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.util.List;


public class DrawingCanvas extends JPanel {
    private final List<Shape> shapes;
    private final ShapeFactory shapeFactory;

    public DrawingCanvas(ShapeFactory shapeFactory) {
        this.shapes = new ArrayList<>();
        this.shapeFactory = shapeFactory;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Shape shape = shapeFactory.createShape(e.getX(), e.getY());
                if (shape != null) {
                    addShape(shape);
                }
            }
        });
    }

    private void addShape(Shape shape) {
        shapes.add(shape);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}
