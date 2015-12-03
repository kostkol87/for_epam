package HW02.t01;

import java.awt.*;

public class Pen {
    private String label;
    private Color color;

    Pen(Color color, String label){
        this.color = color;
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public int hashCode() {
        return label.length()*color.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == null || !(obj instanceof Pen)) return false;
        Pen o = (Pen) obj;
        return (getLabel().equals(o.getLabel()) && getColor().equals(o.getColor()));
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
