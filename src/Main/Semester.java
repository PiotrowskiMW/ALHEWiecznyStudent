package Main;

import java.util.ArrayList;
import java.util.List;

public class Semester {
	int avaliableDays;
	List<Subject> subjectsList;
	public Semester(int avaliableDays)
	{
		this.avaliableDays = avaliableDays;
		subjectsList = new ArrayList<Subject>();
	}
	void addSubject(Subject subject)
	{
		subjectsList.add(subject);
	}
	int getAvaliableDays()
	{
		return avaliableDays;
	}
	void setAvaliableDays(int days)
	{
		avaliableDays = days;
	}
	String printSubjects()
	{
		String str = "";
		for(Subject x : subjectsList)
		{
			str = str.concat(" - " + x.getName() + "\n");
		}
		
		return str;
	}
}
