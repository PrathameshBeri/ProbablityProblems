package hello;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

enum prizes{
	
	  Goat1,
	  Goat2,
	  Car;
}

public class MontyHall {
	
	public static void main(String [] args) {
		
		prizes prize = null ;
		Door[] doors = new Door[] {
				new Door(prize.Goat1),
				new Door(prize.Car),
				new Door(prize.Goat2)
		};
		
		List<Door> doo = Arrays.asList(doors);
		
		
		Random rand = new Random();
		int tries = 0;
		int totalTries = 10000;
		
		for(int h = 0; h < totalTries; h++) {
			
			int f = rand.nextInt(3);
			Door dr = doo.get(f);
			Door revealDoor = reveal(dr, doo);
			Door switchDoor = switchDoor(dr, revealDoor, doo);
			
			if(switchDoor.getPrize().equals(prizes.Car)) {
				tries++;
			}
			
		}
		
		System.out.println((double)tries/totalTries);
		
		
		
	}
	
	static Door reveal(Door d, List<Door> list) {
		Door revealDoor = null;
		for(Door g : list) {
			if(g.getPrize() != d.getPrize() && g.getPrize() != prizes.Car) {
				revealDoor = g;
			}
			
		}
		
		return revealDoor;
	}
	
	static Door switchDoor(Door d, Door d1, List<Door> list) {
		
		Door switchDoor = null;
		for(Door t : list) {
			
			if(!(t.equals(d) || t.equals(d1))) {
				switchDoor = t;
			}
		}
		
		return switchDoor;
		
	}
	
	
	
	static class Door{
		
		prizes prize;
		
		public Door(prizes str) {
			this.prize = str;
		}
		
		public prizes getPrize() {
			
			return this.prize;
		}
		
	}
}
 