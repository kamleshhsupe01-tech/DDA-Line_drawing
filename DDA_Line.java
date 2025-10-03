import javax.swing.*;
import java.awt.*;

public class DDA_Line extends JPanel {

    private static String style = "Solid"; // Default style

    public static void main(String[] args) {
        // Prompt user to choose style
        String[] options = {"Solid", "Dashed"};
        style = (String) JOptionPane.showInputDialog(null, "Choose circle style:",
                "Circle Drawing", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        // Create and show window
        JFrame frame = new JFrame("Bresenham Circle - " + style);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(new DDA_Line());
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int xc = getWidth() / 2;
        int yc = getHeight() / 2;
        int radius = 100;

        drawBresenhamCircle(g, xc, yc, radius);
    }

    private void drawBresenhamCircle(Graphics g, int xc, int yc, int r) {
        int x = 0, y = r;
        int d = 3 - 2 * r;
        int count = 0;

        while (x <= y) {
            if (style.equals("Solid") || ((count / 5) % 2 == 0)) {
                drawCirclePoints(g, xc, yc, x, y);
            }
            count++;
            if (d < 0) {
                d = d + 4 * x + 6;
            } else {
                d = d + 4 * (x - y) + 10;
                y--;
            }
            x++;
        }
    }

    private void drawCirclePoints(Graphics g, int xc, int yc, int x, int y) {
        plot(g, xc + x, yc + y);
        plot(g, xc - x, yc + y);
        plot(g, xc + x, yc - y);
        plot(g, xc - x, yc - y);
        plot(g, xc + y, yc + x);
        plot(g, xc - y, yc + x);
        plot(g, xc + y, yc - x);
        plot(g, xc - y, yc - x);
    }

    private void plot(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }
}
