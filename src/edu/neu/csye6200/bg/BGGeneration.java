/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.bg;

import java.util.ArrayList;

/**
 *
 * @author rohan
 */
public class BGGeneration {
    
    private ArrayList<BGStem> stemList;
    
    public BGGeneration(){
        
        stemList = new ArrayList<BGStem>();
      
    }

    public ArrayList<BGStem> getStemList() {
        return stemList;
    }
    
    public void addBGStem(BGStem bGStem){
        this.stemList.add(bGStem);
    }

    public void setStemList(ArrayList<BGStem> stemList) {
        this.stemList = stemList;
    }
    
    
    
}
