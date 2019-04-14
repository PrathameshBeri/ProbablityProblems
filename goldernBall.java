package hello;

import java.util.Random;

public class goldernBall {
	
	
	public static void main(String args[]) {
		
		Box[] boxes = new Box[]{
		new Box( 'G' , 'G'),
		new Box('G', 'W'),
		new Box( 'W', 'W')
		};
		char first = 'G';
		Random random = new Random();
		Random random2 = new Random();
		
		double probablity;
		
		long gold = 0;
		long white = 0;
		long tries = 0;
		Box box;
		for(int y = 0; y < 30000 ; y++) {
			
			int u = random.nextInt(3);
			//System.out.println(u);
			box = boxes[u];
			
			int pos = random2.nextInt(2);
			
			if(box.getBall(pos) == 'G') {
			//box.toTtring();
			
			
				tries++;
				
				int other = ( (pos == 0) ? 1 : 0 );
				
				if(box.getBall(other) == 'W') {
					white++;
				}else { gold++ ;}
			}
			
			
		}

		System.out.println(gold);
		System.out.println(tries);
		System.out.println(calculateProbablity(gold, tries));
		
		
	}
	
	public static double calculateProbablity(long gold, long tries) {
		
		double geld = (double)gold;
		double trys = (double)tries;
		double probab;
		probab = (geld/tries);
		return probab;
	}
	
	
	static class Box{
		
		char ball1;
		char ball2;
		
		Box() {
		}
		Box(char c1, char c2){
			this.ball1 = c1;
			this.ball2 = c2;
		}
		
		char getBall(int i) {
			
			if(i == 0) {
				return ball1;
			}
			
			else return ball2;
		}
		
		public void toTtring() {
			
			System.out.println(this.ball1 + "  " + this.ball2);
		}
	}
}
