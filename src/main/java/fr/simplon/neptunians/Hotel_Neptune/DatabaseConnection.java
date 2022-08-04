package fr.simplon.neptunians.Hotel_Neptune;

import java.sql.Connection;
import java.sql.DriverManager;

// Cette classe va retourner permettre de retourner un objet de type Connection lequel représente la connexion à la base de données.
public class DatabaseConnection {
	
	public Connection databaseLink;
	
	// Un simple getter, unique méthode de ma classe.
	public Connection getConnection() {
		// Les informations de connexion de ma base de données.
		String databaseName = "hotel_neptune";
		String databaseUser = "root";
		String databasePassword = "";
		String url = "jdbc:mysql://localhost/" + databaseName;
		
		// Try catch obligatoire pour gérer les échecs de connection à mysql.
		try {
			// Je crois que c'est un truc de sécurité...
			Class.forName("com.mysql.cj.jdbc.Driver");
			// C'est la méthode getConnection de l'interface DriverManager qui va vraiment gérer la co avec la base de données.
			databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return databaseLink;
	}
	
}
