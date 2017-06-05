package com.antwars.termiernator;

import java.util.ArrayList;

public class AntClass {
	
	public AntClass(int ID) {
		this.ID = ID;
	}
	
	//Hierin moet komen welke sectie deze ant verkend.
	public String section;
	
	//basic vars
	public int ID;
	public String vision;
	public String pastVision;
	public String pastMove;
	public String move;
	public String orientation;
	public int food;
	
	//set de missie naar een plek op het veld.
	public int missionLocation[] 	= new int[] {0, 0};
	public String missionType;
	
	public int position[] 			= new int[] {0, 0};
	
	//Set waardes van vision string naar het blokje N van de ant
	public String blokjeN;
	public String blokjeNE;
	public String blokjeE;
	public String blokjeSE;
	public String blokjeS;
	public String blokjeSW;
	public String blokjeW;
	public String blokjeNW;
	
	public String pastBlokjeN;
	public String pastBlokjeNE;
	public String pastBlokjeE;
	public String pastBlokjeSE;
	public String pastBlokjeS;
	public String pastBlokjeSW;
	public String pastBlokjeW;
	public String pastBlokjeNW;
	
 	public String pastBlokje(String direction) {
		
		switch(direction){
		case "N": 	return pastBlokjeN;
		case "NE": 	return pastBlokjeNE;
		case "E": 	return pastBlokjeE;
		case "SE": 	return pastBlokjeSE;
		case "S": 	return pastBlokjeS;
		case "SW": 	return pastBlokjeSW;
		case "W": 	return pastBlokjeW;
		case "NW": 	return pastBlokjeNW;
		default: return"";
		}
	}
	
