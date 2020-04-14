import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



class Canvas extends JPanel implements Observer {

    //fields
    private Model model;

    //constructors
    public Canvas (Model model) {

        this.model = model;

        addMouseListener(new MouseAdapter() {

            public void mousePressed (MouseEvent e) {
                model.addPoint(e.getX(),e.getY());
            }

            public void mouseReleased(MouseEvent e) {

                PolyLines temp = new PolyLines();
                for(int i=0; i<model.getCurline().getLinesy().size(); i++){
                    temp.addPoints(model.getCurline().getLinesx().get(i), model.getCurline().getLinesy().get(i));
                }
                temp.setColor(model.getCurColour());
                temp.setThickness(model.getThickness());
                model.addLine(temp);
                model.getCurline().clearLine();

            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                model.addPoint(e.getX(),e.getY());
            }
        });

        model.addObserver(this);
    }



    public void update (Object observable) {
        model = (Model) observable;
        repaint();
    }

    protected void paintComponent (Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        for(int i=0; i<model.getList().size(); i++){
            int thick = model.getList().get(i).getThickness();
            Stroke stroke = new BasicStroke(thick);
            g2.setStroke(stroke);
            g2.setColor(model.getList().get(i).getColour());
            model.getList().get(i).drawline(g2);
        }

        int thicknow =model.getThickness();
        Stroke strokenow = new BasicStroke(thicknow);
        g2.setStroke(strokenow);
        g2.setColor(model.getCurColour());
        model.getCurline().drawline(g2);
        g2.dispose();
    }
}