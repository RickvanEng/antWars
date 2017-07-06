package com.antwars.termiernator2;

import java.util.ArrayList;

public class Section {
	
	public Section() {
		
	}
	
	static ArrayList<Integer> sectionA = new ArrayList<Integer>();
	static ArrayList<Integer> sectionB = new ArrayList<Integer>();
	static ArrayList<Integer> sectionC = new ArrayList<Integer>();
	static ArrayList<Integer> sectionD = new ArrayList<Integer>();
	
	static ArrayList<Integer> sectionE = new ArrayList<Integer>();
	static ArrayList<Integer> sectionF = new ArrayList<Integer>();
	static ArrayList<Integer> sectionG = new ArrayList<Integer>();
	static ArrayList<Integer> sectionH = new ArrayList<Integer>();
	
	static ArrayList<Integer> sectionI = new ArrayList<Integer>();
	static ArrayList<Integer> sectionJ = new ArrayList<Integer>();
	static ArrayList<Integer> sectionK = new ArrayList<Integer>();
	static ArrayList<Integer> sectionL = new ArrayList<Integer>();
	
	//static int sectionA[] = new int[] { -6, -11 };
//	static int sectionB[] = new int[] { -6, -4 };
//	static int sectionC[] = new int[] { -6, 3 };
//	static int sectionD[] = new int[] { -6, 10 };
//
//	static int sectionE[] = new int[] { 0, -6 };
//	static int sectionF[] = new int[] { 0, 0 };
//	static int sectionG[] = new int[] { 0, 6 };
//	static int sectionH[] = new int[] { 0, 13 };
//
//	static int sectionI[] = new int[] { 6, -11 };
//	static int sectionJ[] = new int[] { 6, -3 };
//	static int sectionK[] = new int[] { 6, 4 };
//	static int sectionL[] = new int[] { 6, 11 };
	
	public static ArrayList<String> sections = new ArrayList<String>();
	

	// deze functie laat zien hoeveel ants er in een bepaalde sectie zijn
	// toegewezen.
	public static int antsInSection(String section) {

		int result = 0;

		for (int i = 0; i < MainClass.ants.size(); i++) {
			if (MainClass.ants.get(i).section != null) {
				if (MainClass.ants.get(i).section.equals(section)) {
					result++;
				}
			}
		}
		//System.out.println("In method: \"antsInSection\" result = " + result);
		return result;
	}

	// deze functie bepaald naar welke sectie de volgende ant moet gaan.
	public static String getNextSection() {

		String result = "";

		for (int i = 0; i < sections.size(); i++) {
			if (Section.antsInSection(sections.get(i)) < 1) {
				result = sections.get(i);
				return result;
			}
		}

		for (int i = 0; i < sections.size(); i++) {
			if (Section.antsInSection(sections.get(i)) < 2) {
				result = sections.get(i);
				return result;
			}
		}

		for (int i = 0; i < sections.size(); i++) {
			if (Section.antsInSection(sections.get(i)) == 2) {
				result = "FULL";
				return result;
			}
		}

		//System.out.println("In method: \"getNextSection\" result = " + result);
		return result;
	}

	public static boolean targetInSection(AntClass ant, int[] target) {

		if (ant.section != null) {
			switch (ant.section) {
			case "A":
				if (target[0] >= sectionA.get(0) - 3 && target[0] <= sectionA.get(0) + 2) {
					if (target[1] >= (sectionA.get(1) - 3) && target[1] <= (sectionA.get(1) + 3)) {
						return true;
					}
				}
				break;
			case "B":
				if (target[0] >= sectionB.get(0) - 3 && target[0] <= sectionB.get(0) + 2) {
					if (target[1] >= (sectionB.get(1) - 3) && target[1] <= (sectionB.get(1) + 3)) {
						return true;
					}
				}
				break;
			case "C":
				if (target[0] >= sectionC.get(0) - 3 && target[0] <= sectionC.get(0) + 2) {
					if (target[1] >= (sectionC.get(1) - 3) && target[1] <= (sectionC.get(1) + 3)) {
						return true;
					}
				}
				break;
			case "D":
				if (target[0] >= sectionD.get(0) - 3 && target[0] <= sectionD.get(0) + 2) {
					if (target[1] >= (sectionD.get(1) - 3) && target[1] <= (sectionD.get(1) + 3)) {
						return true;
					}
				}
				break;
			case "E":
				if (target[0] >= sectionE.get(0) - 3 && target[0] <= sectionE.get(0) + 3) {
					if (target[1] >= (sectionE.get(1) - 3) && target[1] <= (sectionE.get(1) + 2)) {
						return true;
					}
				}
				break;
			case "F":
				if (target[0] >= sectionF.get(0) - 3 && target[0] <= sectionF.get(0) + 3) {
					if (target[1] >= (sectionF.get(1) - 3) && target[1] <= (sectionF.get(1) + 3)) {
						return true;
					}
				}
				break;
			case "G":
				if (target[0] >= sectionG.get(0) - 3 && target[0] <= sectionG.get(0) + 3) {
					if (target[1] >= (sectionG.get(1) - 2) && target[1] <= (sectionG.get(1) + 3)) {
						return true;
					}
				}
				break;
			case "H":
				if (target[0] >= sectionH.get(0) - 3 && target[0] <= sectionH.get(0) + 3) {
					if (target[1] >= (sectionH.get(1) - 3) && target[1] <= (sectionH.get(1) + 3)) {
						return true;
					}
				}
				break;
			case "I":
				if (target[0] >= sectionI.get(0) - 2 && target[0] <= sectionI.get(0) + 3) {
					if (target[1] >= (sectionI.get(1) - 3) && target[1] <= (sectionI.get(1) + 3)) {
						return true;
					}
				}
				break;
			case "J":
				if (target[0] >= sectionJ.get(0) - 2 && target[0] <= sectionJ.get(0) + 3) {
					if (target[1] >= (sectionJ.get(1) - 3) && target[1] <= (sectionJ.get(1) + 3)) {
						return true;
					}
				}
				break;
			case "K":
				if (target[0] >= sectionK.get(0) - 2 && target[0] <= sectionK.get(0) + 3) {
					if (target[1] > (sectionK.get(1) - 3) && target[1] <= (sectionK.get(1) + 3)) {
						return true;
					}
				}
				break;
			case "L":
				if (target[0] >= sectionL.get(0) - 2 && target[0] <= sectionL.get(0) + 3) {
					if (target[1] >= (sectionL.get(1) - 3) && target[1] <= (sectionL.get(1) + 3)) {
						return true;
					}
				}
				break;
			}
		}
		return false;
	}
}
