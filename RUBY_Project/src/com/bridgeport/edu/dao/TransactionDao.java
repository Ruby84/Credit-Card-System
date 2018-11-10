package com.bridgeport.edu.dao;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.transaction;

public class TransactionDao extends dbconnection_abstract {

	public final static String totaByType = "select sum(transaction_value), count(*)  from CDW_SAPP_CREDITCARD   where TRANSACTION_TYPE = ?  GROUP by TRANSACTION_TYPE";

	public final static String totalByState = "select sum(TRANSACTION_VALUE),count(*) from CDW_SAPP_CREDITCARD  inner join CDW_SAPP_BRANCH on CDW_SAPP_CREDITCARD.BRANCH_CODE=CDW_SAPP_BRANCH.BRANCH_CODE where BRANCH_STATE=? group by CDW_SAPP_BRANCH.BRANCH_NAME";

	public final static String sqlQuery = "SELECT sum(TRANSACTION_VALUE) ,count(*) FROM CDW_SAPP_CREDITCARD WHERE CREDIT_CARD_NO=?  AND MONTH=?  AND YEAR=?";

	public final static String checkAccNo = "select *from  CDW_SAPP_CUSTOMER where SSN=?";

	public transaction getTransDetails(int zipcode, int month, int year)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {

		myconnection();

		String sqlQuery = "select *from CDW_SAPP_CREDITCARD as cc  right join  CDW_SAPP_CUSTOMER as c"
				+ " on cc.CREDIT_CARD_NO=c.CREDIT_CARD_NO where c.CUST_ZIP =" + zipcode + "  and  MONTH =" + month
				+ " and YEAR =" + year + " order by DAY desc";

		ps = con.prepareStatement(sqlQuery);

		ResultSet rs = ps.executeQuery();

		int count = 0;

		while (rs.next()) {

			System.out.println(rs.getInt(1) + "\t" + rs.getInt(2) + "\t" + rs.getInt(3) + "\t" + rs.getInt(4) + "\t"
					+ rs.getString(5) + "\t" + rs.getInt(6) + "\t" + rs.getInt(7) + "\t" + rs.getString(8) + "\t"
					+ rs.getFloat(9));
			count++;
		}
		System.out.println("Total records Fetched  :" + count);

		return null;
	}

	public transaction gettotalbyType(String type)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {

		myconnection();

		ps = con.prepareStatement(totaByType);

		ps.setString(1, type);

		rs = ps.executeQuery();

		transaction t = new transaction();
		int count = 0;

		while (rs.next()) {

			count++;
			t.setValue(rs.getInt(1));

			t.setCount(rs.getInt(2));

			return t;
		}
		if (count >= 0) {
			System.out.println("invalid type");
		}
		return t;

	}

	public transaction getTotalByState(String type)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {

		myconnection();

		ps = con.prepareStatement(totalByState);

		ps.setString(1, type);

		rs = ps.executeQuery();

		transaction t = new transaction();

		int count = 0;
		while (rs.next()) {

			count++;
			t.setValue(rs.getInt(1));

			t.setCount(rs.getInt(2));

			return t;
		}
		if (count <= 1) {
			System.out.println("Not matched");
		}
		return t;
	}

	public transaction getCustDetails(int ssnNo, String firstName, String middleName, String lastName)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub
		myconnection();

		// ps= con.prepareStatement(checkAccNo);

		String sqlQuery = "update CDW_SAPP_CUSTOMER set FIRST_NAME=?, MIDDLE_NAME=?,LAST_NAME=?  where SSN=?";

		ps = con.prepareStatement(sqlQuery);

		ps.setString(1, firstName);

		ps.setString(2, middleName);
		ps.setString(3, lastName);
		ps.setInt(4, ssnNo);

		if (ps.executeUpdate() != 0) {

			System.out.println("successfully updated");

		} else {

			System.out.println("Failed to update");
		}
		return null;
	}

	// To check the existing account details of a customer
	public transaction getCustDetails1(int type)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub

		myconnection();

		//String sqlQuery = "select *from  CDW_SAPP_CUSTOMER where SSN=?";

		ps = con.prepareStatement(checkAccNo);

		ps.setInt(1, type);

		ResultSet rs = ps.executeQuery();

		System.out.println("");

		int total = 0;

		while (rs.next()) {

			System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4)
					+ "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7) + "\t" + rs.getString(8)
					+ "\t" + rs.getString(9) + "\t" + rs.getString(10) + "\t" + rs.getInt(11) + "\t" + rs.getString(12)
					+ "\t" + rs.getString(13) + "\t" + rs.getDate(14));
			total++;

		}
		if (total >= 1) {

			System.out.println("Record Found");

		} else {
			System.out.println("Record Not Found");
		}
		System.out.println("Total Matched Records=" + total);

		return null;
	}

	public transaction getTotalTransactionByMonth(String type3, int type1, int type2)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		// TODO Auto-generated method stub

		myconnection();

		ps = con.prepareStatement(sqlQuery);

		ps.setString(1, type3);

		ps.setInt(2, type1);

		ps.setInt(3, type2);

		ResultSet rs = ps.executeQuery();

		transaction t = new transaction();

		if (rs.next()) {

			t.setValue(rs.getInt(1));

			t.setCount(rs.getInt(2));

			return t;
		}

		return null;
	}

	public transaction getTotalTransactionByTwoDate(Date javaSqlDate1, Date javaSqlDate2)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {

		myconnection();

		
		
		String Query="select *  from  CDW_SAPP_CREDITCARD as cc  join  CDW_SAPP_CUSTOMER as c on  cc.CREDIT_CARD_NO=c.CREDIT_CARD_NO where (DATE(LAST_UPDATED) between ? and  ?) ";
		
		PreparedStatement ps = con.prepareStatement(Query);
		
		ps.setDate(1, javaSqlDate1);
		ps.setDate(2, javaSqlDate2);


		ResultSet rs = ps.executeQuery();

		int total = 0;

		System.out.println("TRANSACTION_ID" + "\t" + "DAY");

		System.out.println(".............." + "\t" + "........");

		while (rs.next()) {
			total++;
			
			
			System.out.println(rs.getInt(1) + "\t" + rs.getInt(2) + "\t"
					+ rs.getInt(3) + "\t" + rs.getInt(4) + "\t"
					+ rs.getString(5) + "\t" + rs.getInt(6) + "\t"
					+ rs.getInt(7) + "\t" + rs.getString(8) + "\t"
					+ rs.getFloat(9));
		}
		System.out.println("Total records selected:" + total);

		return null;
	}

}
