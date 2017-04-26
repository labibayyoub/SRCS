package fr.upmc.database;

import java.sql.*;
import java.util.Scanner;


public class TestDB {

	public static void main(String[] args) throws SQLException {
		// String driver = "org.apache.derby.jdbc.EmbeddedDriver";
		
		String connectionURL = "jdbc:derby:/home/labibayyoub/javaEE/glassfish4/javadb/lib/firstdb";
		Connection conn = DriverManager.getConnection(connectionURL);
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery("select * from ELEVE");
		while (res.next()) {
			System.out.println(res.getString(2));
		}
		
		Scanner s1 = new Scanner(System.in);
		int i = 1;
		while (i !=0) {
			System.out.println("***********************");
			System.out.println("* 1.afficher la table *" + "\n* 2.insert            *" + "\n* 3.delete            * "
					+ "\n* 4.quit              *");
			System.out.println("***********************");
			
			switch (s1.nextInt()) {
			case 1:
				 res = s.executeQuery("select * from ELEVE");
				 System.out.println();
				while (res.next()) {
					System.out.print(res.getString(2));
					System.out.println(" "+res.getString(3));
				}
				System.out.println();
				
				break;
			case 2:
				String query="INSERT INTO ELEVE VALUES ("+i+",";
				System.out.println("nom:");
				query+="'"+s1.next()+"',";
				System.out.println("prenom:");
				query+="'"+s1.next()+"')";
				PreparedStatement r = conn.prepareStatement(query);	
				System.out.println(r.executeUpdate()+"ligne(s) ajoutée(s)"
						+ "");
				
				

				break;
			case 3:

				break;
			default:
				System.out.println("quit");
				res.close();
				s1.close();
				i = -1;
			}
			i++;
			
			
		}

	}

}
