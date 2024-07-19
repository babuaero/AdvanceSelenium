package dataDrivenTesting;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;


public class InsertDataToDataBase {

	public static void main(String[] args) throws Throwable {
		//Step1:- Register/ load the mysql database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//step2:-get connection to database
		Connection conn = DriverManager.getConnection("jdbc:Mysql://127.0.0.1:3306/students_details","root" ,"Lakshana@12");

		//step3:- create Sql statement
		Statement state = conn.createStatement();
        String query = "insert into student(first_name,last_name,address)values('rathin','reddy','blre')";

        int result = state.executeUpdate(query);
   if(result==1)
   {
	   System.out.println("data is updated");
   }
   else
   {
	   System.out.println("data not updated");
   }
   conn.close();   


	}

}