	public String blokje(String direction){
				
		switch(direction){
		//1ste rij
		case "N": 			return new StringBuilder().append(vision.charAt(34)).append(vision.charAt(35)).toString();
		case "NE": 			return new StringBuilder().append(vision.charAt(36)).append(vision.charAt(37)).toString();
		case "E": 			return new StringBuilder().append(vision.charAt(50)).append(vision.charAt(51)).toString();
		case "SE": 			return new StringBuilder().append(vision.charAt(64)).append(vision.charAt(65)).toString();
		case "S": 			return new StringBuilder().append(vision.charAt(62)).append(vision.charAt(63)).toString();
		case "SW": 			return new StringBuilder().append(vision.charAt(60)).append(vision.charAt(61)).toString();
		case "W": 			return new StringBuilder().append(vision.charAt(46)).append(vision.charAt(47)).toString();
		case "NW": 			return new StringBuilder().append(vision.charAt(32)).append(vision.charAt(33)).toString();
		
		//2de rij
		case "NW-NW": 		return new StringBuilder().append(vision.charAt(16)).append(vision.charAt(17)).toString();
		case "N-NW": 		return new StringBuilder().append(vision.charAt(18)).append(vision.charAt(19)).toString();
		case "N-N": 		return new StringBuilder().append(vision.charAt(20)).append(vision.charAt(21)).toString();
		case "N-NE": 		return new StringBuilder().append(vision.charAt(22)).append(vision.charAt(23)).toString();
		case "NE-NE": 		return new StringBuilder().append(vision.charAt(24)).append(vision.charAt(25)).toString();
		case "E-NE": 		return new StringBuilder().append(vision.charAt(38)).append(vision.charAt(39)).toString();
		case "E-E": 		return new StringBuilder().append(vision.charAt(52)).append(vision.charAt(53)).toString();
		case "E-SE": 		return new StringBuilder().append(vision.charAt(66)).append(vision.charAt(67)).toString();
		case "SE-SE": 		return new StringBuilder().append(vision.charAt(88)).append(vision.charAt(89)).toString();
		case "S-SE": 		return new StringBuilder().append(vision.charAt(78)).append(vision.charAt(79)).toString();
		case "S-S": 		return new StringBuilder().append(vision.charAt(76)).append(vision.charAt(77)).toString();
		case "S-SW": 		return new StringBuilder().append(vision.charAt(74)).append(vision.charAt(75)).toString();
		case "SW-SW": 		return new StringBuilder().append(vision.charAt(72)).append(vision.charAt(73)).toString();
		case "W-SW": 		return new StringBuilder().append(vision.charAt(58)).append(vision.charAt(59)).toString();
		case "W-W": 		return new StringBuilder().append(vision.charAt(44)).append(vision.charAt(45)).toString();
		case "W-NW": 		return new StringBuilder().append(vision.charAt(30)).append(vision.charAt(31)).toString();
		
		//3de rij
		case "NW-NW-NW": 	return new StringBuilder().append(vision.charAt(0)).append(vision.charAt(1)).toString();
		case "N-NW-NW": 	return new StringBuilder().append(vision.charAt(2)).append(vision.charAt(3)).toString();
		case "N-N-NW": 		return new StringBuilder().append(vision.charAt(4)).append(vision.charAt(5)).toString();
		case "N-N-N": 		return new StringBuilder().append(vision.charAt(6)).append(vision.charAt(7)).toString();
		case "N-N-NE": 		return new StringBuilder().append(vision.charAt(8)).append(vision.charAt(9)).toString();
		case "N-NE-NE": 	return new StringBuilder().append(vision.charAt(10)).append(vision.charAt(11)).toString();
		case "NE-NE-NE": 	return new StringBuilder().append(vision.charAt(12)).append(vision.charAt(13)).toString();
		case "E-NE-NE": 	return new StringBuilder().append(vision.charAt(26)).append(vision.charAt(27)).toString();
		case "E-E-NE": 		return new StringBuilder().append(vision.charAt(40)).append(vision.charAt(41)).toString();
		case "E-E-E": 		return new StringBuilder().append(vision.charAt(54)).append(vision.charAt(55)).toString();
		case "E-E-SE": 		return new StringBuilder().append(vision.charAt(68)).append(vision.charAt(67)).toString();
		case "E-SE-SE": 	return new StringBuilder().append(vision.charAt(82)).append(vision.charAt(83)).toString();
		case "SE-SE-SE": 	return new StringBuilder().append(vision.charAt(96)).append(vision.charAt(97)).toString();
		case "S-SE-SE": 	return new StringBuilder().append(vision.charAt(94)).append(vision.charAt(95)).toString();
		case "S-S-SE": 		return new StringBuilder().append(vision.charAt(92)).append(vision.charAt(93)).toString();
		case "S-S-S": 		return new StringBuilder().append(vision.charAt(90)).append(vision.charAt(91)).toString();
		case "S-S-SW": 		return new StringBuilder().append(vision.charAt(88)).append(vision.charAt(89)).toString();
		case "S-SW-SW": 	return new StringBuilder().append(vision.charAt(86)).append(vision.charAt(87)).toString();
		case "SW-SW-SW": 	return new StringBuilder().append(vision.charAt(84)).append(vision.charAt(85)).toString();
		case "W-SW-SW": 	return new StringBuilder().append(vision.charAt(70)).append(vision.charAt(71)).toString();
		case "W-W-SW": 		return new StringBuilder().append(vision.charAt(56)).append(vision.charAt(57)).toString();
		case "W-W-W": 		return new StringBuilder().append(vision.charAt(42)).append(vision.charAt(43)).toString();
		case "W-W-NW": 		return new StringBuilder().append(vision.charAt(28)).append(vision.charAt(29)).toString();
		case "W-NW-NW": 	return new StringBuilder().append(vision.charAt(14)).append(vision.charAt(15)).toString();
		default: return"";
		}
	}
	
	public void setPastBlokjes() {
		if (vision != null) {
			pastBlokjeN 	= blokje("N");
			pastBlokjeNE 	= blokje("NE");
			pastBlokjeE 	= blokje("E");
			pastBlokjeSE 	= blokje("SE");
			pastBlokjeS 	= blokje("S");
			pastBlokjeSW 	= blokje("SW");
			pastBlokjeW 	= blokje("W");
			pastBlokjeNW 	= blokje("NW");
		}
	}
	
