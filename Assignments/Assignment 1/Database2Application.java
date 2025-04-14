package com.database2.database2;

import com.database2.database2.Assignment.Marksheet;
import com.database2.database2.Assignment.markSheetRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Database2Application {

	public static void main(String[] args) {

	ConfigurableApplicationContext context= SpringApplication.run(Database2Application.class, args);
	markSheetRepository markSheetRepository=context.getBean(markSheetRepository.class);
	java.util.Scanner scanner=new java.util.Scanner(System.in);
	System.out.print("Enter Admission No : ");
	int admno=scanner.nextInt();
	System.out.print("Enter Student Name : ");
	scanner.nextLine();
	String name=scanner.nextLine();
	System.out.print("Enter marks 1 : ");
	double m1= scanner.nextDouble();
	System.out.print("Enter marks 2 : ");
	double m2= scanner.nextDouble();
	double total=m1+m2;
	double avg=total/2;
	String result;
	if(avg>=33)
		result="Pass";
	else
		result="Fail";
	System.out.println("Total : "+total);
	System.out.println("Average : "+avg);
	System.out.println("Result : "+result);
	Marksheet marksheet=new Marksheet();
	marksheet.setAdmno(admno);
	marksheet.setName(name);
	marksheet.setMark1(m1);
	marksheet.setMark2(m2);
	marksheet.setTotal(total);
	marksheet.setAverage(avg);
	marksheet.setResult(result);
	markSheetRepository.save(marksheet);
	System.out.println("=====================================");
	System.out.println("Saved!");
	System.out.println("=====================================");
	}

}






/*
StudentRepository studentRepository=context.getBean(StudentRepository.class);
		java.util.Scanner scanner=new java.util.Scanner(System.in);
		System.out.print("Enter student roll no : ");
		int rollno=scanner.nextInt();
		System.out.print("Enter Student Name : ");
		scanner.nextLine();
		String name=scanner.nextLine();
		System.out.print("Enter Student Gender : ");
		String gender=scanner.nextLine();
		Student student=new Student(rollno,gender,name);
		studentRepository.save(student);
		System.out.println("New Student Added");
//		JOptionPane.showMessageDialog(null,"Saved");
*/

