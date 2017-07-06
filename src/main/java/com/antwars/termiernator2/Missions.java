package com.antwars.termiernator2;

public class Missions {
	
	
	
	//Deze method set de missies afhankelijk naar de stage van het spel.
	public static void setMission(AntClass ant) {
		if (MainClass.ants.size() < 3) {
			Missions.phase1(ant);
		}

		if (MainClass.ants.size() > 2) {
			Missions.assignSection(ant);
		}
	}	
	
	//Doorlink method. deze worden aangeroepen van de Client class
	public static void phase1(AntClass ant){
		scout(ant);
	}
	
	
	public static void assignSection(AntClass ant){
		//berekend welke sectie hij moet meegeven. In de aangeroepen methode assigned hij de missie.
		
		if (ant.section != null) {
			switch(ant.section) {
			case "A":
				System.out.println("hij assigned section A");
				
				ant.missionLocation[0] = Section.sectionA.get(0);
				ant.missionLocation[1] = Section.sectionA.get(1);
				ant.missionType="moveToSection";
				ant.section = "A";
				return;
			case "B":
				ant.missionLocation[0] = Section.sectionB.get(0);
				ant.missionLocation[1] = Section.sectionB.get(1);
				ant.missionType="moveToSection";
				ant.section = "B";
				return;
			case "C":
				ant.missionLocation[0] = Section.sectionC.get(0);
				ant.missionLocation[1] = Section.sectionC.get(1);
				ant.missionType="moveToSection";
				ant.section = "C";
				return;
			case "D":
				ant.missionLocation[0] = Section.sectionD.get(0);
				ant.missionLocation[1] = Section.sectionD.get(1);
				ant.missionType="moveToSection";
				ant.section = "D";
				return;
			case "E":
				ant.missionLocation[0] = Section.sectionE.get(0);
				ant.missionLocation[1] = Section.sectionE.get(1);
				ant.missionType="moveToSection";
				ant.section = "E";
				return;
			case "F":
				ant.missionLocation[0] = Section.sectionF.get(0);
				ant.missionLocation[1] = Section.sectionF.get(1);
				ant.missionType = "moveToSection";
				ant.section = "F";
				return;
			case "G":
				ant.missionLocation[0] = Section.sectionG.get(0);
				ant.missionLocation[1] = Section.sectionG.get(1);
				ant.missionType="moveToSection";
				ant.section = "G";
				return;
			case "H":
				ant.missionLocation[0] = Section.sectionH.get(0);
				ant.missionLocation[1] = Section.sectionH.get(1);
				ant.missionType="moveToSection";
				ant.section = "H";
				return;
			case "I":
				ant.missionLocation[0] = Section.sectionI.get(0);
				ant.missionLocation[1] = Section.sectionI.get(1);
				ant.missionType="moveToSection";
				ant.section = "I";
				return;
			case "J":
				ant.missionLocation[0] = Section.sectionJ.get(0);
				ant.missionLocation[1] = Section.sectionJ.get(1);
				ant.missionType="moveToSection";
				ant.section = "J";
				return;
			case "K":
				ant.missionLocation[0] = Section.sectionK.get(0);
				ant.missionLocation[1] = Section.sectionK.get(1);
				ant.missionType="moveToSection";
				ant.section = "K";
				return;
			case "L":
				ant.missionLocation[0] = Section.sectionL.get(0);
				ant.missionLocation[1] = Section.sectionL.get(1);
				ant.missionType="moveToSection";
				ant.section = "L";
				return;
			case "FULL":
				ant.missionLocation[0] = Section.sectionL.get(0);
				ant.missionLocation[1] = Section.sectionL.get(1);
				ant.missionType="moveToSection";
				ant.section = "L";
				return;
			}
		}
		
		System.out.println("hij assigned random section");
		goToSectionPhase2(ant, Section.getNextSection());
	}
	
	
	//Kijkt welke missie de ant heeft en zet nieuwe als nodig is.
	public static String followMission(AntClass ant) {
		System.out.println("In FollowMission method. Mission = \"" + ant.missionType + "\" op locatie: "
				+ ant.missionLocation[0] + " " + ant.missionLocation[1]);

		if (Movement.isAtLocation(ant) == false) {
			System.out.println("Ant not at location, Move to location");
			if (ant.missionType.equals("scoutNW") | ant.missionType.equals("scoutNE")) {
				MainClass.searchForFood(ant);
				return Movement.moveToLocation(ant);
			}
			return Movement.moveToLocation(ant);
		}
		
		

		// set Nieuwe Mission
		if (Movement.isAtLocation(ant) == true) {
			System.out.println("Ant op MISSION LOCATIE");

			switch (ant.missionType) {
			case "return":				
				if (ant.section == null) {
					if (Movement.transferFood(ant).equals("T")) {
						Missions.setMission(ant);
						return "T";
					}
					else if (!Movement.transferFood(ant).equals("")) {
					return Movement.transferFood(ant);
					}
				}
				
				if (ant.section != null) {
					if (ant.section.equals("F")) {
						if (Movement.transferFood(ant).equals("T")) {
							Missions.setMission(ant);
							return "T";
						} else {
							return Movement.transferFood(ant);
						}
					}
				}

				System.out.println("missie was return");
				if (ant.section != null) {
					System.out.println("section != null");
					if (antAtBorderOfSection(ant) == true) {
						System.out.println("hij is at border, toss eten");
						Missions.setMission(ant);
						return "T";
					} else {
						return Movement.moveToLocation(ant);
					}
				}
				break;

			case "moveOut":
				System.out.println("missie was moveOut");
				if (ant.food > 250) {
					ant.missionLocation[0] = 0;
					ant.missionLocation[1] = 0;
					ant.missionType = "return";
					return Movement.moveToLocation(ant);
				}
				if (MainClass.searchForFood(ant) == true) {
					return Movement.moveToLocation(ant);
				} else {
					if (Movement.canWalk(ant) == true) {
						return "M";
					}
				}
				break;

			case "getFood":
				System.out.println("missie was getFood");
				setReturnLocation(ant);
				System.out.println("Returnlocation = nu: " + ant.missionLocation[0] + " " + ant.missionLocation[1]);
				ant.missionType = "return";
				return "H";
				
			case "scoutNW":
				System.out.println("missie was scoutNW");
				ant.missionLocation[0] = 0;
				ant.missionLocation[1] = 0;
				ant.missionType = "return";
				MainClass.searchForFood(ant);
				break;
				
			case "scoutNE":
				System.out.println("missie was scoutNE");
				ant.missionLocation[0] = 0;
				ant.missionLocation[1] = 0;
				ant.missionType = "return";
				MainClass.searchForFood(ant);
				break;
				
			case "moveToSection":
				System.out.println("missie was moveToSection");
				ant.missionType = "waitForOrders";
				return Missions.followMission(ant);
				
			case "waitForOrders":
				System.out.println("missie was waitForOrders");
				if (MainClass.searchForFood(ant) == true) {
					return Missions.followMission(ant);
				} else {
					return Movement.moveToLocation(ant);
				}
			}
		}
		System.out.println("hij returned followMission end of method M");
		return "M";
	}
	
	
	//Phase 1
	public static void scout(AntClass ant) {
		
		//ant 1 gaat links
		if (ant.ID == 1) {
			if (MainClass.searchForFood(ant) == false) {
				//scout NW
				ant.missionType = "scoutNW";
				ant.missionLocation[0] = -20;
				ant.missionLocation[1] = -20;
			} else {
				System.out.println("searchForFood = true");
			}
		}
		
		if (ant.ID == 2) {
			if (MainClass.searchForFood(ant) == false) {
				//scout SE
				ant.missionType = "scoutNE";
				ant.missionLocation[0] = -20;
				ant.missionLocation[1] = +20;
			} else {
				System.out.println("searchForFood = true");
			}
		}
	}
	
