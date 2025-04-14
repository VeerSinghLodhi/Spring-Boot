package com.database2.database2;

import com.database2.database2.Students.Student;
import com.database2.database2.Students.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.JOptionPane;

@SpringBootApplication
public class Database2Application {

	public static void main(String[] args) {

	ConfigurableApplicationContext context= SpringApplication.run(Database2Application.class, args);
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
	}

}
