package com.DataBase.connect.DataBaseProject;

import com.DataBase.connect.DataBaseProject.Person.Person;
import com.DataBase.connect.DataBaseProject.Person.PersonRepository;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DataBaseProjectApplication {

	public static void main(String[] args)
	{
		ConfigurableApplicationContext context=SpringApplication.run(DataBaseProjectApplication.class, args);
		//EmpRepository empRepository=context.getBean(EmpRepository.class);// IOC Inversion Of Control
//		Users users=new Users();
//		users.setUserid(102);
//		users.setUsername("Veer");
//		userRepository.save(users);
		//-----------------------------------------------------------------------
		//ConfigurableApplicationContext context=SpringApplication.run(DataBaseProjectApplication.class, args);
		//EmpRepository empRepository=context.getBean(EmpRepository.class);// IOC Inversion Of Control
//		Employee emp=new Employee();
//		emp.setEmpid(101);
//		emp.setEmpName("Veer");
//		emp.setSalary(5000);
//		empRepository.save(emp);

		java.util.Scanner sc=new java.util.Scanner(System.in);
		System.out.print("Enter Serial number : ");
		int id=sc.nextInt();
		System.out.print("Enter your name : ");
		sc.nextLine();
		String name=sc.nextLine();
		System.out.print("Enter your Salary : ");
		int sal=sc.nextInt();
		PersonRepository personRepository=context.getBean(PersonRepository.class);
		Person person=new Person();
		person.setSrno(id);
		person.setName(name);
		person.setSalary(sal);
		personRepository.save((person));
	}

}