	//Phase 2
	public static void goToSectionPhase2(AntClass ant, String section) {
		//System.out.println("TESETEST " + section);
		
		
		switch(section) {
		case "A":
			ant.missionLocation[0] = Section.sectionA.get(0);
			ant.missionLocation[1] = Section.sectionA.get(1);
			ant.missionType="moveToSection";
			ant.section = "A";
			break;
		case "B":
			ant.missionLocation[0] = Section.sectionB.get(0);
			ant.missionLocation[1] = Section.sectionB.get(1);
			ant.missionType="moveToSection";
			ant.section = "B";
			break;
		case "C":
			ant.missionLocation[0] = Section.sectionC.get(0);
			ant.missionLocation[1] = Section.sectionC.get(1);
			ant.missionType="moveToSection";
			ant.section = "C";
			break;
		case "D":
			ant.missionLocation[0] = Section.sectionD.get(0);
			ant.missionLocation[1] = Section.sectionD.get(1);
			ant.missionType="moveToSection";
			ant.section = "D";
			break;
		case "E":
			ant.missionLocation[0] = Section.sectionE.get(0);
			ant.missionLocation[1] = Section.sectionE.get(1);
			ant.missionType="moveToSection";
			ant.section = "E";
			break;
		case "F":
			ant.missionLocation[0] = Section.sectionF.get(0);
			ant.missionLocation[1] = Section.sectionF.get(1);
			ant.missionType = "moveToSection";
			ant.section = "F";
			break;
		case "G":
			ant.missionLocation[0] = Section.sectionG.get(0);
			ant.missionLocation[1] = Section.sectionG.get(1);
			ant.missionType="moveToSection";
			ant.section = "G";
			break;
		case "H":
			ant.missionLocation[0] = Section.sectionH.get(0);
			ant.missionLocation[1] = Section.sectionH.get(1);
			ant.missionType="moveToSection";
			ant.section = "H";
			break;
		case "I":
			ant.missionLocation[0] = Section.sectionI.get(0);
			ant.missionLocation[1] = Section.sectionI.get(1);
			ant.missionType="moveToSection";
			ant.section = "I";
			break;
		case "J":
			ant.missionLocation[0] = Section.sectionJ.get(0);
			ant.missionLocation[1] = Section.sectionJ.get(1);
			ant.missionType="moveToSection";
			ant.section = "J";
			break;
		case "K":
			ant.missionLocation[0] = Section.sectionK.get(0);
			ant.missionLocation[1] = Section.sectionK.get(1);
			ant.missionType="moveToSection";
			ant.section = "K";
			break;
		case "L":
			ant.missionLocation[0] = Section.sectionL.get(0);
			ant.missionLocation[1] = Section.sectionL.get(1);
			ant.missionType="moveToSection";
			ant.section = "L";
			break;
		case "FULL":
			ant.missionLocation[0] = Section.sectionL.get(0);
			ant.missionLocation[1] = Section.sectionL.get(1);
			ant.missionType="moveToSection";
			ant.section = "L";
			break;
		}
		
		
	}
	
