package fr.simplon.neptunians.Hotel_Neptune;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
public class ReservationController implements Initializable {

	@FXML
	VBox container;
	
	DatabaseConnection db = new DatabaseConnection();
	Connection connectDB = db.getConnection();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			Statement statement = connectDB.createStatement();
			ResultSet roomSet = statement.executeQuery("SELECT room.id_room, type.type_name, room.single_bed, room.double_bed FROM room INNER JOIN type WHERE room.id_type = type.id_type");
			
			while (roomSet.next()) {
				 Text roomId = new Text();
					roomId.setText("Identifiant " + roomSet.getInt("id_room"));
					Text roomType = new Text();
					roomType.setText("Type " + roomSet.getString("type_name"));
					Text roomNbDoubleBeds = new Text();
					roomNbDoubleBeds.setText("Nombre lits doubles " + roomSet.getInt("double_bed"));
					Text roomNbSingleBeds = new Text();
					roomNbSingleBeds.setText("Nombre lits simples " + roomSet.getInt("single_bed"));
					
					GridPane roomGrid = new GridPane();
					roomGrid.setPadding(new Insets(20));
					roomGrid.add(roomId, 0, 0);
					roomGrid.add(roomType, 0, 1);
					roomGrid.add(roomNbDoubleBeds, 0, 2);
					roomGrid.add(roomNbSingleBeds, 0, 3);
					
					container.getChildren().add(roomGrid);
			}
			
		} catch (Exception ex) {
			
		}
		
		
	}


	
}
