package BioGrowth;

import java.util.ArrayList;

public class BGGeneration {

	private ArrayList<BGStem> stemList;

	public BGGeneration() {

		stemList = new ArrayList<BGStem>();

	}

	public ArrayList<BGStem> getStemList() {
		return stemList;
	}

	public void addBGStem(BGStem bGStem) {
		this.stemList.add(bGStem);
	}

	public void setStemList(ArrayList<BGStem> stemList) {
		this.stemList = stemList;
	}

}
