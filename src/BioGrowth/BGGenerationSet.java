package BioGrowth;

import java.util.ArrayList;

public class BGGenerationSet {

	private ArrayList<BGGeneration> bGGSet;

	public BGGenerationSet() {

		bGGSet = new ArrayList<>();

	}

	public ArrayList<BGGeneration> getbGGSet() {
		return bGGSet;
	}

	public void setbGGSet(ArrayList<BGGeneration> bGGSet) {
		this.bGGSet = bGGSet;
	}

	public void addStemList(BGGeneration bgg) {
		this.getbGGSet().add(bgg);
	}

}
