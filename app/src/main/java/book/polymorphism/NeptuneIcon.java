package book.polymorphism;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * An icon that has the shape of the planet Mars.
 */
public class NeptuneIcon implements Icon {
  /**
   * Constructs a Neptune icon of a given size.
   * 
   * @param aSize the size of the icon
   */
  public NeptuneIcon(int aSize) {
    size = aSize;
  }

  public int getIconWidth() {
    return size;
  }

  public int getIconHeight() {
    return size;
  }

  public void paintIcon(Component c, Graphics g, int x, int y) {
    Graphics2D g2 = (Graphics2D) g;
    Ellipse2D.Double planet = new Ellipse2D.Double(x, y, size, size);
    g2.setColor(Color.BLUE);
    g2.fill(planet);
  }

  private int size;
}
