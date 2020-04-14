import java.awt.*;
import java.util.*;
import java.util.List;


public class Model{

    //fields
    private List <Observer> observers;

    private Color curColour;
    private int curThickness;
    public List <PolyLines> lines;
    public PolyLines curline;


    // constructors
    public Model() {
        this.observers = new ArrayList();

        this.curColour = Color.BLACK;
        this.curThickness = 5;
        this.lines= new ArrayList<PolyLines>();
        this.curline = new PolyLines();
    }


    // common get methods
    public List <Observer> getObservers() { return this.observers;}

    public Color getCurColour() { return this.curColour;}
    public int getThickness() { return this.curThickness;}
    public List <PolyLines> getList() { return this.lines;}
    public PolyLines getCurline() {return this.curline;}


    // common set methods
    public void setThickness (int s) {
        this.curThickness = s;
        notifyObservers();
    }

    public void setColour (Color c) {
        this.curColour = c;
        notifyObservers();
    }

    public void addPoint (int x, int y) {
        this.curline.addPoints(x,y);
        notifyObservers();
    }

    public void addLine(PolyLines li){
        lines.add(li);
        notifyObservers();
    }


    public void clearPage(){
        for(int i = 0; i<lines.size();i++) {
            this.lines.get(i).clearLine();
            this.curColour = Color.BLACK;
            this.curThickness = 5;
            this.curline.clearLine();

        }
        notifyObservers();
    }

    public void Replay(){

        for(int i=0;i<observers.size();i++){

            removeObserver(observers.get(i));
            notifyObservers();
        }

    }





    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer: this.observers) {
            observer.update(this);
        }
    }
}
