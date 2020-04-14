import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PolyLines {

    // fields
    private List <Integer> linesx;
    private List <Integer> linesy;
    private Color col;
    private int thickness;

    //constructor
    public PolyLines(){
        this.linesx = new ArrayList<Integer>();
        this.linesy = new ArrayList<Integer>();
        this.col = Color.BLACK;
        this.thickness = 5;
    }


    // common set methods
    public void setColor(Color col){
        this.col = col;
    }

    public void setThickness(int thick){
        this.thickness = thick;
    }


    // common get methods
    public Color getColour(){
        return this.col;
    }

    public int getThickness(){
        return this.thickness;
    }

    public List<Integer> getLinesx(){
        return this.linesx;
    }

    public List <Integer> getLinesy(){
        return this.linesy;
    }


    // clear and add methods
    public void clearLine() {
        linesx.clear();
        linesy.clear();
    }


    public void addPoints(int x,int y){
        linesy.add(y);
        linesx.add(x);
    }



    // draw method
    public void drawline (Graphics g){
        if(linesx.size()==1){
            g.fillRect(linesx.get(0),linesy.get(0),thickness,thickness);
        }
        else {
            for (int i = 0; i < linesx.size() - 1; i++) {
                g.drawLine(linesx.get(i), linesy.get(i), linesx.get(i + 1), linesy.get(i + 1));
            }
        }
    }
}
