import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateDataBase {

	public static void createdb()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
			String q = "CREATE DATABASE hospital";
			PreparedStatement pst = con.prepareStatement(q);
			int status= pst.executeUpdate();
			if(status==1)
			{
				System.out.println("DB created");
			}
			else
			{
				System.out.println("DB not created");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void createTbl()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "");
			String q = "CREATE TABLE `hospital`.`doctors` (`id` INT(4) NOT NULL AUTO_INCREMENT , `Name` VARCHAR(50) NOT NULL , `Edu` VARCHAR(50) NOT NULL , `salary` INT(20) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB";
			PreparedStatement pst = con.prepareStatement(q);
			int status= pst.executeUpdate();
			if(status==1)
			{
				System.out.println("table created");
			}
			else
			{
				System.out.println("Table not created");
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//createdb();
		createTbl();
	}

}
