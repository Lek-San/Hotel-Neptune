package fr.simplon.neptunians.Hotel_Neptune;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BackofficeController extends BackToController {
	
	@FXML
	public TableView<Type> display_table;
	@FXML
	public TableColumn<Type, Integer> col_id_type;
	@FXML
	public TableColumn<Type, String> col_name_type;
	
	// Apparement, pour créer des lignes dans un tableau avec javafx on doit utiliser la méthode setItems qui prend comme paramètre une ObservableList et c'est tout.
	ObservableList<Type> typeObsList = FXCollections.observableArrayList();
	
	public void displayTypes(ActionEvent event) {
		
		// On instancie la classe qui gère la connexion (classe que j'ai créé, pas le framework) et on appelle la méhode pour stocker le résultat de cette connexion dans connectDB
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
		
		try {
			// ResultSet c'est le résultat, similaire à un tableau, de ma requête sql. Pour l'obtenir on doit créer un statement car c'est dans l'instance de cette classe que se trouve la méthode permettant de faire une requête sql.
			ResultSet typeSet = connectDB.createStatement().executeQuery("SELECT * FROM type");
			
			while (typeSet.next()) {
				typeObsList.add(new Type(typeSet.getInt("id_type"), typeSet.getString("type_name")));
				System.out.println(typeSet.getInt("id_type"));
				System.out.println(typeSet.getString("type_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		col_id_type.setCellValueFactory(new PropertyValueFactory<Type, Integer>("id_type"));
		col_name_type.setCellValueFactory(new PropertyValueFactory<Type, String>("type_name"));
		
		display_table.setItems(typeObsList);
		
	}
}
