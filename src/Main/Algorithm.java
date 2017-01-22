package Main;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {
	List<Subject> subjectsList; 
	List<Semester> semestersList;
	int daysAvaliableInSemester;
	int numberOfSemesters;
	int numberOfRequiredPoints;
	public Algorithm()
	{
		subjectsList = new ArrayList<Subject>(); 
		semestersList = new ArrayList<Semester>();
	}
	void findBestSubjectsList()
	{
		Semester currentProcessedSemester;
		int indexOfCurrentSem = 0;
		int gainedPoints = 0;
		for(int i =0; i<numberOfSemesters; i++)
		{
			semestersList.add(new Semester(daysAvaliableInSemester));
		}
		while(gainedPoints < numberOfRequiredPoints)
		{
			currentProcessedSemester = semestersList.get(indexOfCurrentSem);
			indexOfCurrentSem++;
			if(indexOfCurrentSem >= semestersList.size())
			{
				System.out.println("Znalezienie planu dla studenta nie powiodło się");
				break;
			}
			while(currentProcessedSemester.getAvaliableDays() > 0)
			{
				Subject bestFittingSubject = null;
				for(Subject x : subjectsList)//znajdz najlepiej pasujący przedmiot
				{
					if(bestFittingSubject == null)//jeżeli nie przypisaliśmy jeszcze żadnego przedmiotu
					{
						if(x.getDaysOfLearning() <= currentProcessedSemester.getAvaliableDays() && x.subjectDone == false)
							bestFittingSubject = x;
					}
					else
					{
						if(x.getDaysOfLearning() <= currentProcessedSemester.getAvaliableDays() && x.subjectDone == false && x.getProfitabilityParameter() > bestFittingSubject.getProfitabilityParameter())
							bestFittingSubject = x;
						//System.out.println("ACT prof " + x.getProfitabilityParameter());
						//System.out.println("Chosen prof " + bestFittingSubject.getProfitabilityParameter());
					}
				}
				if(bestFittingSubject == null)//nie udało się znaleźć żadnego dodatkowego przedmiotu który możnaby zrealizować w danym semestrze
					break;
				else
				{
					currentProcessedSemester.addSubject(bestFittingSubject);
					currentProcessedSemester.setAvaliableDays(currentProcessedSemester.getAvaliableDays() - bestFittingSubject.getDaysOfLearning());
					gainedPoints+=bestFittingSubject.getPoints();
					bestFittingSubject.subjectDone = true;
					//System.out.println("-----------------------------------");
				}
			}
		}
	}
	String printSubjectList()
	{
		String returnStr = "";
		for(int i = 0 ; i< semestersList.size(); i++)
		{
			returnStr = returnStr.concat("Przedmioty wybrane w semestrze " + i + " :\n");
			returnStr = returnStr.concat(semestersList.get(i).printSubjects());
		}
		return returnStr;
	}
}
