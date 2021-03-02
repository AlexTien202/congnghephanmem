package QLBH;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.util.List;

import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.function.Predicate;


import javax.persistence.criteria.CriteriaQuery;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;
import QLBH.Nhanvien;


public class CalamNVController implements Initializable {

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private ComboBox<String> Listnhanvien;


    
    @FXML
    private GridPane grid;

    @FXML
    void ListNhanvien(ActionEvent event) throws Exception {
    	if(Listnhanvien.getValue()=="Danh sách nhân viên") {
    		Parent calamnhanvien = FXMLLoader.load(getClass().getResource("danhsachnhanvien.fxml"));
    		Scene calam_scene = new Scene(calamnhanvien);
    		Stage calam_stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
    		calam_stage.setScene(calam_scene);
    		calam_stage.show();
    	}
    }
   
    
/*    private void setCellValueFromTabletoTexfField() {
    	 tableNV.setOnMouseClicked(event -> {
    		 Nhanvien nv = tableNV.getItems().get(tableNV.getSelectionModel().getSelectedIndex());
    		 tennhanvien.setText(nv.getHovaten());
    	 });
    }*/

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ObservableList<String> list = FXCollections.observableArrayList("Danh sách nhân viên","Lịch làm");
		Listnhanvien.setItems(list);
		Listnhanvien.getSelectionModel().select("Lịch làm");
	//	hovaten.setCellValueFactory(new PropertyValueFactory<Nhanvien, String>("hovaten"));
	//	tableNV.setItems(getNhanvien());
	//	setCellValueFromTabletoTexfField();
		
	}
    
    void ListNhanvien() throws Exception  {
    	Parent root = FXMLLoader.load(getClass().getResource("listnhanvien.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Chon nhan vien");
		stage.show();	
    }
    @FXML
    void clickGrid(MouseEvent event) throws Exception {
    	Node clickedNode = event.getPickResult().getIntersectedNode();
        if (clickedNode != grid) {
            // click on descendant node
            Integer colIndex = GridPane.getColumnIndex(clickedNode);
            Integer rowIndex = GridPane.getRowIndex(clickedNode);
            System.out.println("Mouse clicked cell: " + colIndex + " And: " + rowIndex);
            ListNhanvien();
        //    Text t1 = new Text();
          //  t1.setText(colIndex,rowIndex);
            
        }
    }
        
    
 /*   void SearchNhanvien(KeyEvent event) {
    	ObservableList<Nhanvien> table = FXCollections.observableArrayList(getNhanvien());
    	FilteredList<Nhanvien> filterData = new FilteredList<>(table,p -> true);
    	search.textProperty().addListener((observable,oldvalue,newvalue) -> {
    		filterData.setPredicate(nv -> {
    			if(newvalue == null || newvalue.isEmpty()) {
    				 return true; 
    			}
    			String typetext = newvalue.toLowerCase();
    			if(nv.getHovaten().toLowerCase().indexOf(typetext) !=-1) {
    				return true;
    		//	}
    		////	if(nv.getChucvu().toLowerCase().indexOf(typetext) !=-1) {
    			//	return true;
    			}
    			return false;
    			
    		});
    		SortedList<Nhanvien> sortedList = new SortedList<>(filterData);
    		sortedList.comparatorProperty().bind(tableNV.comparatorProperty());
    		tableNV.setItems(sortedList);
    	});
    }*/

	
/*	public ObservableList<Nhanvien> getNhanvien() {
        ObservableList<Nhanvien> TableNV = FXCollections.observableArrayList();
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml")
				.build();
		Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		
		CriteriaQuery<Nhanvien> nv = session.getCriteriaBuilder().createQuery(Nhanvien.class);
		nv.from(Nhanvien.class);
		List<Nhanvien> eList = session.createQuery(nv).getResultList();
	//	List<Nhanvien> eList = session.createQuery(criteriaQuery).getResultList();
    //    List<Nhanvien> eList = session.createQuery(Nhanvien.class).list();
        for (Nhanvien ent : eList) {
            TableNV.add(ent);
        }
        return TableNV;	  
        
    }*/

}