	public static void setReturnLocation(AntClass ant) {
		
		if (ant.section != null) {
		switch(ant.section) {
		case "A":
			//int xx0 = (int)Section.sectionA[0];
			//int xx1 = (int)Section.sectionA[1];
			
			System.out.println("sectionA = " + Section.sectionA.get(0) + " " + Section.sectionA.get(1));
			ant.missionLocation[0] = Section.sectionA.get(0) + 2;
			ant.missionLocation[1] = Section.sectionA.get(1) + 3;
			break;
		case "B":
			ant.missionLocation[0] = Section.sectionB.get(0) + 2;
			ant.missionLocation[1] = Section.sectionB.get(1) + 2;
			break;
		case "C":
			ant.missionLocation[0] = Section.sectionC.get(0) + 2;
			ant.missionLocation[1] = Section.sectionC.get(1) - 2;
			break;
		case "D":
			ant.missionLocation[0] = Section.sectionD.get(0) + 2;
			ant.missionLocation[1] = Section.sectionD.get(1) - 3;
			break;
		case "E":
			ant.missionLocation[0] = Section.sectionE.get(0);
			ant.missionLocation[1] = Section.sectionE.get(1) + 2;
			break;
		case "F":
			ant.missionLocation[0] = 0;
			ant.missionLocation[1] = 0;
			break;
		case "G":
			ant.missionLocation[0] = Section.sectionG.get(0);
			ant.missionLocation[1] = Section.sectionG.get(1) - 2;
			break;
		case "H":
			ant.missionLocation[0] = Section.sectionH.get(0);
			ant.missionLocation[1] = Section.sectionH.get(1) - 3;
			break;
		case "I":
			ant.missionLocation[0] = Section.sectionI.get(0) - 2;
			ant.missionLocation[1] = Section.sectionI.get(1) + 1;
			break;
		case "J":
			ant.missionLocation[0] = Section.sectionJ.get(0) - 2;
			ant.missionLocation[1] = Section.sectionJ.get(1) + 2;
			break;
		case "K":
			ant.missionLocation[0] = Section.sectionK.get(0) - 3;
			ant.missionLocation[1] = Section.sectionK.get(1) - 3;
			break;
		case "L":
			ant.missionLocation[0] = Section.sectionL.get(0) - 2;
			ant.missionLocation[1] = Section.sectionL.get(1) - 3;
			break;
		}
		} else {
			ant.missionLocation[0] = 0;
			ant.missionLocation[1] = 0;
			
		}
		
		
	}

