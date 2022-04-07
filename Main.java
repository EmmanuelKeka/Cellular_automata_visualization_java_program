import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main extends JFrame {
    int numberOfGeneration;
    Main() {
        numberOfGeneration = new File("data/").listFiles().length;
        JLabel label = new JLabel();
        JPanel panel = new JPanel();
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setDoubleBuffered(true);
        panel.add(label);
        panel.setDoubleBuffered(true);
        panel.setBackground(Color.black);
        add(panel);
        setVisible(true);
        setSize(5000,1000);
        if(numberOfGeneration == 0){
            label.setText("NO DATA FOUND");
            label.setForeground(Color.white);
            return;
        }
        for(int i = 0; i< numberOfGeneration; i++) {
            label.setIcon(new ImageIcon(new GridGenerator("data/data" + i).getImage()));
        }
    }
    public static void main(String[] args) {
        new Main();
    }
}
