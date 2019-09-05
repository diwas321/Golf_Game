//main game
import java.util.Random;
import java.util.Scanner;

public class Golf {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		starts();
		System.out.print("Enter the player's name:");
		Player player1= new Player(scan.next());// creating a player with default score 0
		
		Course[] courses = new Course[2]; //initializing an array of object courses
		
		Holes[] genesee = new Holes[18]; //an array of holes at genesee course 
		genesee[0]= new Holes(530,5);
		genesee[1]= new Holes(305,4);
		genesee[2]= new Holes(331,4);
		genesee[3]= new Holes(201,3);
		genesee[4]= new Holes(500,5);
		genesee[5]= new Holes(226,3);
		genesee[6]= new Holes(409,4);
		genesee[7]= new Holes(410,4);
		genesee[8]= new Holes(229,3);
		genesee[9]= new Holes(433,4);
		genesee[10]= new Holes(363,4);
		genesee[11]= new Holes(174,3);
		genesee[12]= new Holes(545,5);
		genesee[13]= new Holes(419,4);
		genesee[14]= new Holes(512,5);
		genesee[15]= new Holes(410,4);
		genesee[16]= new Holes(320,4);
		genesee[17]= new Holes(170,3);
		
		Holes[] old = new Holes[18]; //an array of holes at old course 
		old[0]= new Holes(376,4);
		old[1]= new Holes(453,4);
		old[2]= new Holes(397,4);
		old[3]= new Holes(480,4);
		old[4]= new Holes(568,5);
		old[5]= new Holes(412,4);
		old[6]= new Holes(371,4);
		old[7]= new Holes(175,3);
		old[8]= new Holes(352,4);
		old[9]= new Holes(386,4);
		old[10]= new Holes(174,3);
		old[11]= new Holes(348,4);
		old[12]= new Holes(465,4);
		old[13]= new Holes(618,5);
		old[14]= new Holes(455,4);
		old[15]= new Holes(423,4);
		old[16]= new Holes(495,4);
		old[17]= new Holes(357,4);
		
		courses[0]= new Course("Genesee"); //assigning names and holes info to both courses
		courses[1]= new Course("The Old Course at St. Andrews");
		courses[0].setHole(genesee);
		courses[1].setHole(old);
		
		Club[] clubs= new Club[10]; //creating and defining an array of clubs object to store info for 10 clubs
		clubs[0]= new Club(230,30);
		clubs[1]= new Club(215,20);
		clubs[2]= new Club(180,20);
		clubs[3]= new Club(170,17);
		clubs[4]= new Club(155,15);
		clubs[5]= new Club(145,15);
		clubs[6]= new Club(135,15);
		clubs[7]= new Club(125,15);
		clubs[8]= new Club(110,10);
		clubs[9]= new Club(50,10);
		
		Putt[] putts= new Putt[10]; //creating and defining an array of object Putt
		putts[0]= new Putt(1,1);
		putts[1]= new Putt(2,1);
		putts[2]= new Putt(4,2);
		putts[3]= new Putt(8,2);
		putts[4]= new Putt(12,3);
		putts[5]= new Putt(16,3);
		putts[6]= new Putt(20,4);
		putts[7]= new Putt(25,4);
		putts[8]= new Putt(30,5);
		putts[9]= new Putt(40,5);
		
		boolean play = true; //set a boolean to control the while loop
		System.out.println(player1.getName()+", do you want to start? [Y/N]: ");	
		String start = scan.next();
		if(!(start.equals("Y") || start.equals("y"))) { //if user chooses to not to start the game
			System.out.println("Byebye!"); 
			play = false;
		}
		
		int distance_travelled=0;
		int distance_hit;
		int score=0;
		