	public int[] setPosition(String direction){
		int returnMove[] = new int[] {0, 0};
		
		switch(direction){
			case "N": 	returnMove[0] = (position[0] - 1); 
						returnMove[1] = position[1];	
						return returnMove;
			case "NE": 	returnMove[0] = (position[0] - 1);
						returnMove[1] = (position[1] + 1);
						return returnMove;
			case "E": 	returnMove[0] = position[0];
						returnMove[1] = (position[1] + 1);
						return returnMove;
			case "SE": 	returnMove[0] = (position[0] + 1);
						returnMove[1] = (position[1] + 1);
						return returnMove; 
			case "S": 	returnMove[0] = (position[0] + 1);
						returnMove[1] = position[1];
						return returnMove;
			case "SW": 	returnMove[0] = (position[0] + 1);
						returnMove[1] = (position[1] - 1);
						return returnMove; 
			case "W": 	returnMove[0] = position[0];
						returnMove[1] = (position[1] - 1);
						return returnMove; 
			case "NW": 	returnMove[0] = (position[0] - 1);
						returnMove[1] = (position[1] - 1);
						return returnMove; 
			default: 	return returnMove;
		}
	}

	public int[] checkFutureMoves(String direction) {
		//wil echte waarde niet aanpassen dus save de blokjes in andere vars.
		
		int xx[] = new int[] {0, 0};

		if (orientation != null) {
			switch (direction) {
			
			//rank 1
			case "N":
				if (orientation.equals("N")) {
					xx[0] = (position[0] - 1);
					xx[1] = position[1];
					return xx;
				} else {
					return position;
				}
			case "NE":
				if (orientation.equals("NE")) {
					xx[0] = (position[0] - 1);
					xx[1] = (position[1] + 1);
					return xx;
				} else {
					return position;
				}
			case "E":
				if (orientation.equals("E")) {
					xx[0] = position[0];
					xx[1] = (position[1] + 1);
					return xx;
				} else {
					return position;
				}
			case "SE":
				if (orientation.equals("SE")) {
					xx[0] = (position[0] + 1);
					xx[1] = (position[1] + 1);
					return xx;
				} else {
					return position;
				}
			case "S":
				if (orientation.equals("S")) {
					xx[0] = (position[0] + 1);
					xx[1] = position[1];
					return xx;
				} else {
					return position;
				}
			case "SW":
				if (orientation.equals("SW")) {
					xx[0] = (position[0] + 1);
					xx[1] = (position[1] - 1);
					return xx;
				} else {
					return position;
				}
			case "W":
				if (orientation.equals("W")) {
					xx[0] = position[0];
					xx[1] = (position[1] - 1);
					return xx;
				} else {
					return position;
				}
			case "NW":
				if (orientation.equals("NW")) {
					xx[0] = (position[0] - 1);
					xx[1] = (position[1] - 1);
					return xx;
				} else {
					return position;
				}
			default:
				return xx;
			}
		}
		return null;
	}

