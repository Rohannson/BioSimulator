/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.bg;

import java.awt.Color;

/**
 *
 * @author rohan
 */
public class BGRule {

    private GetRadian getRadian;
    private double childLength = 0.7;
    private double angle = 30;

    public BGRule() {
        getRadian = GetRadian.instance();
    }
    
    public void setLength(double length){
        this.childLength = length;
    }
    
    public void setAngel(double angel){
        this.angle = angel;
    }
    
    public BGStem growBranchL(BGStem bGStem) {
        double radianL = 0;
        double length = 0;
        double[] newEndL = new double[2];
        //System.out.println("the input of RuleL " + bGStem.getEnd()[0] + " , " + bGStem.getEnd()[1]);
        //radianL = bGStem.getRadian() - getRadian.SimpleRadian(60) ;
        radianL = getRadian.getSimpleRadian(getRadian.getAngle(bGStem.getRadian()) + angle);
        //System.out.println("the new rad1: " + radianL);
        length = bGStem.getLength() * childLength;
        //System.out.println("the new length: " + bGStem.getLength());
        newEndL[0] = bGStem.getEnd()[0] + length * Math.cos(radianL);
        //System.out.println("new x value " + length * Math.cos(radianL));
        newEndL[1] = bGStem.getEnd()[1] - length * Math.sin(radianL);
        BGStem childStemL = new BGStem(bGStem.getEnd(), newEndL);
        childStemL.setLength(length);
        childStemL.setRadian(radianL);
        childStemL.setColor(Color.GREEN);
       // System.out.println("Call left");
        return childStemL;
    }

    public BGStem growBranchM(BGStem bGStem) {

        double radianM = 0;
        double length = 0;
        double[] newEndM = new double[2];
        //System.out.println("the input of RuleM " + bGStem.getEnd()[0] + " , " + bGStem.getEnd()[1]);
        // Middle Branch Growth
        radianM = getRadian.getSimpleRadian(0) + bGStem.getRadian();
//        System.out.println("Radian of 90: " + getRadian.SimpleRadian(90));
//        System.out.println("Current Radian: " + radianM);
        length = bGStem.getLength() * childLength;
        //System.out.println("the new length: " + bGStem.getLength());
        //System.out.println("the original end_x " + bGStem.getEnd()[0]+ " the additional part: " + length * Math.cos(radianM));
        //System.out.println("Explosion: " + Math.cos(radianM));
        if (radianM == getRadian.getSimpleRadian(90)) {
//            System.out.println("Call cos 90");
            newEndM[0] = bGStem.getEnd()[0];
        } else {
            newEndM[0] = bGStem.getEnd()[0] + length * Math.cos(radianM);
        }
        newEndM[1] = bGStem.getEnd()[1] - length * Math.sin(radianM);
//        System.out.println("X of new stem: " + newEndM[0] + ", y of new stem: " + newEndM[1]);
        BGStem childStemM = new BGStem(bGStem.getEnd(), newEndM);
        childStemM.setLength(length);
        childStemM.setRadian(radianM);
        childStemM.setColor(new Color(128, 42, 42));
        //System.out.println("Call middle");
        return childStemM;

    }

    public BGStem growBranchR(BGStem bGStem) {

        double radianR = 0;
        double length = 0;
        //System.out.println("the input of RuleR " + bGStem.getEnd()[0] + " , " + bGStem.getEnd()[1]);
        double[] newEndR = new double[2];
        //Left branch Growth
         radianR = getRadian.getSimpleRadian(getRadian.getAngle(bGStem.getRadian()) - angle);
        //System.out.println("the new rad1: " + radianR);
        length = bGStem.getLength() * childLength;
//        System.out.println("the new length: " + bGStem.getLength());
        newEndR[0] = bGStem.getEnd()[0] + length * Math.cos(radianR);
//        System.out.println("new cord: " + newEndL[0]);
        newEndR[1] = bGStem.getEnd()[1] - length * Math.sin(radianR);
        BGStem childStemR = new BGStem(bGStem.getEnd(), newEndR);
        childStemR.setLength(length);
        childStemR.setRadian(radianR);
        childStemR.setColor(Color.GREEN);
        //System.out.println("Call right");
        return childStemR;
    }

}
