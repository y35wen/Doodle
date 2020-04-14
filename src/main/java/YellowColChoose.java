
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

class YellowColChoose extends JPanel implements Observer {
    //fields
    private Model model;

    public YellowColChoose(Model model){
        this.setBackground(Color.YELLOW);
        this.model = model;
        model.addObserver(this);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                model.setColour(Color.YELLOW);
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

