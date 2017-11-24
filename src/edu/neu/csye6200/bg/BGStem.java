/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.bg;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.stream.events.StartElement;
import jdk.nashorn.internal.parser.TokenType;

/**
 *
 * @author rohan
 */
public class BGStem {

    private double[] start = new double[2];
    private double[] end = new double[2];
    private double length = 0;
    private double radian = 0;
    private Color color = null;

    public BGStem(double[] s, double[] m) {
        // this.end = e;
        this.start = s;
        this.end = m;
       // System.out.println("Start: " + this.start[0] + ", " + this.start[1]);
       // System.out.println("End: " + this.end[0] + ", " + this.end[1]);
        //this.length = 
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
