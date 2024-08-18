import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GridGenerator extends JPanel {
    private final static int sell_size = 1;
    private final String filename;
    private final BufferedImage image;
    private static final Logger logger = Logger.getLogger(GridGenerator.class.getName());

    GridGenerator(String filename) {
        this.filename = filename;
        this.image = createImage();
    }
    public BufferedImage createImage() {
        BufferedImage grid = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = grid.createGraphics();
        int i = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            for (int y = 0; y < 1000; y += sell_size) {
                String data = reader.readLine();
                for (int x = 0; x < 1000; x += sell_size) {
                    if (data.charAt(i) == '1') {
                        g.setColor(Color.GREEN);
                        g.fillRect(x, y, sell_size , sell_size );
                    }
                    else if (data.charAt(i) == '2') {
                        g.setColor(Color.RED);
                        g.fillRect(x, y, sell_size , sell_size );
                    }
                    else if (data.charAt(i) == '3') {
                        g.setColor(Color.yellow);
                        g.fillRect(x, y, sell_size , sell_size );
                    }
                    else {
                        g.setColor(Color.WHITE);
                        g.fillRect(x, y, sell_size , sell_size );
                    }
                    i++;
                }
                i = 0;
            }
        }
        catch (IOException e) {
            logger.log(Level.parse("An error occurred: {}"), e.getMessage(), e);
        }
        return grid;
    }
    public BufferedImage getImage() {
        return image;
    }
}
