package com.antwars.termiernator;

import java.util.ArrayList;

public class Movement {

	
	//checked of de ant kan moven. walk on water moet nog worden uitgewerkt.
		public static boolean canWalk(AntClass ant) {
			//System.out.println("In canWalk method");
			if (ant.orientation != null) {
				
//				System.out.println("futureMove checked current ant" + ant.ID + " "
//						+ ant.checkFutureMoves(ant.orientation)[0] + " " + ant.checkFutureMoves(ant.orientation)[1]);

				// check if ant volgende beurt op blokje staat
				// niet blokje vergelijken maar positie.
				for (int i = 0; i < MainClass.ants.size(); i++) {
					if (MainClass.ants.get(i).orientation != null) {
						if (ant.checkFutureMoves(ant.orientation)[0] == MainClass.ants.get(i).checkFutureMoves(ant.orientation)[0]) {
							if (ant.checkFutureMoves(ant.orientation)[1] == MainClass.ants.get(i).checkFutureMoves(ant.orientation)[1]) {
								//System.out.println("hij crashed hier op");
								if (ant.ID != MainClass.ants.get(i).ID) {
									System.out.println("moves van ant " + MainClass.ants.get(i).ID + "is gevaarlijk voor ant " + ant.ID);
									return false;
								}
							}
						}
					}
				}
							
				//kan de ant over water lopen? werk verder uit.
				if (ant.blokje(ant.orientation).equals("~~")) {
					
					for (int i = 0; i < MainClass.ants.size(); i++) {
						if (MainClass.ants.get(i).orientation != null) {
							if (MainClass.ants.get(i).checkFutureMoves(ant.orientation)[0] == (ant.checkFutureMoves(ant.orientation)[0] - 1 | ant.checkFutureMoves(ant.orientation)[0]  | ant.checkFutureMoves(ant.orientation)[0] + 1) &&
									MainClass.ants.get(i).checkFutureMoves(ant.orientation)[1] == (ant.checkFutureMoves(ant.orientation)[1] - 1 | ant.checkFutureMoves(ant.orientation)[0]  | ant.checkFutureMoves(ant.orientation)[1] + 1)) {
								
								if (ant.ID != MainClass.ants.get(i).ID) {
									
									System.out.println("Ant " + MainClass.ants.get(i).ID + "red mij van water");
									//return true;
									return false;
								}
							}
						}
					}
					return false;
				}

				if (ant.blokje(ant.orientation).equals("#~")) {
					//System.out.println("foodonwater true " + ant.blokje(ant.orientation));
					return false;
				}
				if (ant.blokje(ant.orientation).equals("h1")) {
					//System.out.println("h1 true " + ant.blokje(ant.orientation));
					return false;
				}
				if (ant.blokje(ant.orientation).equals("H1")) {
					//System.out.println("H1 true " + ant.blokje(ant.orientation));
					return false;
				}
				if (ant.blokje(ant.orientation).equals("a1")) {
					//System.out.println("a1 true " + ant.blokje(ant.orientation));
					return false;
				}
				if (ant.blokje(ant.orientation).equals("A1")) {
					//System.out.println("A1 true " + ant.blokje(ant.orientation));
					return false;
				}
				if (ant.blokje(ant.orientation).equals("A.")) {
					//System.out.println("A. true " + ant.blokje(ant.orientation));
					return false;
				}
				
				//Code voor de sections van de ants. zorg ervoor dat iedereen in zijn sectie blijft en food transferred.
				if (ant.section != null) {
					for (int i = 0; i < Section.sections.size(); i++ ){
						if (!ant.missionType.equals("moveToSection")) {
							if (ant.section.equals(Section.sections.get(i))) {
								if (Section.targetInSection(ant, ant.checkFutureMoves(ant.orientation)) == false) {
									System.out.println("target " + ant.checkFutureMoves(ant.orientation)[0] + " " + ant.checkFutureMoves(ant.orientation)[1] + " is out of range van section");
									return false;
								}
							}
						}
					}
				}
				
				return true;
			}
			return false;

		}
		
		//kijkt of de kant waar de ant op will turnen een goede optie is.
		public static boolean isOptionGood(AntClass ant, String option) {

			if (ant.blokje(option).equals(MainClass.water)) {
				return false;
			}
			if (ant.blokje(option).equals(MainClass.foodOnWater)) {
				return false;
			}
			if (ant.blokje(option).equals(MainClass.allyHill)) {
				return false;
			}
			if (ant.blokje(option).equals(MainClass.allyHill2)) {
				return false;
			}
			if (ant.blokje(option).equals(MainClass.allyAnt)) {
				return false;
			}
			if (ant.blokje(option).equals(MainClass.allyAntOnSomething)) {
				return false;
			}
			if (ant.blokje(option).equals("A.")) {
				return false;
			}

			return true;
		}

