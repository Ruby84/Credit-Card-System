# Credit-Card-System

## First_Folder: Ruby Project folder,using Java



### Operational Database 

2.1.1 Transaction Details Module AND 2.1.2. Customer Details Module 
Program has been created in eclipse using Java language:
Functions:
1. displays the transactions made by customers living in a given zipcode for a given month and year. Order by day in descending order.
2. displays the number and total values of transactions for a given type. 
3. displays the number and total values of transactions for branches in a given state 
4. checks the existing account details of a customer. 
5. modifies the existing account details of a customer 
6. generates monthly bill for a credit card number for a given month and year. 
7. displays the transactions made by a customer between two dates. Order by year, month, and day in descending order. 

## Second_Folder: ETLofData_Project folder, in Hadoop environment

###ETL of Data 


2.2.1. Data Extraction and Transportation Module 

created four different staging tables in order to import data from RDBMS into HDFS using sqoop job.
transformed the data based on requirements found in the Mapping Document prior to loading the data into Hadoop. 
Those tables are:

1. CDW_SAPP_BRANCH
2. CDW _SAPP_CREDITCARD 
3. CDW_SAPP_TIME?4.CDW_SAPP_CUSTOMER 


2.2.2. Data Loading with Hive 

loaded  data from HDFS into Hive(target tables).
Target tables are called:

1.CDW_SAPP_D_BRANCH
2.CDW_SAPP_F_CREDIT_CARD
3.CDW_SAPP_D_CUSTOMER
4.CDW_SAPP_D_TIME



2.2.3. Automating the Process with Oozie 

Create an unoptimized Oozie Workflow that automated the processes of steps 2.2.1 and 2.2.2 and loaded data into new tables in Oozie. 

Created  two Oozie, one Oozie without coordinator and another one with coordinator.
Target-dir are:

1. CDW_SAPP_BRANCH
2. CDW_SAPP_CREDITCARD
3. CDW_SAPP_CUSTOMER
4. CDW_SAPP_TIME

Created jobs are:

1. CDW_SAPP_BRANCH_Oozie
2. CDW_SAPP_CREDITCARD_Oozie
3. CDW_SAPP_CUSTOMER_Oozie
4. CDW_SAPP_TIME_Oozie

In Hive created target tables to load data into them.

These table are:

1. CDW_SAPP_D_BRANCH_Oozie
2. CDW_SAPP_F_CREDIT_CARD_Oozie
3. CDW_SAPP_D_CUSTOMER_Oozie
4. CDW_SAPP_D_TIME_Oozie


2.2.4. Process Optimization Module 


Created a new Oozie workflow similar to the process of 2.2.3 using swoop job Meta for all tables.

Modified the Oozie Coordinator to use the new optimized workflow.
This time, however, Sqoop only imports new data. 

Target-dir are:

1. CDW_SAPP_BRANCH
2. CDW_SAPP_CREDITCARD
3. CDW_SAPP_CUSTOMER

Created jobs are:

1. Branch_optimized
2. CreditCard_optimized
3. Customer_optimized

Hive should then import only that new data.
Original data should not be deleted in this process. 

Hive, stage and target, optimized tables that we load and/or insert data into are:

1. CDW_SAPP_D_BRANCH_Oozie_optimized
2. CDW_SAPP_F_CREDIT_CARD_Oozie_optimized
3. CDW_SAPP_stage_CREDIT_CARD_Oozie_optimized
4. CDW_SAPP_D_TIME_Oozie_optimized
5. CDW_SAPP_D_CUSTOMER_Oozie_optimized



2.2.5
Used Hive Query and Hive Visualization tool to visualize in Ambari:
1) The top 20 zip codes(hint: branch_zip) by total transaction value 
2) Total transaction value for each transaction type by Quarter in 2018 


