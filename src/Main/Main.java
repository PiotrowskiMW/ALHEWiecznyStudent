package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		Algorithm algorithm = new Algorithm();
		String path = "input.txt";
//		if(args[0] != null)
//		{
//			path = args[0];
//		}
		
		try (Scanner input = new Scanner(new File(path))) {
            String line;
            while(input.hasNextLine())
            {
            	//format pliku wejściowego: 
            	//- przedmiot: sub:NazwaPrzedmiotu:LiczbaPunktów:LiczbaDniNauki
            	//- parametry: params:LiczbaDostępnychDniWSemestrze:liczbaSemestrów:LiczbaPunktów do zdobycia
               line = input.nextLine();
               String[] tokens = line.split(":");
               if(tokens[0].equals("sub"))
               {
            	   algorithm.subjectsList.add(new Subject(tokens[1],Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3])));
               }
               if(tokens[0].equals("params"))
               {
            	   algorithm.daysAvaliableInSemester = Integer.parseInt(tokens[1]);
            	   algorithm.numberOfSemesters = Integer.parseInt(tokens[2]);
            	   algorithm.numberOfRequiredPoints = Integer.parseInt(tokens[3]);
               }   
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		algorithm.findBestSubjectsList();
		System.out.print("Lista przedmiotów \n" + algorithm.printSubjectList());
		
	}
}