		while(play) { //main loop to control the game
			System.out.print("\nPlease select a course.\n1. Genesee Valley Park North Course"
					+ "\n2. The Old Course at St. Andrews\nYour choice [1-2]:");
			int choice = scan.nextInt(); // for selecting a golf course
			System.out.println("\nYou are playing at "+courses[choice-1].getName()+".\n");
			
			for(int i=0;i<18;i++) {
				int shots=0;//number of shots
				boolean hole=true;
				Holes[] current=courses[choice-1].getHole();
				int distance_remaining= Math.abs(current[i].getDistance()-distance_travelled);
				while(hole) {
						if(distance_remaining==current[i].getDistance()) {
							System.out.print("You are in the "+ tee(i+1)+ " tee. "+distance_remaining+
									" yards, par "+current[i].getPar());
						}else if(distance_remaining>20){
							System.out.print("You are in the fairway.\n"+tee(shots+1)+ " shot."+distance_remaining+
									" yards to the hole.");
						}else if(distance_remaining<=20) {
							System.out.print("You are on the green.\n"+tee(shots+1)+" shot. "+distance_remaining+
									" yards to the hole");
						}
						
						if(distance_remaining>20) {
							System.out.print("\nChoose your club [1-10]: ");
							int club=scan.nextInt();
							System.out.print("Power [1-10]: ");
							int power= scan.nextInt();
							distance_hit=nextDistance(clubs[club-1].getMean(),clubs[club-1].getStd(),power);
							System.out.println("You hit the ball "+distance_hit+" yards. Nice!\n");
							distance_remaining= Math.abs(distance_remaining-distance_hit);
							shots=shots+1;
						}else if(distance_remaining<=20){
							System.out.print("\nPutt power [1-10]: ");
							int p=scan.nextInt(); //power
							int distance_putt=nextPutt(putts[p-1].getMean(), putts[p-1].getStd(), p);
							System.out.println("Your putt went "+distance_putt+" feet\n");
							distance_remaining=Math.abs(distance_remaining-distance_putt);
							shots=shots+1;
							if(distance_remaining>20) {
								distance_remaining=20;
							}
							if(distance_remaining<=1) {
								hole=false;
								System.out.print("Nice, it's in the hole!\n");
								if(shots>current[i].getPar()) {
									System.out.print("\nYou made above par on this hole!");
									
								}else if(shots<current[i].getPar()) {
									System.out.print("\nYou made below par on this hole!");
								}else {
									System.out.print("\nYou made par on this hole!");
								}
								score=score+current[i].getPar()-shots;
								System.out.println(" Your score after "+tee(i+1)+" round is: "+ score+"\n");
							}
							
						}
						
					}
					System.out.print("Do you want to countinue to another hole? [y/n]: ");
					String answer= scan.next();
					if(answer.equals("n")|| answer.equals("N")) {
						play=false;
						break;
					}
			}
			
			
			
			System.out.print("\nDo you want to play another round? [Y/N]: ");	//testing to end the game after a round
			String test= scan.next();
			if(test.equals("N") || test.equals("n")){
				play=false;
			}else{
				play=true;
			}
			if(score>=0) {
				System.out.println("Your final score after this round: "+Math.abs(score)+" under.");
			}else if(score<0) {
				System.out.println("Your final score after this round: "+Math.abs(score)+" over.");
			}else {
				System.out.println("Your final score after the round is on par");
			}
			System.out.print("Good job!");
			
		}
	}
	
		
	public static int nextDistance(int mean, int stddev, int power) {
		Random random = new Random();
		double mean_adj = mean * power / 10.0;
		double stddev_adj = stddev * power / 10.0;
		double val = Math.abs(random.nextGaussian() * stddev_adj + mean_adj);
		return (int)val;
		}
	public static void starts() {
		System.out.println("Welcome to TTY Golf!");
		//System.out.print("\nPlease select a course.\n1. Genesee Valley Park North Course"
				//+ "\n2. The Old Course at St. Andrews\nYour choice [1-2]:");
	}
	public static String tee(int n) {
		String[] abc= {"first","second","third","fourth","fifh","sixth","seventh","eighth","ninth","tenth", 
				"eleventh","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen"};
		return abc[n-1];
	}
	public static int nextPutt(int mean, int stddev, int power) {
		Random random = new Random();
		double mean_adj = mean * power / 10.0;
		double stddev_adj = stddev * power / 10.0;
		double val = Math.abs(random.nextGaussian() * stddev_adj + mean_adj);
		return (int)val;
		}

}
