package com.antwars.termiernator2;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.entity.StringEntity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class MainClass {
	
	// deze array is de unit array die deze beurt is terug gekomen.
	static JsonArray unitArray;

	// in deze array worden alle ants gestopt die zijn aangemaakt.
	public static ArrayList<AntClass> ants = new ArrayList<AntClass>();

	static String water = "~~";
	static String land = "..";
	static String foodOnLand = "#.";
	static String foodOnWater = "#~";
	static String allyAnt = "a1";
	static String enemyAnt = "a2";
	static String allyHill = "h1";
	static String allyHill2 = "H1";
	static String enemyHill = "h3";
	static String allyAntOnSomething = "A1";
	static String enemyAntOnSomething = "A2";

	static int turn;

	//iedere keer als ant wordt aangemaakt gaat deze 1 omhoog.
	static int antID = 0;

	static ArrayList<String> directions = new ArrayList<String>();

	static ArrayList<String> completeVision = new ArrayList<String>();

	//eerste functie die word aangeroepen van de Client. Deze set in begin alle arrays, maakt ants aan, of haalt ze weg, etc.
	public static StringEntity setData() throws UnsupportedEncodingException {
		// zet alle richtingen in directions array. om te kunnen loopen.
		if (directions.size() == 0) {
			directions.add("N");
			directions.add("NE");
			directions.add("E");
			directions.add("SE");
			directions.add("S");
			directions.add("SW");
			directions.add("W");
			directions.add("NW");
			
			Section.sections.add("A");
			Section.sections.add("B");
			Section.sections.add("C");
			Section.sections.add("D");
			Section.sections.add("E");
			Section.sections.add("F");
			Section.sections.add("G");
			Section.sections.add("H");
			Section.sections.add("I");
			Section.sections.add("J");
			Section.sections.add("K");
			Section.sections.add("L");

			// rank 1
			completeVision.add("NW");
			completeVision.add("N");
			completeVision.add("NE");
			completeVision.add("E");
			completeVision.add("SE");
			completeVision.add("S");
			completeVision.add("SW");
			completeVision.add("W");

			// rank 2
			completeVision.add("NW-NW");
			completeVision.add("N-NW");
			completeVision.add("N-N");
			completeVision.add("N-NE");
			completeVision.add("NE-NE");
			completeVision.add("E-NE");
			completeVision.add("E-E");
			completeVision.add("E-SE");
			completeVision.add("SE-SE");
			completeVision.add("S-SE");
			completeVision.add("S-S");
			completeVision.add("S-SW");
			completeVision.add("SW-SW");
			completeVision.add("W-SW");
			completeVision.add("W-W");
			completeVision.add("W-NW");

			// rank 3
			completeVision.add("NW-NW-NW");
			completeVision.add("N-NW-NW");
			completeVision.add("N-N-NW");
			completeVision.add("N-N-N");
			completeVision.add("N-N-NE");
			completeVision.add("N-NE-NE");
			completeVision.add("NE-NE-NE");
			completeVision.add("E-NE-NE");
			completeVision.add("E-E-NE");
			completeVision.add("E-E-E");
			completeVision.add("E-E-SE");
			completeVision.add("E-SE-SE");
			completeVision.add("SE-SE-SE");
			completeVision.add("S-SE-SE");
			completeVision.add("S-S-SE");
			completeVision.add("S-S-S");
			completeVision.add("S-S-SW");
			completeVision.add("S-SW-SW");
			completeVision.add("SW-SW-SW");
			completeVision.add("W-SW-SW");
			completeVision.add("W-W-SW");
			completeVision.add("W-W-W");
			completeVision.add("W-W-NW");
			completeVision.add("W-NW-NW");
			
			Section.sectionA.add(-6);
			Section.sectionA.add(-11);
			Section.sectionB.add(-6);
			Section.sectionB.add(-4);
			Section.sectionC.add(-6);
			Section.sectionC.add(3);
			Section.sectionD.add(-6);
			Section.sectionD.add(10);
			
			Section.sectionE.add(0);
			Section.sectionE.add(-6);
			Section.sectionF.add(2);
			Section.sectionF.add(2);
			Section.sectionG.add(0);
			Section.sectionG.add(6);
			Section.sectionH.add(0);
			Section.sectionH.add(13);
			
			Section.sectionI.add(6);
			Section.sectionI.add(-11);
			Section.sectionJ.add(6);
			Section.sectionJ.add(-3);
			Section.sectionK.add(6);
			Section.sectionK.add(4);
			Section.sectionL.add(6);
			Section.sectionL.add(11);
			
		}

		StringBuilder parameter = new StringBuilder("");

		// Als anthill genoeg voedsel heeft kan hij ant maken.
		if (unitArray != null) {
			for (int i = 0; i < unitArray.size(); i++) {
				JsonObject o = (JsonObject) unitArray.get(i).getAsJsonObject();
				if (o.get("type").getAsString().equals("AntHill")) {
					int id = o.get("id").getAsInt();
					int food = o.get("food").getAsInt();

					// als food meer is all 100 en turns niet boven 120 is, maak
					// ant aan
					if (food > 99) {
						if (MainClass.turn < 120) {
							if (MainClass.ants.size() < 17) {
								parameter.append("{\"unitId\":" + id + ",\"order\":\"GA\"},");
							}
						}
					}
				}
			}
		}

		
		// removed dode ant van de ants array.
		if (unitArray != null) {
			for (int i = 0; i < unitArray.size(); i++) {
				JsonObject k = (JsonObject) unitArray.get(i).getAsJsonObject();
				if (k.get("hasDied").getAsString().equals("true")) {
					int dodeID = k.get("id").getAsInt();
					for (int r = 0; r < ants.size(); r++) {
						if (ants.get(r).ID == dodeID) {
							System.out.println("XXDIED Ant" + ants.get(r).ID + "DIEDxxx");
							ants.remove(r);
						}
					}
				}
			}
		}

		// maak nieuwe ant aan.
		if (unitArray != null) {
			if ((unitArray.size() - 1) > ants.size()) {
				AntClass ant = new AntClass(++antID);
				ants.add(ant);
			}
		}

		// check if iedere ant matched met ID. en zet alle nieuwe info in het
		// AntClass object
		if (ants != null) {
			for (int i = 0; i < ants.size(); i++) {
				for (int j = 0; j < unitArray.size(); j++) {
					JsonObject o = (JsonObject) unitArray.get(j).getAsJsonObject();
					if (ants.get(i).ID == o.get("id").getAsInt()) {
						ants.get(i).setPastBlokjes();
						ants.get(i).food = o.get("food").getAsInt();
						ants.get(i).pastVision = ants.get(i).vision;
						ants.get(i).vision = o.get("vision").getAsString();
						ants.get(i).pastMove = ants.get(i).move;
						ants.get(i).orientation = o.get("orientation").getAsString();

						// Roep de gameEngine aan.
						String move = beginWithAnt(ants.get(i));
						parameter.append(move);
					}
				}
			}
		}

		// return de output naar vorige methode.
		parameter.append("");
		System.out.print(parameter);
		String p = parameter.toString();
		StringEntity para = new StringEntity("[" + p + "]");
		return para;
	}

	//Deze begint met de ant logica.
	public static String beginWithAnt(AntClass ant) {
		StringBuilder parameter = new StringBuilder("");

		// logging voor duidelijkheid in het begin van de turn zie je alle
		// vision van de ant.
		System.out.println("hij begint nu met ant" + ant.ID);
		System.out.println("ant orientation = " + ant.orientation);
		System.out.println("food amount: " + ant.food);

		System.out.println(ant.blokje("NW-NW-NW") + "  " + ant.blokje("N-NW-NW") + "  " + ant.blokje("N-N-NW") + "  "
				+ ant.blokje("N-N-N") + "  " + ant.blokje("N-N-NE") + "  " + ant.blokje("N-NE-NE") + "  "
				+ ant.blokje("NE-NE-NE") + "");
		System.out.println(ant.blokje("W-NW-NW") + "  " + ant.blokje("NW-NW") + "  " + ant.blokje("N-NW") + "  "
				+ ant.blokje("N-N") + "  " + ant.blokje("N-NE") + "  " + ant.blokje("NE-NE") + "  " + ant.blokje("E-NE")
				+ "");
		System.out.println(
				ant.blokje("W-W-NW") + "  " + ant.blokje("W-NW") + "  " + ant.blokje("NW") + "  " + ant.blokje("N")
						+ "  " + ant.blokje("NE") + "  " + ant.blokje("E-NE") + "  " + ant.blokje("E-E-NE") + "");
		System.out.println(
				ant.blokje("W-W-W") + "  " + ant.blokje("W-W") + "  " + ant.blokje("W") + "  " + ant.orientation + "  "
						+ ant.blokje("E") + "  " + ant.blokje("E-E") + "  " + ant.blokje("E-E-E") + "");
		System.out.println(
				ant.blokje("W-W-SW") + "  " + ant.blokje("W-SW") + "  " + ant.blokje("SW") + "  " + ant.blokje("S")
						+ "  " + ant.blokje("SE") + "  " + ant.blokje("E-SE") + "  " + ant.blokje("E-E-SE") + "");
		System.out.println(ant.blokje("W-SW-SW") + "  " + ant.blokje("SW-SW") + "  " + ant.blokje("S-SW") + "  "
				+ ant.blokje("S-S") + "  " + ant.blokje("S-SE") + "  " + ant.blokje("SE-SE") + "  "
				+ ant.blokje("E-SE-SE") + "");
		System.out.println(ant.blokje("SW-SW-SW") + "  " + ant.blokje("S-SW-SW") + "  " + ant.blokje("S-S-SW") + "  "
				+ ant.blokje("S-S-S") + "  " + ant.blokje("S-S-SE") + "  " + ant.blokje("S-SE-SE") + "  "
				+ ant.blokje("SE-SE-SE") + "");

		System.out.println("position = " + ant.position[0] + " " + ant.position[1]);

		System.out.println("Missie = " + ant.missionType);
		System.out.println("Assigned section = " + ant.section);

		
		//hij returned de order aan de hand van de formatMove method.
		switch (formatMove(ant)) {
		case "M":
			parameter.append("{\"unitId\":" + ant.ID + ",\"order\":\"M\"},");

				//update de coordinaten van de ant
			ant.position[0] = ant.setPosition(ant.orientation)[0];
			ant.position[1] = ant.setPosition(ant.orientation)[1];
			// System.out.println(ant.position[0] + " " + ant.position[1]);

			ant.move = "M";
			break;
		case "H":
			parameter.append("{\"unitId\":" + ant.ID + ",\"order\":\"H\"},");
			ant.move = "H";
			break;
		case "N":
			parameter.append("{\"unitId\":" + ant.ID + ",\"order\":\"N\"},");
			ant.move = "N";
			break;
		case "NE":
			parameter.append("{\"unitId\":" + ant.ID + ",\"order\":\"NE\"},");
			ant.move = "NE";
			break;
		case "E":
			parameter.append("{\"unitId\":" + ant.ID + ",\"order\":\"E\"},");
			ant.move = "E";
			break;
		case "SE":
			parameter.append("{\"unitId\":" + ant.ID + ",\"order\":\"SE\"},");
			ant.move = "SE";
			break;
		case "S":
			parameter.append("{\"unitId\":" + ant.ID + ",\"order\":\"S\"},");
			ant.move = "S";
			break;
		case "SW":
			parameter.append("{\"unitId\":" + ant.ID + ",\"order\":\"SW\"},");
			ant.move = "SW";
			break;
		case "W":
			parameter.append("{\"unitId\":" + ant.ID + ",\"order\":\"W\"},");
			ant.move = "W";
			break;
		case "NW":
			parameter.append("{\"unitId\":" + ant.ID + ",\"order\":\"NW\"},");
			ant.move = "NW";
			break;
		case "T":
			parameter.append("{\"unitId\":" + ant.ID + ",\"order\":\"T\"},");
			ant.move = "T";
			break;
		}

		// System.out.print(parameter);
		String p = parameter.toString();
		// StringEntity para = new StringEntity("[" + p + "]");
		return p;
	}

	//Hierin word er echt begonnen met het nadenken over waar de ant naartoe moet gaan.
	public static String formatMove(AntClass ant) {

		// als toevallig onderweg naar missie over voedsel heen loopt, pak het op.
		
		//Als de ant nog geen missie heeft word een missie gegeven
		if (ant.missionType == null) {
			Missions.setMission(ant);
		}

		if (ant.missionType != null) {
			return Missions.followMission(ant);
		} 

		//deze zou eigenlijk niet aangeroepen mogen worden, maar staat er als check
		System.out.println("return end of method S");
		return "S";
	}
	
	//Checked of food in de buurt ligt, zo ja, dan zet hij missie naar getFood
	public static boolean searchForFood(AntClass ant) {
		// zet nog wel dat ze eerst kijken welk blokje het dichtbij ligt. dat ze
		// die pakken als eerst.

		ArrayList<int[]> foodLocations = new ArrayList<int[]>();
		foodLocations = ant.checkForFood();
		int tempLocation[] = new int[] { 0, 0 };

		//System.out.println("hoeveel food found: " + foodLocations.size() + " + locations: ");
		for (int g = 0; g < foodLocations.size(); g++) {
			//System.out.println(foodLocations.get(g)[0] +  " " + foodLocations.get(g)[1]);
		}

		if (foodLocations.size() > 0) {
			// als je naar section gaat moet hij het laten liggen, anders fucked
			// de hele structuur weer
			outerloop:
			for (int i = 0; i < foodLocations.size(); i++) {
				tempLocation = foodLocations.get(i);
				
				if (foodLocations.get(i)[0] == 0 & foodLocations.get(i)[1] == 0) {
					continue;
				}

				if (ant.missionType != null) {
					if (!ant.missionType.equals("moveToSection")) {
						//System.out.println("mission != moveToSection, ga verder");
	
						innerloop:
						for (int p = 0; p < ants.size(); p++) {
							if (ant.ID != ants.get(p).ID) {
								//System.out.println("ID niet zelfde");
								if (ants.get(p).missionType != null) {
									if (ants.get(p).missionType.equals("getFood")) {
										//System.out.println("Andere ant zijn missie is ook getFood, check verder");
	
										if (tempLocation[0] == ants.get(p).missionLocation[0] && tempLocation[1] == ants.get(p).missionLocation[1]) {
											//System.out.println("Een andere ant pakt het voedsel al");
											continue outerloop;
										} 
									}
								}
							} 
						}
						
						if (ant.section != null) {
							if (Section.targetInSection(ant, foodLocations.get(i)) == false) {
								//System.out.println("Voedsel ligt niet in sectie, zoek verder");
								continue;
							}
						}
						
						System.out.println("alles klopt, Hij mag het eten pakken");
						ant.missionLocation[0] = foodLocations.get(i)[0];
						ant.missionLocation[1] = foodLocations.get(i)[1];
						ant.missionType = "getFood";
						return true;
					}
				}
			}
			System.out.println("Geen eten beschikbaar");
			return false;
		} 

		System.out.println("Er is geen eten terug gekomen");
		return false;
	}

	// checked of hij over voedsel heen loopt
	public static boolean harvestOrNot(AntClass ant) {
		if (ant.orientation != null) {
			if (ant.pastBlokje(ant.orientation) != null) {
				if (ant.pastBlokje(ant.orientation).equals(foodOnLand)) {
					System.out.println("pastmove = " + ant.pastMove);
					if (ant.pastMove.equals("M")) {
						//return true;
					}
				}
			}
		}

		return false;
	}
}