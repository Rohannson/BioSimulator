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
public class BGGenerationSet {
    
    private ArrayList<BGGeneration> bGGSet;
    
    public BGGenerationSet(){
    
        bGGSet = new ArrayList<>();
        
    }

    public ArrayList<BGGeneration> getbGGSet() {
        return bGGSet;
    }

    public void setbGGSet(ArrayList<BGGeneration> bGGSet) {
        this.bGGSet = bGGSet;
    }
    
    public void addStemList(BGGeneration bgg){
        this.getbGGSet().add(bgg);
    }
}
