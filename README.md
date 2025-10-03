# DDA Line Drawing with AWT Feature

This repository provides a simple implementation of the DDA (Digital Differential Analyzer) line drawing algorithm using Java's Abstract Window Toolkit (AWT). The DDA algorithm is a fundamental computer graphics algorithm used for drawing lines between two points in a coordinate system.

## Features

- **DDA Line Drawing Algorithm**: Efficiently draws straight lines between two points.
- **AWT Integration**: Utilizes Java's AWT library for graphical user interface and rendering.
- **Interactive Window**: Displays the result in a window; easily extendable for more graphics features.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher

### Running the Program

1. **Clone the repository:**
   ```bash
   git clone https://github.com/kamleshhsupe01-tech/DDA-Line_drawing.git
   ```
2. **Navigate to the project directory:**
   ```bash
   cd DDA-Line_drawing
   ```
3. **Compile the Java source file:**
   ```bash
   javac dda_line.java
   ```
4. **Run the program:**
   ```bash
   java dda_line
   ```

## Example Code Snippet

```java
import java.awt.*;
import java.awt.event.*;

public class dda_line extends Frame {
    public dda_line() {
        setTitle("DDA Line Drawing with AWT");
        setSize(400, 400);
        setVisible(true);
    }

    public void paint(Graphics g) {
        int x1 = 50, y1 = 50;
        int x2 = 300, y2 = 300;
        drawDDALine(g, x1, y1, x2, y2);
    }

    private void drawDDALine(Graphics g, int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int steps = Math.max(Math.abs(dx), Math.abs(dy));
        float xInc = dx / (float) steps;
        float yInc = dy / (float) steps;
        float x = x1;
        float y = y1;
        for (int i = 0; i <= steps; i++) {
            g.drawLine(Math.round(x), Math.round(y), Math.round(x), Math.round(y));
            x += xInc;
            y += yInc;
        }
    }

    public static void main(String[] args) {
        new dda_line();
    }
}
```

## Customization

- Change the coordinates `x1, y1, x2, y2` in the `paint()` method to draw lines between different points.
- Extend the program to accept user input or mouse events for interactive line drawing.

## License

This project is licensed under the MIT License.

## Author

- [kamleshhsupe01-tech](https://github.com/kamleshhsupe01-tech)

---

Feel free to fork and enhance the application for more advanced graphics algorithms!
