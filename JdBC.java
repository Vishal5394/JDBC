package com.BridgeLabz.jdbc;


package com.BridgeLabz.jdbc;

import java.sql.*;

public class ReadOperation 
{
    public static void main(String[] args) throws SQLException 
    {
        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String user = "root";
        String password = "Vishal5394#";
        // get a connection to database
        Connection connection = DriverManager.getConnection(url, user, password);
        // create a statement
        try (Statement statement = connection.createStatement()) 
        {
            String query2 = " UPDATE employee_payroll  set Emp_BasicPay = '14000', Emp_deduction='1000',Emp_TaxablePay='500', Emp_IncomeTax = '0', Emp_NetPay= 13500 where Emp_Id=10;";
            statement.executeUpdate(query2);
            System.out.println("Updation complete");
            
            // execute SQL query
            String query = "SELECT * FROM employee_payroll;";
            ResultSet resultSet = statement.executeQuery(query);
            // process the result set
            while (resultSet.next()) 
            {
                System.out.println(resultSet.getInt(1) + "  " + resultSet.getString(2) + "  " + resultSet.getString(3)+"   "
                          + resultSet.getString(4)+"  "+ resultSet.getString(5)+"  "+ resultSet.getString(6)+"   "+ resultSet.getString(7)
                             + "  "+ resultSet.getString(8)+"  "+ resultSet.getString(9)+ "  "+ resultSet.getString(10)+ "  "+ resultSet.getString(11)+ "  "+ resultSet.getString(12));
            }
        }
    }
}
