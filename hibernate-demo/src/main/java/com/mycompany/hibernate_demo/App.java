package com.mycompany.hibernate_demo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.hibernate_demo_crud_demo.dao.EmployeeDAO;
import com.mycompany.hibernate_demo_crud_demo.dao.EmployeeDAOImpl;
import com.mycompany.hibernate_demo_crud_demo.model.Employee;
import com.mycompany.hibernate_demo_crud_demo.shared.SharedEmployee;
import static java.lang.System.in;

/**
 * Hello world!
 *
 */
public class App {
	private static Scanner scanner = new Scanner(in);

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAOImpl();
		try {
			int choice = 0;
			do {

				System.out.println("1. create Employee");
				System.out.println("2. Display all Employee");
				System.out.println("3. Find Employee by id");
				
				System.out.println("4. Find Employee by Custom id");
				System.out.println("5. Delete Employee");
				
				System.out.println("Enter your choice : ");
				choice = scanner.nextInt();
				switch (choice) {
				case 1:
					
					System.out.print("First Name: ");
					String fName=scanner.next();
					System.out.print("Last Name: ");
					String lName=scanner.next();
					System.out.print("Email: ");
					String email=scanner.next();
					  dao.createEmployee(new SharedEmployee(fName,lName,email));
					  System.out.println("inserted");
					 		
					break;
				case 2:
					List<SharedEmployee> se=dao.getAllEmployee();
		        	for(SharedEmployee see:se)
		        	{
		        		System.out.println(see);
		        	}
		        	
		        	break;
				case 3:
					System.out.print("enter employee id: ");
					int id=scanner.nextInt();
					SharedEmployee sEmployee=dao.findById(id);
					if(sEmployee==null)
					{
						System.out.println("no such record found.");
					}
					else {
						System.out.println(sEmployee);
					}

					break;
				case 4:
					System.out.println("custom id: ");
					String cid=scanner.next();
					dao.findByCustomId(cid);
					break;
				case 5:
					System.out.print("enter employee id: ");
					id=scanner.nextInt();
					dao.deleteEmployee(id);
					break;
				default:
					break;
				}
				
			} while (choice != 0);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
