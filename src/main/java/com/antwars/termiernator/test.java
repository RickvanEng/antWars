package com.antwars.termiernator;

public class test {}

//Zet vision om naar total map. wordt nu niet meer gebruikt
	/*
	 * public static void setVisiontoMap(AntClass ant) {
	 * 
	 * //verzin hier een loop voor ofzo, op deze manier hoef je niet 49 keer
	 * alles in te vullen. //of vul 49 keer alles in,..... int a = 0; int b = 1;
	 * System.out.println("ant" + ant.ID + " position = " + ant.position[0] +
	 * ant.position[1]); for (int i = 0; i < 7; i++) { for (int x = 0; x < 7;
	 * x++) {
	 * 
	 * if (ant.position[0] < 15 && ant.position[0] > 3 && ant.position[1] < 23
	 * && ant.position[1] > 3) {
	 * 
	 * map[(ant.position[0] - 3) + i][(ant.position[1] - 3) + x] = new
	 * StringBuilder().append(ant.vision.charAt(a)).append(ant.vision.charAt(b))
	 * .toString();
	 * 
	 * a = a + 2; b = b + 2; } } }
	 * 
	 * 
	 * //System.out.println("plek in de map = " + map[ant.position[0] -
	 * 3][ant.position[1] - 3]); //System.out.println("vanuit vision = " +
	 * ant.vision.charAt(0) + ant.vision.charAt(1)); }
	 */

	/*
	public static int position[] = new int[] { 0, 0 };

	public static void main(String args[]) {
		bla();
	}
	
	static int x = 5;

	public static void bla(){ 
		int a[] = new int[] {0, 0};
		int b[] = new int[] {1, 0};
		
		if (a[1] == b[1]) {
			System.out.println("yes is true");
		}
	}
}

if (searchForFood(ant) == true) {
	moveToLocation(ant);
	

	if (ant.missionLocation[0] > ant.position[0]) {
		if (ant.missionLocation[1] > ant.position[1]) {
			
			ArrayList<String> options1 = new ArrayList<String>();
			options1.add("SE");
			options1.add("S");
			options1.add("E");
			
			for (int x = 0; x < 3; x++) {
				if (isOptionGood(ant, options1.get(x)) == true) {
					if (!ant.orientation.equals(options1.get(x))) {
						System.out.println("returned option = " + options1.get(x));
						return options1.get(x);
					} else {
						if (canWalk(ant) == true) {
							return "M";
						} else {
							simpleChangeDirectionMethod(ant);
						}
					}
				}
			}
		}

		if (ant.missionLocation[1] == ant.position[1]) {
				ArrayList<String> options1 = new ArrayList<String>();
				options1.add("S");
				options1.add("SE");
				options1.add("SW");
				
				for (int x = 0; x < 3; x++) {
					if (isOptionGood(ant, options1.get(x)) == true) {
						if (!ant.orientation.equals(options1.get(x))) {
							System.out.println("returned option = " + options1.get(x));
							return options1.get(x);
						} else {
							if (canWalk(ant) == true) {
								return "M";
							} else {
								simpleChangeDirectionMethod(ant);
							}
						}
					}
				}
			
		}
		if (ant.missionLocation[1] < ant.position[1]) {
					ArrayList<String> options1 = new ArrayList<String>();
					options1.add("SW");
					options1.add("S");
					options1.add("W");
					
					for (int x = 0; x < 3; x++) {
						if (isOptionGood(ant, options1.get(x)) == true) {
							if (!ant.orientation.equals(options1.get(x))) {
								System.out.println("returned option = " + options1.get(x));
								return options1.get(x);
							} else {
								if (canWalk(ant) == true) {
									return "M";
								} else {
									simpleChangeDirectionMethod(ant);
								}
							}
						}
					}
				
			
		}
	}
	if (ant.missionLocation[0] < ant.position[0]) {
		if (ant.missionLocation[1] > ant.position[1]) {
					ArrayList<String> options1 = new ArrayList<String>();
					options1.add("NE");
					options1.add("N");
					options1.add("E");
					
					for (int x = 0; x < 3; x++) {
						if (isOptionGood(ant, options1.get(x)) == true) {
							if (!ant.orientation.equals(options1.get(x))) {
								System.out.println("returned option = " + options1.get(x));
								return options1.get(x);
							} else {
								if (canWalk(ant) == true) {
									return "M";
								} else {
									simpleChangeDirectionMethod(ant);
								}
							}
						}
					}
				
			
		}
		if (ant.missionLocation[1] == ant.position[1]) {
			ArrayList<String> options1 = new ArrayList<String>();
			options1.add("N");
			options1.add("NW");
			options1.add("NE");

			for (int x = 0; x < 3; x++) {
				if (isOptionGood(ant, options1.get(x)) == true) {
					if (!ant.orientation.equals(options1.get(x))) {
						System.out.println("returned option = " + options1.get(x));
						return options1.get(x);
					} else {
						if (canWalk(ant) == true) {
							return "M";
						} else {
							simpleChangeDirectionMethod(ant);
						}
					}
				}
			}
		}
		if (ant.missionLocation[1] < ant.position[1]) {
			ArrayList<String> options1 = new ArrayList<String>();
			options1.add("NW");
			options1.add("N");
			options1.add("NE");

			for (int x = 0; x < 3; x++) {
				if (isOptionGood(ant, options1.get(x)) == true) {
					if (!ant.orientation.equals(options1.get(x))) {
						System.out.println("returned option = " + options1.get(x));
						return options1.get(x);
					} else {
						if (canWalk(ant) == true) {
							return "M";
						} else {
							simpleChangeDirectionMethod(ant);
						}
					}
				}
			}
		}
	}
	if (ant.missionLocation[0] == ant.position[0]) {
		if (ant.missionLocation[1] > ant.position[1]) {
			ArrayList<String> options1 = new ArrayList<String>();
			options1.add("E");
			options1.add("NE");
			options1.add("SE");

			for (int x = 0; x < 3; x++) {
				if (isOptionGood(ant, options1.get(x)) == true) {
					if (!ant.orientation.equals(options1.get(x))) {
						System.out.println("returned option = " + options1.get(x));
						return options1.get(x);
					} else {
						if (canWalk(ant) == true) {
							return "M";
						} else {
							simpleChangeDirectionMethod(ant);
						}
					}
				}
			}
		}
		if (ant.missionLocation[1] == ant.position[1]) {
			ant.missionLocation = null;
			return "H";
		}
		if (ant.missionLocation[1] < ant.position[1]) {
			ArrayList<String> options1 = new ArrayList<String>();
			options1.add("W");
			options1.add("NW");
			options1.add("SW");

			for (int x = 0; x < 3; x++) {
				if (isOptionGood(ant, options1.get(x)) == true) {
					if (!ant.orientation.equals(options1.get(x))) {
						System.out.println("returned option = " + options1.get(x));
						return options1.get(x);
					} else {
						if (canWalk(ant) == true) {
							return "M";
						} else {
							simpleChangeDirectionMethod(ant);
						}
					}
				}
			}
		}
	}
	*/
	
	
	/*
	//Maak een SetMission method, aan het eind van een missie automatisch deze funtie aanroepen.
	if (ant.missionLocation == null) {
		//ant.setMission();
		//walk back to location
		//searchForFood
	}

	// als niet harvest, kan hij moven?
	if (canWalk(ant) == true) {
		// System.out.println("canwalk komt terug als true");
		return "M";
	} else {
		// System.out.println("canwalk komt terug als false");
		simpleChangeDirectionMethod(ant);
	}
	
	
	*/