		//Move naar location die als mission is gezet.
		public static String moveToLocation(AntClass ant) {

			// Laat ze lopen naar de locatie waar ze heen moeten.
			if (ant.position[0] > ant.missionLocation[0] && ant.position[1] == ant.missionLocation[1]) {
				// hij is onder Hill, dus hij moet N
				ArrayList<String> options = new ArrayList<String>();
				options.add("N");
				options.add("NW");
				options.add("NE");

				for (int x = 0; x < 3; x++) {
					if (isOptionGood(ant, options.get(x)) == true) {
						if (!ant.orientation.equals(options.get(x))) {
							System.out.println("returned option = " + options.get(x));
							return options.get(x);
						} else {
							if (canWalk(ant) == true) {
								return "M";
							} else {
								return "Nothing van N";
							}

						}
					}
				}
			}

			if (ant.position[0] > ant.missionLocation[0] && ant.position[1] > ant.missionLocation[1]) {
				// hij is rechts onder Hill, dus hij moet NW
				ArrayList<String> options = new ArrayList<String>();
				options.add("NW");
				options.add("N");
				options.add("W");

				for (int x = 0; x < 3; x++) {

					if (isOptionGood(ant, options.get(x)) == true) {
						if (!ant.orientation.equals(options.get(x))) {
							System.out.println("returned option = " + options.get(x));
							return options.get(x);
						} else {
							if (canWalk(ant) == true) {
								return "M";
							} else {
								return "Nothing van NW";
							}

						}
					}
				} 
//				Missions.setMission(ant); 
//				//return Movement.moveToLocation(ant);
			}
			if (ant.position[0] < ant.missionLocation[0] && ant.position[1] > ant.missionLocation[1]) {
				// hij is rechts boven Hill, dus hij moet SW
				ArrayList<String> options = new ArrayList<String>();
				options.add("SW");
				options.add("S");
				options.add("W");

				for (int x = 0; x < 3; x++) {

					if (isOptionGood(ant, options.get(x)) == true) {
						if (!ant.orientation.equals(options.get(x))) {
							System.out.println("returned option = " + options.get(x));
							return options.get(x);
						} else {
							if (canWalk(ant) == true) {
								return "M";
							} else {
								return "Nothing van SW";
							}

						}
					}
				} 
//				Missions.setMission(ant);
//				//return Movement.moveToLocation(ant);
			}
			if (ant.position[0] < ant.missionLocation[0] && ant.position[1] < ant.missionLocation[1]) {
				// hij is links boven Hill, dus hij moet SE
				ArrayList<String> options = new ArrayList<String>();
				options.add("SE");
				options.add("E");
				options.add("S");

				for (int x = 0; x < 3; x++) {
					if (isOptionGood(ant, options.get(x)) == true) {
						if (!ant.orientation.equals(options.get(x))) {
							System.out.println("returned option = " + options.get(x));
							return options.get(x);
						} else {
							if (canWalk(ant) == true) {
								return "M";
							} else {
								return "Nothing van SE";
							}

						}
					}
				}
//				Missions.setMission(ant);
//				//return Movement.moveToLocation(ant);
			}
			if (ant.position[0] > ant.missionLocation[0] && ant.position[1] < ant.missionLocation[1]) {
				// hij is links onder Hill, dus hij moet NE
				ArrayList<String> options = new ArrayList<String>();
				options.add("NE");
				options.add("N");
				options.add("E");

				for (int x = 0; x < 3; x++) {

					if (isOptionGood(ant, options.get(x)) == true) {
						if (!ant.orientation.equals(options.get(x))) {
							System.out.println("returned option = " + options.get(x));
							return options.get(x);
						} else {
							if (canWalk(ant) == true) {
								return "M";
							} else {
								return "Nothing van NE";
							}

						}
					}
				}
//				Missions.setMission(ant);
//				//return Movement.moveToLocation(ant);
			}
			if (ant.position[0] == ant.missionLocation[0] && ant.position[1] < ant.missionLocation[1]) {
				// hij is links van Hill, dus hij moet E
				ArrayList<String> options = new ArrayList<String>();
				options.add("E");
				options.add("SE");
				options.add("NE");

				for (int x = 0; x < 3; x++) {

					if (isOptionGood(ant, options.get(x)) == true) {
						if (!ant.orientation.equals(options.get(x))) {
							System.out.println("returned option = " + options.get(x));
							return options.get(x);
						} else {
							if (canWalk(ant) == true) {
								return "M";
							} else {
								return "Nothing van E";
							}

						}
					}
				} 
//				Missions.setMission(ant);
//				//return Movement.moveToLocation(ant);
			}
			if (ant.position[0] == ant.missionLocation[0] && ant.position[1] > ant.missionLocation[1]) {
				// hij is rechts van Hill, dus hij moet NW
				ArrayList<String> options = new ArrayList<String>();
				options.add("W");
				options.add("NW");
				options.add("SW");

				for (int x = 0; x < 3; x++) {

					if (isOptionGood(ant, options.get(x)) == true) {
						if (!ant.orientation.equals(options.get(x))) {
							System.out.println("returned option = " + options.get(x));
							return options.get(x);
						} else {
							if (canWalk(ant) == true) {
								return "M";
							} else {
								return "Nothing van W";
							}

						}
					}
				}
//				Missions.setMission(ant);
//				//return Movement.moveToLocation(ant);
			}
			if (ant.position[0] < ant.missionLocation[0] && ant.position[1] == ant.missionLocation[1]) {
				// hij is boven Hill, dus hij moet S
				ArrayList<String> options = new ArrayList<String>();
				options.add("S");
				options.add("SW");
				options.add("SE");

				for (int x = 0; x < 3; x++) {

					if (isOptionGood(ant, options.get(x)) == true) {
						if (!ant.orientation.equals(options.get(x))) {
							System.out.println("returned option = " + options.get(x));
							return options.get(x);
						} else {
							if (canWalk(ant) == true) {
								return "M";
							} else {
								return "Nothing van S";
							}

						}
					}
				} 
			}
			System.out.println("returned end of MoveToLovation Method S");
			return "S";
		}

