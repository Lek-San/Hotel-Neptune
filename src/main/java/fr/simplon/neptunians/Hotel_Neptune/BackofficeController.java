package fr.simplon.neptunians.Hotel_Neptune;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BackofficeController extends BackToController {
// TEEEEEEEST
	@FXML
	public TableView<Type> display_table;
	@FXML
	public TableColumn<Type, Integer> col_id_type;
	@FXML
	public TableColumn<Type, String> col_name_type;

	// Apparement, pour créer des lignes dans un tableau avec javafx on doit
	// utiliser la méthode setItems qui prend comme paramètre une ObservableList et
	// c'est tout.
	ObservableList<Type> typeObsList = FXCollections.observableArrayList();

	public void displayTypes(ActionEvent event) {

		// On instancie la classe qui gère la connexion (classe que j'ai créé, pas le
		// framework) et on appelle la méhode pour stocker le résultat de cette
		// connexion dans connectDB
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();

		try {
			// ResultSet c'est le résultat, similaire à un tableau, de ma requête sql. Pour
			// l'obtenir on doit créer un statement car c'est dans l'instance de cette
			// classe que se trouve la méthode permettant de faire une requête sql.
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

		addButtonColumn();

		display_table.setItems(typeObsList);

	}

	public void addButtonColumn() {
		TableColumn<Type, Void> colBtn = new TableColumn("Button Column");
		
		// Interface fonctionnelle!!!! Premier paramètre générique est le type de l'objet passé à la méthode call. Le second est la valeur de retour. ICI on passe la colonne (TableColumn) pour lui retourner des cellules (TableCell)
		Callback<TableColumn<Type, Void>, TableCell<Type, Void>> cellFactory = new Callback<TableColumn<Type, Void>, TableCell<Type, Void>>() {

			@Override
			public TableCell<Type, Void> call(TableColumn<Type, Void> param) {
				// TODO Auto-generated method stub
				TableCell<Type, Void> cell = new TableCell<Type, Void>() {
					// Création du bouton
					private final Button btn = new Button("Bouton");
					{
						// Définition de l'événement lié au bouton créé
						btn.setOnAction((ActionEvent event) -> {
							Type type = getTableView().getItems().get(getIndex());
							System.out.println("selectedData: " + type);

						});
					}
					@Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
				};
				return cell;
			}
			
		};
		
		colBtn.setCellFactory(cellFactory);
		display_table.getColumns().add(colBtn);
		
	}

//	public <T> void addButtonColumn() {
//		TableColumn<T, Void> colBtn = new TableColumn("Button Column");
//
//		// Interface fonctionnelle!!!! Premier paramètre générique est le type de
//		// l'objet passé à la méthode call. Le second est la valeur de retour. ICI on
//		// passe la colonne (TableColumn) pour lui retourner des cellules (TableCell)
//		Callback<TableColumn<T, Void>, TableCell<T, Void>> cellFactory = new Callback<TableColumn<T, Void>, TableCell<T, Void>>() {
//
//			@Override
//			public TableCell<T, Void> call(TableColumn<T, Void> param) {
//				// TODO Auto-generated method stub
//				TableCell<T, Void> cell = new TableCell<T, Void>() {
//					// Création du bouton
//					private final Button btn = new Button("Bouton");
//					{
//						// Définition de l'événement lié au bouton créé
//						btn.setOnAction((ActionEvent event) -> {
//							T type = getTableView().getItems().get(getIndex());
//							System.out.println("selectedData: " + type);
//
//						});
//					}
//
//					@Override
//					public void updateItem(Void item, boolean empty) {
//						super.updateItem(item, empty);
//						if (empty) {
//							setGraphic(null);
//						} else {
//							setGraphic(btn);
//						}
//					}
//				};
//				return cell;
//			}
//
//		};
//
//		colBtn.setCellFactory(cellFactory);
//		display_table.getColumns().add(colBtn);
//
//	}
}
