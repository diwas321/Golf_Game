//new class to store hole info
public class Holes {
	private int distance;
	private int par;
	
	public Holes(int distance, int par) {
		this.distance=distance;
		this.par=par;
	}
	
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getPar() {
		return par;
	}
	public void setPar(int par) {
		this.par = par;
	}
	

}
