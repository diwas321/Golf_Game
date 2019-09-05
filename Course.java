//new class for courses
public class Course{
	private String name;
	private Holes[] hole= new Holes[18];

	
	public Course(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Holes[] getHole() {
		return hole;
	}
	public void setHole(Holes[] hole) {
		this.hole = hole;
	}
}
