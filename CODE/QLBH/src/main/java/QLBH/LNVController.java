package QLBH;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

import java.util.List;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
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


public class LNVController implements Initializable{

    @FXML
    private TextField search;

    @FXML
    private Text tennhanvien;

    @FXML
    private DatePicker thoigian;

    @FXML
    private TableView<Nhanvien> tableNV;

    @FXML
    private TableColumn  hovaten;

    @FXML
    private ComboBox<String> calam;

    @FXML
    private TextField chucvunhanvien;

    @FXML
    void SearchNhanvien(KeyEvent event) {
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
    }
    private void setCellValueFromTabletoTexfField() {
   	 tableNV.setOnMouseClicked(event -> {
   		 Nhanvien nv = tableNV.getItems().get(tableNV.getSelectionModel().getSelectedIndex());
   		 tennhanvien.setText(nv.getHovaten());
   	 });
   }
    
    
    public ObservableList<Nhanvien> getNhanvien() {
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
        
    }
    

    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		hovaten.setCellValueFactory(new PropertyValueFactory<Nhanvien, String>("hovaten"));
		tableNV.setItems(getNhanvien());
		setCellValueFromTabletoTexfField();
	}

}