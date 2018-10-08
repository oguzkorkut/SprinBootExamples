package com.okorkut.derby;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.okorkut.derby.config.DBCreater;

@SpringBootApplication
@Configuration
@ComponentScan(basePackageClasses = SpringBootDerbyApplication.class)
@EnableAutoConfiguration
//@EnableConfigurationProperties(UserProperties.class)
public class SpringBootDerbyApplication {

	
	public static String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	public static String JDBC_URL = "jdbc:derby:okorkut:create=true";
	
//	@Autowired
//	private static DBCreater dbCreater;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDerbyApplication.class, args);
		
		try {
			createDB();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	static void createDB() throws Exception{
//		try {
//			Class.forName(DRIVER);
//			Connection connection =  DriverManager.getConnection(JDBC_URL);
//
//			connection.createStatement().execute("CREATE TABLE users (id INTEGER PRIMARY KEY, name VARCHAR(30), email  VARCHAR(50))");
//			
//			connection.createStatement().execute("INSERT INTO users VALUES (1, 'mkyong', 'mkyong@gmail.com'), (2, 'alex', 'alex@yahoo.com'),(3, 'joel', 'joel@gmail.com')");
//			
//			
//			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//			EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.DERBY).addScript("db/sql/create-db.sql").addScript("db/sql/insert-data.sql").build();
//			
//			db.getConnection();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
			
		    
		
//			String driver = "org.apache.derby.jdbc.EmbeddedDriver";
//		    String dbName = "AddressBookDB";
//		    String connectionURL = "jdbc:derby:" + dbName + ";create=true";
//		    String createString = "CREATE TABLE IF NOT EXISTS  ADDRESSBOOKTbl (NAME VARCHAR(32) NOT NULL, ADDRESS VARCHAR(50) NOT NULL)";
//		    Class.forName(driver);
//
//		    Connection conn = DriverManager.getConnection(connectionURL);
//
//		    Statement stmt = conn.createStatement();
//		    stmt.executeUpdate(createString);
//
//		    PreparedStatement psInsert = conn
//		        .prepareStatement("insert into ADDRESSBOOKTbl values (?,?)");
//
//		    psInsert.setString(1, "ww");
//		    psInsert.setString(2, "ddd");
//
//		    psInsert.executeUpdate();
//
//		    Statement stmt2 = conn.createStatement();
//		    ResultSet rs = stmt2.executeQuery("select * from ADDRESSBOOKTbl");
//		    System.out.println("Addressed present in your Address Book\n\n");
//		    int num = 0;
//
//		    while (rs.next()) {
//		      System.out.println(++num + ": Name: " + rs.getString(1) + "\n Address"
//		          + rs.getString(2));
//		    }
//		    rs.close();
	}
}
