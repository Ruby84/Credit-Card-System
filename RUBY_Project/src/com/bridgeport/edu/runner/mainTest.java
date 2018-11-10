package com.bridgeport.edu.runner;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

import com.bridgeport.edu.Customer_Runnable;
import com.bridgeport.edu.Tranaction_runnable;

public class mainTest {

	public static void main(String[] args) throws SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, IOException, ParseException {

		Tranaction_runnable tr;
		Customer_Runnable cr;
		Scanner scn = new Scanner(System.in);

		String input;
		do {
			System.out.println("******Available options***");

			System.out
					.println("1) To display the transactions made by customers living in a given zipcode for a given month and year. "
							+ "Order by day in descending order. "
							+ "\n"
							+

							"2) To display the number and total values of transactions for a given type."
							+ "\n"
							+

							"3) To display the number and total values of transactions for branches in a given state"
							+ "\n"
							+

							"4) To check the existing account details of a customer."
							+ "\n"
							+

							"5) To modify the existing account details of a customer"
							+ "\n"
							+

							"6)To generate monthly bill for a credit card number for a given month and year."
							+ "\n"
							+

							"7) To display the transactions made by acustomer between two dates. Order by year,month, and day in descending order."
							+ "\n" + "8)Exist");

			System.out.println("Enter your Choice");
			Scanner sc = new Scanner(System.in);
			String choice = sc.nextLine();
			int value = 0;

			try {
				value = Integer.parseInt(choice);
			} catch (NumberFormatException e) {
				System.out
						.println("Wrong Input given please give Numbers 1 to 8");
				//e.printStackTrace();

			}
			switch (value) {
			case 1:
				tr = new Tranaction_runnable();
				tr.getTransDetailsByZipCode();

				break;

			case 2:
				tr = new Tranaction_runnable();
				tr.getTotalByType();
				break;

			case 3:
				tr = new Tranaction_runnable();
				tr.getTotalByState();
				break;

			case 4:
				cr = new Customer_Runnable();
				cr.checkCustDetails();
				break;
			case 5:
				cr = new Customer_Runnable();
				cr.custDetails();

				break;

			case 6:
				cr = new Customer_Runnable();
				cr.getMonthDetailsByCC();

				break;
			case 7:
				cr = new Customer_Runnable();
				cr.getTransDetailsByDate();

				break;

			case 8:
				System.out.println("exit");
				scn.close();
				System.exit(0);

			default:

				System.out.println("wrong choice");

				break;

			}
			System.out.println("do you want to continue to   Yes/no");
			input = sc.nextLine();
		}

		while (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y"));

	}

}

