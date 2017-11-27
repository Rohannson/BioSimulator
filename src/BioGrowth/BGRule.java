package BioGrowth;

import java.awt.Color;

public class BGRule {

	private GetRadian getRadian;
	private double childLength = 0.7;
	private double angle = 30;

	public BGRule() {
		getRadian = GetRadian.instance();
	}

	public void setLength(double length) {
		this.childLength = length;
	}

	public void setAngel(double angel) {
		this.angle = angel;
	}

	public BGStem growBranchL(BGStem bGStem) {
		double radianL = 0;
		double length = 0;
		double[] newEndL = new double[2];
		
		radianL = getRadian.getSimpleRadian(getRadian.getAngle(bGStem.getRadian()) + angle);
		length = bGStem.getLength() * childLength;
		newEndL[0] = bGStem.getEnd()[0] + length * Math.cos(radianL);
		newEndL[1] = bGStem.getEnd()[1] - length * Math.sin(radianL);
		BGStem childStemL = new BGStem(bGStem.getEnd(), newEndL);
		childStemL.setLength(length);
		childStemL.setRadian(radianL);
		childStemL.setColor(Color.GREEN);
		return childStemL;
	}

	public BGStem growBranchM(BGStem bGStem) {

		double radianM = 0;
		double length = 0;
		double[] newEndM = new double[2];
		
		radianM = getRadian.getSimpleRadian(0) + bGStem.getRadian();
		length = bGStem.getLength() * childLength;
		if (radianM == getRadian.getSimpleRadian(90)) {
			newEndM[0] = bGStem.getEnd()[0];
		} else {
			newEndM[0] = bGStem.getEnd()[0] + length * Math.cos(radianM);
		}
		newEndM[1] = bGStem.getEnd()[1] - length * Math.sin(radianM);
		BGStem childStemM = new BGStem(bGStem.getEnd(), newEndM);
		childStemM.setLength(length);
		childStemM.setRadian(radianM);
		childStemM.setColor(new Color(128, 42, 42));
		return childStemM;

	}

	public BGStem growBranchR(BGStem bGStem) {

		double radianR = 0;
		double length = 0;
		double[] newEndR = new double[2];
		radianR = getRadian.getSimpleRadian(getRadian.getAngle(bGStem.getRadian()) - angle);
		length = bGStem.getLength() * childLength;
		newEndR[0] = bGStem.getEnd()[0] + length * Math.cos(radianR);
		newEndR[1] = bGStem.getEnd()[1] - length * Math.sin(radianR);
		BGStem childStemR = new BGStem(bGStem.getEnd(), newEndR);
		childStemR.setLength(length);
		childStemR.setRadian(radianR);
		childStemR.setColor(Color.GREEN);
		return childStemR;
	}

}
