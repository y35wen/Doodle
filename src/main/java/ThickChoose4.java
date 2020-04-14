import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ThickChoose4 extends JPanel implements Observer {

    //fields
    private Model model;

    public ThickChoose4(Model model) {

        this.setBackground(new Color(255,224,189));
        this.model = model;
        model.addObserver(this);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                model.setThickness(9);
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(0, 0, getWidth(),getHeight());
        g.fillRect(10, getHeight()/2, getWidth()-20, 9);
    }

    public void update(Object observable) {
        model = (Model) observable;
        repaint();
    }
}