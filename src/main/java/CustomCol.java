import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;


public class CustomCol extends JPanel implements Observer{

    // fields
    private Model model;
    private JLabel tt;

    //constructor
    public  CustomCol(Model model) {
        tt = new JLabel("Custom Choose Color");
        this.model=model;
        this.add(tt);
        this.setBackground(Color.LIGHT_GRAY);
        model.addObserver(this);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Color newColor = JColorChooser.showDialog(tt,"choose a color",tt.getBackground());
                if(newColor != null) {
                    model.setColour(newColor);

                    tt.setForeground(newColor);
                    tt.setBackground(newColor);
                } else {
                    tt.setForeground(model.getCurColour());
                    tt.setBackground(model.getCurColour());
                }
            }
        });

    }

    public void update (Object observable) {
        model = (Model) observable;
        repaint();
    }

    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.drawRect(0, 0,this.getWidth(), this.getHeight());
    }
}