		//checked of ant op locatie is
		public static boolean isAtLocation(AntClass ant) {
			if (ant.position[0] == ant.missionLocation[0] && ant.position[1] == ant.missionLocation[1]) {
				return true;
			}
			
			//hij returned true als ants om de hill heen staan.
			if (ant.missionType.equals("return")) {
				if (ant.position[0] == -1 | ant.position[0] == 0 | ant.position[0] == 1 && ant.position[1] == -1 | ant.position[1] == 0 | ant.position[1] == 1) {
					return true;
				}
			}
			
			
			
			//bij de moveout method, als de ant in de buurt komt is het ook goed. dan zegt hij true.
			if (ant.missionType.equals("moveToSection")) {
				if (ant.position[0] == ant.missionLocation[0] - 1 | ant.position[0] == ant.missionLocation[0] | ant.position[0] == ant.missionLocation[0] + 1 &&
					ant.position[1] == ant.missionLocation[1] - 1 | ant.position[1] == ant.missionLocation[1] | ant.position[1] == ant.missionLocation[1] + 1){
					for (int o = 0; o < MainClass.directions.size(); o++) {
						if (ant.checkFutureMoves(MainClass.directions.get(o)) == ant.missionLocation) {
							return true;
						}
					}
					return true;
				}
			}
			return false;
		}

		//Kijkt of ant food moet transferren of niet. Deze moet worden geupdate met de sections etc.
		public static String transferFood(AntClass ant) {
			System.out.println("In tranferfood method");
			
			int hillLocation[] = new int[] {0, 0};

			//System.out.println("In tranferfood methodvoor tansfer stuk");
//			if (transferAndRun(ant) >= 4){
//				System.out.println("Drop and run!");
//				return "T";
//			}
			
			
			
			for (int i = 0; i < MainClass.directions.size(); i++) {
				System.out.println(MainClass.directions.get(i));
				if (ant.checkTilePosition(MainClass.directions.get(i))[0] == hillLocation[0] && ant.checkTilePosition(MainClass.directions.get(i))[1] == hillLocation[1]) {
					System.out.println("Check 2");
					if (MainClass.directions.get(i).equals(ant.orientation)) {
						System.out.println("Check 3");
						return "T";
					} else if (!MainClass.directions.get(i).equals(ant.orientation)) {
						System.out.println("hij geeft directions terug");
						return MainClass.directions.get(i);
					}
				}
			}
			return "";
		}

		//Als te druk word transferred hij food en rent. Deze gaat miss weg.
		public static int transferAndRun(AntClass ant) {
			//System.out.println("in transaAndRun method");
			int returnInt = 0;
			
			for (int i = 0; i < MainClass.directions.size(); i++) {
				if (ant.blokje(MainClass.directions.get(i)).equals(MainClass.allyAnt)) {
					returnInt++;
				}
				if (ant.blokje(MainClass.directions.get(i)).equals("A1")) {
					returnInt++;
				}
			}
			
			
			return returnInt;
		}
}

