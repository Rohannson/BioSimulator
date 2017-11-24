/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.bg;

/**
 *
 * @author rohan
 */
public class GetRadian {

    private static GetRadian instance = null;

    private GetRadian() {

    }

    public static GetRadian instance() {
        if (instance == null) {
            instance = new GetRadian();
        }
        return instance;
    }

    public double arccos(double a) {
        double b = 90.0, c0 = 0.0, c1 = 180.0;
        if (a < 1 && a > -1) {
            do {
                if (Math.cos(b * Math.PI / 180) >= a) {
                    c0 = b;
                    b = (c0 + c1) / 2;
                }
                if (Math.cos(b * Math.PI / 180) <= a) {
                    c1 = b;
                    b = (c0 + c1) / 2;
                }
            } while (Math.abs(c0 - c1) > 0.00001);
        }
        return b;
    }

    public double getMod(double i) {
        if (i >= 0) {
            return i;
        } else {
            return -i;
        }
    }

    public double getRadian(double[] start, double[] end) {
        double temp = (getMod(end[1] - start[1])) / Math.pow(Math.pow(end[0] - start[0], 2) + Math.pow(end[1] - start[1], 2), 0.5);
        temp = arccos(temp);
        temp = temp * Math.PI / 180;
        return temp;
    }

    public double getSimpleRadian(double angle){
        angle = angle * Math.PI / 180;
        return angle;
    }
    
    public double getAngle(double rad){
        double angle = 0;
        angle = rad * 180/Math.PI;
        return angle;
    }
    
   
    
}
