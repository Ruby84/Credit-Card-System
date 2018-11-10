package com.bridgeport.edu;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import model.transaction;

import com.bridgeport.edu.dao.TransactionDao;
import com.bridgeport.edu.dao.dbconnection_abstract;

public class Tranaction_runnable extends dbconnection_abstract {

	public void getTotalByType() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, IOException,
			SQLException {

		myconnection();

		System.out.println("Education\n " + "Entertainment" + "\n" + "Grocery"
				+ "\n" + "Gas" + "\n" + "Bills" + "\n" + "Gas" + "\n"
				+ "Healthcare" + "\n" + "Test");

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter  Transaction_Type:");

		String type = sc.nextLine();

		TransactionDao td = new TransactionDao();
		transaction mytransaction = td.gettotalbyType(type);

	}

	public void getTotalByState() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, IOException,
			SQLException {

		myconnection();

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Branch_State:");

		String type = sc.nextLine();

		TransactionDao td = new TransactionDao();

		transaction mytransaction1 = td.getTotalByState(type);
	}

	public void getTransDetailsByZipCode() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, IOException,
			SQLException {

		myconnection();

		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Zipcode:");
		int Zipcode = sc.nextInt();

		System.out.println("Please Enter MONTH:");
		int month = sc.nextInt();

		System.out.println("Please Enter YEAR:");
		int year = sc.nextInt();

		TransactionDao td = new TransactionDao();

		transaction mytransaction1 = td.getTransDetails(Zipcode, month, year);

	}

}
