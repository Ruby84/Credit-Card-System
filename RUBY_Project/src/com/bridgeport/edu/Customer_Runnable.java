package com.bridgeport.edu;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import model.transaction;

import com.bridgeport.edu.dao.TransactionDao;
import com.bridgeport.edu.dao.dbconnection_abstract;

public class Customer_Runnable extends dbconnection_abstract {

	public void custDetails() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, IOException,
			SQLException {
		// TODO Auto-generated method stub

		myconnection();

		Scanner sc = new Scanner(System.in);
		
		System.out.println("");

		
		System.out.println("ENTER SSN NUMBER:");

		int ssnNo = sc.nextInt();
		System.out.println("PLEASE ENTER FIRST NAME TO UPDATE:");

		String firstName = sc.nextLine();
		
		System.out.println("PLEASE  MIDDLE_NAME TO UPDATE:");

		String middleName = sc.nextLine();
		
		
		System.out.println("PLEASE  LAST_NAME TO UPDATE:");

		String lastName = sc.nextLine();
		
		

		TransactionDao td = new TransactionDao();

		transaction mytransaction = td.getCustDetails(ssnNo, firstName,middleName,lastName);
	}

	// To check the existing account details of a customer

	public void checkCustDetails() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, IOException,
			SQLException {
		// TODO Auto-generated method stub

		myconnection();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter SSN To Check: ");

		int type = sc.nextInt();

		TransactionDao td = new TransactionDao();

		transaction mytransaction = td.getCustDetails1(type);

	}

	public void getMonthDetailsByCC() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, IOException,
			SQLException {
		// TODO Auto-generated method stub

		myconnection();

		Scanner sc = new Scanner(System.in);

		System.out.println("enter CreditCardNo:");

		String type3 = sc.nextLine();

		System.out.println("Please enter  Month:");

		int type1 = sc.nextInt();

		System.out.println("Please Enter Year:");

		int type2 = sc.nextInt();

		TransactionDao td = new TransactionDao();

		transaction mytransaction = td.getTotalTransactionByMonth(type3, type1,
				type2);

	}

	public void getTransDetailsByDate() throws InstantiationException,
			IllegalAccessException, ClassNotFoundException, IOException,
			SQLException, ParseException {
		// TODO Auto-generated method stub

		myconnection();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Date1:");

		String date1 = sc.nextLine();

		java.sql.Date javaSqlDate1 = java.sql.Date.valueOf(date1);

		System.out.println("Enter Date2:");

		String date2 = sc.nextLine();

		java.sql.Date javaSqlDate2 = java.sql.Date.valueOf(date2);

		TransactionDao td = new TransactionDao();

		transaction mytransaction = td.getTotalTransactionByTwoDate(javaSqlDate1, javaSqlDate2);

	}

}
