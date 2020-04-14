import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;


class BlackColChoose extends JPanel implements Observer {

    //fields
    private Model model;

    //constructor
    public BlackColChoose(Model model){

        this.setBackground(Color.BLACK);
        this.model = model;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                model.setColour(Color.BLACK);
            }
        });
        model.addObserver(this);
    }

    public void update (Object observable) {
        model = (Model) observable;
        repaint();
    }
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        g.drawRect(0, 0, this.getWidth(), this.getHeight());
    }
}