	public int[] checkTilePosition(String direction) {
		int xx[] = new int[] { 0, 0 };

		if (orientation != null) {
			switch (direction) {

			// rank 1
			case "N":
				xx[0] = (position[0] - 1);
				xx[1] = position[1];
				return xx;

			case "NE":
				xx[0] = (position[0] - 1);
				xx[1] = (position[1] + 1);
				return xx;

			case "E":
				xx[0] = position[0];
				xx[1] = (position[1] + 1);
				return xx;

			case "SE":
				xx[0] = (position[0] + 1);
				xx[1] = (position[1] + 1);
				return xx;
				

			case "S":
				xx[0] = (position[0] + 1);
				xx[1] = position[1];
				return xx;

			case "SW":
				xx[0] = (position[0] + 1);
				xx[1] = (position[1] - 1);
				return xx;

			case "W":
				xx[0] = position[0];
				xx[1] = (position[1] - 1);
				return xx;

			case "NW":
				xx[0] = (position[0] - 1);
				xx[1] = (position[1] - 1);
				return xx;

			// ------------------------------------------------rank 2
			case "NW-NW":
				xx[0] = (position[0] - 2);
				xx[1] = (position[1] - 2);
				return xx;

			case "N-NW":
				xx[0] = (position[0] - 2);
				xx[1] = (position[1] - 1);
				return xx;

			case "N-N":
				xx[0] = (position[0] - 2);
				return xx;

			case "N-NE":
				xx[0] = (position[0] - 2);
				xx[1] = (position[1] + 1);
				return xx;

			case "NE-NE":
				xx[0] = (position[0] - 2);
				xx[1] = (position[1] + 2);
				return xx;

			case "E-NE":
				xx[0] = (position[0] - 1);
				xx[1] = (position[1] + 2);
				return xx;

			case "E-E":
				xx[0] = (position[0] - 0);
				xx[1] = (position[1] - 2);
				return xx;

			case "E-SE":
				xx[0] = (position[0] + 1);
				xx[1] = (position[1] + 2);
				return xx;

			case "SE-SE":
				xx[0] = (position[0] + 2);
				xx[1] = (position[1] + 2);
				return xx;

			case "S-SE":
				xx[0] = (position[0] + 2);
				xx[1] = (position[1] + 1);
				return xx;

			case "S-S":
				xx[0] = (position[0] + 2);
				xx[1] = (position[1] - 0);
				return xx;

			case "S-SW":
				xx[0] = (position[0] + 2);
				xx[1] = (position[1] - 1);
				return xx;

			case "SW-SW":
				xx[0] = (position[0] + 2);
				xx[1] = (position[1] - 2);
				return xx;

			case "W-SW":
				xx[0] = (position[0] + 1);
				xx[1] = (position[1] - 2);
				return xx;

			case "W-W":
				xx[0] = (position[0] - 0);
				xx[1] = (position[1] - 2);
				return xx;

			case "W-NW":
				xx[0] = (position[0] - 1);
				xx[1] = (position[1] - 2);
				return xx;

			// rank 3
			case "NW-NW-NW":
				xx[0] = (position[0] - 3);
				xx[1] = (position[1] - 3);
				return xx;

			case "N-NW-NW":
				xx[0] = (position[0] - 3);
				xx[1] = (position[1] - 2);
				return xx;

			case "N-N-NW":
				xx[0] = (position[0] - 3);
				xx[1] = (position[1] - 1);
				return xx;

			case "N-N-N":
				xx[0] = (position[0] - 3);
				xx[1] = (position[1] - 0);
				return xx;

			case "N-N-NE":
				xx[0] = (position[0] - 3);
				xx[1] = (position[1] + 1);
				return xx;

			case "N-NE-NE":
				xx[0] = (position[0] - 3);
				xx[1] = (position[1] + 2);
				return xx;

			case "NE-NE-NE":
				xx[0] = (position[0] - 3);
				xx[1] = (position[1] + 3);
				return xx;

			case "E-NE-NE":
				xx[0] = (position[0] - 2);
				xx[1] = (position[1] + 3);
				return xx;

			case "E-E-NE":
				xx[0] = (position[0] - 1);
				xx[1] = (position[1] + 3);
				return xx;

			case "E-E-E":
				xx[0] = (position[0] - 0);
				xx[1] = (position[1] + 3);
				return xx;

			case "E-E-SE":
				xx[0] = (position[0] + 1);
				xx[1] = (position[1] + 3);
				return xx;

			case "E-SE-SE":
				xx[0] = (position[0] + 2);
				xx[1] = (position[1] + 3);
				return xx;

			case "SE-SE-SE":
				xx[0] = (position[0] + 3);
				xx[1] = (position[1] + 3);
				return xx;

			case "S-SE-SE":
				xx[0] = (position[0] + 3);
				xx[1] = (position[1] + 2);
				return xx;

			case "S-S-SE":
				xx[0] = (position[0] + 3);
				xx[1] = (position[1] + 1);
				return xx;

			case "S-S-S":
				xx[0] = (position[0] + 3);
				xx[1] = (position[1] - 0);
				return xx;

			case "S-S-SW":
				xx[0] = (position[0] + 3);
				xx[1] = (position[1] - 1);
				return xx;

			case "S-SW-SW":
				xx[0] = (position[0] + 3);
				xx[1] = (position[1] - 2);
				return xx;

			case "SW-SW-SW":
				xx[0] = (position[0] + 3);
				xx[1] = (position[1] - 3);
				return xx;

			case "W-SW-SW":
				xx[0] = (position[0] + 2);
				xx[1] = (position[1] - 3);
				return xx;

			case "W-W-SW":
				xx[0] = (position[0] + 1);
				xx[1] = (position[1] - 3);
				return xx;

			case "W-W-W":
				xx[0] = (position[0] - 0);
				xx[1] = (position[1] - 3);
				return xx;

			case "W-W-NW":
				xx[0] = (position[0] - 1);
				xx[1] = (position[1] - 3);
				return xx;

			case "W-NW-NW":
				xx[0] = (position[0] - 2);
				xx[1] = (position[1] - 3);
				return xx;

			default:
			}
		}
		return xx;

	}
	
