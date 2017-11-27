package BioGrowth;

import java.awt.Color;

public class BGStem {
	
	private double[] start = new double[2];
    private double[] end = new double[2];
    private double length = 0;
    private double radian = 0;
	private Color color = null;

    public BGStem(double[] s, double[] m) {
        this.start = s;
        this.end = m;
    }
    
    public void setColor(Color color){
        this.color = color;
    }
    
    public Color getColor(){
        return this.color;
    }

    public double[] getStart() {
        return start;
    }

    public void setStart(double x_start, double y_start) {
        this.start[0] = x_start;
        this.start[1] = y_start;
    }

    public double[] getEnd() {
        return end;
    }

    public void setEnd(double x_end, double y_end) {
        this.end[0] = x_end;
        this.end[1] = y_end;
    }

    public double getRadian() {
        return radian;
    }

    public void setRadian(double radian) {
        this.radian = radian;
    }
    
    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

}
