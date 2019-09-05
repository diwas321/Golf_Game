//class to store player info
public class Player {
	private String name;
	private int score;
	
	public Player(String fullname, int score) {
		this.name=fullname;
		this.score=score;
	}
	public Player(String fullname) { //setting default score to zero
		this.name=fullname;
		this.score=0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
