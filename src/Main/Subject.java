package Main;

public class Subject {
	String name;
	int points;
	int daysOfLearning;
	double profitabilityParameter;
	boolean subjectDone;
	
	public Subject(String name, int points, int daysOfLearning)
	{
		this.name = name;
		this.points = points;
		this.daysOfLearning = daysOfLearning;
		this.profitabilityParameter = points * 1.0 / daysOfLearning;
		this.subjectDone = false;
	}
	String getName()
	{
		return name;
	}
	int getPoints()
	{
		return points;
	}
	double getProfitabilityParameter()
	{
		return profitabilityParameter;
	}
	int getDaysOfLearning()
	{
		return daysOfLearning;
	}
}