	public ArrayList<int[]> checkForFood() {
		ArrayList<int[]> returnXX = new ArrayList<int[]>();
		
		
		for (int i = 0; i < MainClass.completeVision.size(); i++) {
			if (blokje(MainClass.completeVision.get(i)).equals(MainClass.foodOnLand)) {
				if (orientation != null) {
					//System.out.println("hij zoekt op: " + MainClass.completeVision.get(i));
					int xx[] = new int[] {0, 0};
					switch (MainClass.completeVision.get(i)) {
					
					//rank 1
					case "N":
						
							xx[0] = (position[0] - 1);
							xx[1] = position[1];
							returnXX.add(xx);
							break;
		
					case "NE":
							xx[0] = (position[0] - 1);
							xx[1] = (position[1] + 1);
							returnXX.add(xx);
							break;
		
					case "E":
							xx[0] = position[0];
							xx[1] = (position[1] + 1);
							returnXX.add(xx);
							break;
		
					case "SE":
							xx[0] = (position[0] + 1);
							xx[1] = (position[1] + 1);
							returnXX.add(xx);
							break;
		
					case "S":
							xx[0] = (position[0] + 1);
							xx[1] = position[1];
							returnXX.add(xx);
							break;
		
					case "SW":
							xx[0] = (position[0] + 1);
							xx[1] = (position[1] - 1);
							returnXX.add(xx);
							break;
		
					case "W":
							xx[0] = position[0];
							xx[1] = (position[1] - 1);
							returnXX.add(xx);
							break;
		
					case "NW":
							xx[0] = (position[0] - 1);
							xx[1] = (position[1] - 1);
							returnXX.add(xx);
							break;
		
						
						//------------------------------------------------rank 2
					case "NW-NW":
							xx[0] = (position[0] - 2);
							xx[1] = (position[1] - 2);
							returnXX.add(xx);
							break;
		
					case "N-NW":
							xx[0] = (position[0] - 2);
							xx[1] = (position[1] - 1);
							returnXX.add(xx);
							break;
		
					case "N-N":
							xx[0] = (position[0] - 2);
							returnXX.add(xx);
							break;
		
					case "N-NE":
							xx[0] = (position[0] - 2);
							xx[1] = (position[1] + 1);
							returnXX.add(xx);
							break;
		
					case "NE-NE":
							xx[0] = (position[0] - 2);
							xx[1] = (position[1] + 2);
							returnXX.add(xx);
							break;
		
						
					case "E-NE":
							xx[0] = (position[0] - 1);
							xx[1] = (position[1] + 2);
							returnXX.add(xx);
							break;
		
					case "E-E":
							xx[0] = (position[0] - 0);
							xx[1] = (position[1] - 2);
							returnXX.add(xx);
							break;
		
					case "E-SE":
							xx[0] = (position[0] + 1);
							xx[1] = (position[1] + 2);
							returnXX.add(xx);
							break;
		
					case "SE-SE":
							xx[0] = (position[0] + 2);
							xx[1] = (position[1] + 2);
							returnXX.add(xx);
							break;
		
					case "S-SE":
							xx[0] = (position[0] + 2);
							xx[1] = (position[1] + 1);
							returnXX.add(xx);
							break;
		
					case "S-S":
							xx[0] = (position[0] + 2);
							xx[1] = (position[1] - 0);
							returnXX.add(xx);
							break;
		
					case "S-SW":
							xx[0] = (position[0] + 2);
							xx[1] = (position[1] - 1);
							returnXX.add(xx);
							break;
		
					case "SW-SW":
							xx[0] = (position[0] + 2);
							xx[1] = (position[1] - 2);
							returnXX.add(xx);
							break;
		
					case "W-SW":
							xx[0] = (position[0] + 1);
							xx[1] = (position[1] - 2);
							returnXX.add(xx);
							break;
		
					case "W-W":
							xx[0] = (position[0] - 0);
							xx[1] = (position[1] - 2);
							returnXX.add(xx);
							break;
		
					case "W-NW":
							xx[0] = (position[0] - 1);
							xx[1] = (position[1] - 2);
							returnXX.add(xx);
							break;
						
						//rank 3
					case "NW-NW-NW":
							xx[0] = (position[0] - 3);
							xx[1] = (position[1] - 3);
							returnXX.add(xx);
							break;
		
					case "N-NW-NW":
							xx[0] = (position[0] - 3);
							xx[1] = (position[1] - 2);
							returnXX.add(xx);
							break;
			
					case "N-N-NW":
							xx[0] = (position[0] - 3);
							xx[1] = (position[1] - 1);
							returnXX.add(xx);
							break;
		
					case "N-N-N":
							xx[0] = (position[0] - 3);
							xx[1] = (position[1] - 0);
							returnXX.add(xx);
							break;
				
					case "N-N-NE":
							xx[0] = (position[0] - 3);
							xx[1] = (position[1] + 1);
							returnXX.add(xx);
							break;
		
					case "N-NE-NE":
							xx[0] = (position[0] - 3);
							xx[1] = (position[1] + 2);
							returnXX.add(xx);
							break;
			
					case "NE-NE-NE":
							xx[0] = (position[0] - 3);
							xx[1] = (position[1] + 3);
							returnXX.add(xx);
							break;
		
					case "E-NE-NE":
							xx[0] = (position[0] - 2);
							xx[1] = (position[1] + 3);
							returnXX.add(xx);
							break;
			
					case "E-E-NE":
							xx[0] = (position[0] - 1);
							xx[1] = (position[1] + 3);
							returnXX.add(xx);
							break;
			
					case "E-E-E":
							xx[0] = (position[0] - 0);
							xx[1] = (position[1] + 3);
							returnXX.add(xx);
							break;
			
					case "E-E-SE":
							xx[0] = (position[0] + 1);
							xx[1] = (position[1] + 3);
							returnXX.add(xx);
							break;
			
					case "E-SE-SE":
							xx[0] = (position[0] + 2);
							xx[1] = (position[1] + 3);
							returnXX.add(xx);
							break;
			
					case "SE-SE-SE":
							xx[0] = (position[0] + 3);
							xx[1] = (position[1] + 3);
							returnXX.add(xx);
							break;
		
					case "S-SE-SE":
							xx[0] = (position[0] + 3);
							xx[1] = (position[1] + 2);
							returnXX.add(xx);
							break;
				
					case "S-S-SE":
							xx[0] = (position[0] + 3);
							xx[1] = (position[1] + 1);
							returnXX.add(xx);
							break;
				
					case "S-S-S":
							xx[0] = (position[0] + 3);
							xx[1] = (position[1] - 0);
							returnXX.add(xx);
							break;
						
					case "S-S-SW":
							xx[0] = (position[0] + 3);
							xx[1] = (position[1] - 1);
							returnXX.add(xx);
							break;
					
					case "S-SW-SW":
							xx[0] = (position[0] + 3);
							xx[1] = (position[1] - 2);
							returnXX.add(xx);
							break;
						
					case "SW-SW-SW":
							xx[0] = (position[0] + 3);
							xx[1] = (position[1] - 3);
							returnXX.add(xx);
							break;
					
					case "W-SW-SW":
							xx[0] = (position[0] + 2);
							xx[1] = (position[1] - 3);
							returnXX.add(xx);
							break;
						
					case "W-W-SW":
							xx[0] = (position[0] + 1);
							xx[1] = (position[1] - 3);
							returnXX.add(xx);
							break;
					
					case "W-W-W":
							xx[0] = (position[0] - 0);
							xx[1] = (position[1] - 3);
							returnXX.add(xx);
							break;
						
					case "W-W-NW":
							xx[0] = (position[0] - 1);
							xx[1] = (position[1] - 3);
							returnXX.add(xx);
							break;
						
					case "W-NW-NW":
							xx[0] = (position[0] - 2);
							xx[1] = (position[1] - 3);
							returnXX.add(xx);
							break;
		
					default:
					}
				}
			}
		}
		
		for (int y = 0; y < returnXX.size(); y++) {
			//System.out.println("return test " + returnXX.get(y)[0] + " " + returnXX.get(y)[1]);
		}
		
		return returnXX;
	}

}