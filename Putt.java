//class to store putt info
public class Putt {
	private int mean;
	private int std;
	
	public Putt(int mean, int std) {
		this.mean=mean;
		this.std=std;
	}
	
	public int getMean() {
		return mean;
	}
	public void setMean(int mean) {
		this.mean = mean;
	}
	public int getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	
}