	public static boolean antAtBorderOfSection(AntClass ant) {
		
		switch(ant.section) {
		case "A":
			System.out.println("sectionA = " + Section.sectionA.get(0) + " " + Section.sectionA.get(0));
			System.out.println("border targets zijn: [0] = " + (Section.sectionA.get(0) + 2) + " [1] = " + (Section.sectionA.get(1) + 2) + " of " + (Section.sectionA.get(1) + 3));
			if (ant.position[0] == (Section.sectionA.get(0) + 2)) {
				if (ant.position[1] == (Section.sectionA.get(1) + 2) || ant.position[1] == (Section.sectionA.get(1) + 3)) {
					return true;
				}
			}
			break;
		case "B":
			if (ant.position[0] == Section.sectionB.get(0) + 2) {
				if (ant.position[1] == Section.sectionB.get(1) + 1 || ant.position[1] == Section.sectionB.get(1) + 2 || ant.position[1] == Section.sectionB.get(1) + 1) {
					return true;
				}
			}
			break;
		case "C":
			if (ant.position[0] == Section.sectionC.get(0) + 2) {
				if (ant.position[1] == Section.sectionC.get(1) || ant.position[1] == Section.sectionC.get(1) - 1 || 
						ant.position[1] == Section.sectionC.get(1) - 2 || ant.position[1] == Section.sectionC.get(1) - 3) {
					return true;
				}
			}
			break;
		case "D":
			if (ant.position[0] == Section.sectionD.get(0) + 2) {
				if (ant.position[1] == Section.sectionD.get(1) || ant.position[1] == Section.sectionD.get(1) - 1 || 
						ant.position[1] == Section.sectionD.get(1) - 2 || ant.position[1] == Section.sectionD.get(1) - 3) {
					return true;
				}
			}
			break;
		case "E":
			if (ant.position[0] == Section.sectionE.get(0) || ant.position[0] == Section.sectionE.get(0) - 1 || ant.position[0] == Section.sectionE.get(0) + 1) {
				if (ant.position[1] == Section.sectionE.get(1) + 2) {
					return true;
				}
			}
			break;
		case "F":
			
			Movement.transferFood(ant);
			break;
		case "G":
			if (ant.position[0] == Section.sectionG.get(0) || ant.position[0] == Section.sectionG.get(0) - 1 || ant.position[0] == Section.sectionG.get(0) + 1) {
				if (ant.position[1] == Section.sectionG.get(1) - 2) {
					return true;
				}
			}
			break;
		case "H":
			if (ant.position[0] == Section.sectionH.get(0) || ant.position[0] == Section.sectionH.get(0) - 1 || ant.position[0] == Section.sectionH.get(0) + 1) {
				if (ant.position[1] == Section.sectionH.get(1) - 2) {
					return true;
				}
			}
			break;
		case "I":
			if (ant.position[0] == Section.sectionI.get(0) - 2) {
				if (ant.position[1] == Section.sectionI.get(1) + 1 || ant.position[1] == Section.sectionI.get(1) + 2 || ant.position[1] == Section.sectionI.get(1) + 1) {
					return true;
				}
			}
			break;
		case "J":
			if (ant.position[0] == Section.sectionJ.get(0) - 2) {
				if (ant.position[1] == Section.sectionJ.get(1) + 1 || ant.position[1] == Section.sectionJ.get(1) + 2 || ant.position[1] == Section.sectionJ.get(1) + 1) {
					return true;
				}
			}
			break;
		case "K":
			if (ant.position[0] == Section.sectionK.get(0) - 2) {
				if (ant.position[1] == Section.sectionK.get(1) - 1 || ant.position[1] == Section.sectionK.get(1) - 2 || ant.position[1] == Section.sectionK.get(1) - 1) {
					return true;
				}
			}
			break;
		case "L":
			if (ant.position[0] == Section.sectionL.get(0) - 2) {
				if (ant.position[1] == Section.sectionL.get(1) + 1 || ant.position[1] == Section.sectionL.get(1) + 2 || ant.position[1] == Section.sectionL.get(1) + 1) {
					return true;
				}
			}
			break;
		}
		
		return false;
	}
	
}
