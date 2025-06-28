
import java.awt.Point;
import java.util.ArrayList;
public class Polygon {
	private ArrayList<Point> localPoints;
	private AreaCalculator calc;
	public AreaCalculator getCalc() {
		return calc;
	}
	public void setCalc(AreaCalculator calc) {
		this.calc = calc;
	}
	public ArrayList<Point> getLocalPoints() {
		return localPoints;
	}
	public Polygon(ArrayList<Point> points , AreaCalculator calc) {
		this.localPoints = points;
		this.calc = calc;
	}
	public void addPoint(Point point){
		this.localPoints.add(point);
	}
	public float getArea(){
		return calc.getArea(localPoints);
	}
}
