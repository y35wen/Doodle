import javax.swing.*;
import java.awt.*;


public class ChosenThick extends JPanel implements Observer  {

    // fields
    private Model model;


    public ChosenThick(Model model){
        this.model = model;
        this.setBackground(Color.WHITE);
        model.addObserver(this);

    }


    public void update (Object observable) {
        model = (Model) observable;
        repaint();
    }


    public void paintComponent (Graphics g) {
        super.paintComponent(g);
        g.setColor(model.getCurColour());
        g.fillRect(10, getHeight() / 2, getWidth() - 20, model.getThickness());
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth(), getHeight());
    }

}

