package QLBH;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import java.awt.event.MouseEvent;
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


public class DSNVController extends Application implements  Initializable  {
	private Image image;
    @FXML
    private Button idaddNV;
    
    @FXML
    private TableView<Nhanvien> tableNV;
    
    @FXML
    private TableColumn id;

    @FXML
    private TableColumn hovaten;

    @FXML
    private TableColumn ngaysinh;

    @FXML
    private TableColumn chucvu;

    @FXML
    private TableColumn sdt;

    @FXML
    private TableColumn cmnd;
    
    @FXML
    private TableColumn diachi;
    
    @FXML
    private Button idreload;
    
    @FXML
    private TextField hovaten_nv;

    @FXML
    private TextField ns_nv;

    @FXML
    private TextField cv_nv;

    @FXML
    private TextField sdt_nv;

    @FXML
    private TextField cmnd_nv;

    @FXML
    private TextField diachi_nv;

    @FXML
    private Button xoa_nv;

    @FXML
    private Button capnhat_nv;

    @FXML
    private TextField id_nv;
    
    @FXML
    private ImageView imgnhanvien;
    
    @FXML
    private Button luucapnhat;
    
    @FXML
    private Button reset;
    
    @FXML
    private TextField search;
    
    final ObservableList<Nhanvien> table = FXCollections.observableArrayList();
    
    @FXML
    void Reset(ActionEvent event) {
    	 Nhanvien nv = tableNV.getItems().get(tableNV.getSelectionModel().getSelectedIndex());
    	 id_nv.setText(nv.getid());
		 hovaten_nv.setText(nv.getHovaten());
		 ns_nv.setText(Integer.toString(nv.getNgaysinh()));
		 cv_nv.setText(nv.getChucvu());
		 sdt_nv.setText(Integer.toString(nv.getSdt()));
		 diachi_nv.setText(nv.getDiachi());
		 cmnd_nv.setText(Integer.toString(nv.getCmnd()));
    }
    
    @FXML
    private void ThemNV(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("themnhanvien.fxml"));
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.setTitle("Them nhan vien");
		stage.show();		
    }
    
    
	
  /*  public ObservableList<Nhanvien> findAll() {
    	initialize1();
    	getNhanvien();    	
    	 // Wrap the ObservableList in a FilteredList (initially display all data).
      
               
        
    }    */
	
	
    
    
    
    @FXML
    void luucapnhat(ActionEvent event) {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Cap nhat thanh cong ");
    	String idnv = id_nv.getText();
    	String hovatennv = hovaten_nv.getText();
    	int ngaysinhnv = (Integer.parseInt(ns_nv.getText()));
    	String chucvunv = cv_nv.getText();
    	int sdtnv = (Integer.parseInt(sdt_nv.getText()));
    	int cmndnv = (Integer.parseInt(cmnd_nv.getText()));
    	String diachinv = diachi_nv.getText();
    	StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml")
				.build();
		Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			Nhanvien nv2 = new Nhanvien(idnv,hovatennv,ngaysinhnv,chucvunv,sdtnv,cmndnv,diachinv);
			nv2=session.get(Nhanvien.class, idnv);
			if (nv2 != null) {
			//	nv2.setid(idnv);
				nv2.setHovaten(hovatennv);
				nv2.setChucvu(chucvunv);
				nv2.setDiachi(diachinv);
				nv2.setNgaysinh(ngaysinhnv);
				nv2.setSdt(sdtnv);
				nv2.setCmnd(cmndnv);
				//person2.setAge(t2);
			///	person2.setAddress(t3);
				session.save(nv2);
				 alert.setContentText("Cap nhat nhan vien thanh cong !");
	        	 alert.showAndWait();
			}
			session.getTransaction().commit();	
		}catch (RuntimeException error) {
			session.getTransaction().rollback();
		}
		reload1();
    }
    
    @FXML
    void CapNhatNhanvien(ActionEvent event) {
   // 	id_nv.setEditable(true);
    	hovaten_nv.setEditable(true);
    	ns_nv.setEditable(true);
    	cv_nv.setEditable(true);
    	cmnd_nv.setEditable(true);
    	sdt_nv.setEditable(true);
    	diachi_nv.setEditable(true);
    	luucapnhat.setVisible(true);
    	reset.setVisible(true);
    }
    
    @FXML
    void XoaNhanvien(ActionEvent event) {
    	 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		 alert.setTitle("Current project is modified");
		 alert.setContentText("Save?");
		 ButtonType okButton = new ButtonType("Yes");
		 ButtonType noButton = new ButtonType("NO");
		 alert.getButtonTypes().setAll(okButton, noButton);
		 alert.showAndWait().ifPresent(type -> {
		         if (type == okButton) {
		        	String t1 = id_nv.getText();
		         	StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
		     				.configure("hibernate.cfg.xml")
		     				.build();
		     		Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
		     		SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
		     		Session session = sessionFactory.openSession();
		     		Nhanvien nv = new Nhanvien(t1);
		     		nv=session.get(Nhanvien.class, t1);
		     		try {
		     			session.beginTransaction();
		     			
		     			if(nv != null) {
		     				session.delete(nv);
		     				
		     			}		
		     			session.getTransaction().commit();	
		     		} catch (RuntimeException error) {
		     			session.getTransaction().rollback();
		     			
		     		}
		     		reload1();
		     		id_nv.setText("");
		     		hovaten_nv.setText("");
		     		ns_nv.setText("");
		     		cv_nv.setText("");
		     		sdt_nv.setText("");
		     		cmnd_nv.setText("");
		     		diachi_nv.setText("");
		     		imgnhanvien.setImage(null);
		         } else if (type == ButtonType.NO) {
		        	 alert.close();
		         }
		 });
    }
  
    public void initialize(URL url, ResourceBundle rb)  {
    	initialize1();
    	setCellValueFromTabletoTexfField();
    	//search();
    	
    }

	public void initialize1()  {
		
	//	id.setCellValueFactory(new PropertyValueFactory<Nhanvien, Integer>("id"));
        hovaten.setCellValueFactory(new PropertyValueFactory<Nhanvien, String>("hovaten"));
        ngaysinh.setCellValueFactory(new PropertyValueFactory<Nhanvien, Integer>("ngaysinh"));
        chucvu.setCellValueFactory(new PropertyValueFactory<Nhanvien, String>("chucvu"));
        sdt.setCellValueFactory(new PropertyValueFactory<Nhanvien, Integer>("sdt"));
        cmnd.setCellValueFactory(new PropertyValueFactory<Nhanvien, Integer>("cmnd"));
        diachi.setCellValueFactory(new PropertyValueFactory<Nhanvien, Integer>("diachi"));
        tableNV.setItems(getNhanvien());
        
        //SEARCH
        
        
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
	 
	/* public void search() {
		 hovaten.setCellValueFactory(new PropertyValueFactory<Nhanvien, String>("hovaten"));
	     ngaysinh.setCellValueFactory(new PropertyValueFactory<Nhanvien, Integer>("ngaysinh"));
	     chucvu.setCellValueFactory(new PropertyValueFactory<Nhanvien, String>("chucvu"));
	     sdt.setCellValueFactory(new PropertyValueFactory<Nhanvien, Integer>("sdt"));
	     cmnd.setCellValueFactory(new PropertyValueFactory<Nhanvien, Integer>("cmnd"));
	     diachi.setCellValueFactory(new PropertyValueFactory<Nhanvien, Integer>("diachi"));
	     tableNV.setItems(getNhanvien());
		 
	     
	               
	        
	    }    */
	               
	       
		 
	 
//	 public void setNhanviendata(ObservableList<Nhanvien> TableNV) {
	//	this.TableNV = TableNV; 
	//}
	 void reload1() {
		    initialize1();
		 	getNhanvien();
	    }
	 
	 
	 @FXML
	    void reload(ActionEvent event) {
		    initialize1();
		 	getNhanvien();
	    }
	/* void LoadLIST() {
		 ObservableList<Nhanvien> nhanvien;
		 nhanvien = tableNV.getSelectionModel().getSelectedItems();
	 }*/
	 
	 private void setCellValueFromTabletoTexfField() {
		 tableNV.setOnMouseClicked(event -> {
			 Nhanvien nv = tableNV.getItems().get(tableNV.getSelectionModel().getSelectedIndex());
			 id_nv.setText(nv.getid());
			 hovaten_nv.setText(nv.getHovaten());
			 ns_nv.setText(Integer.toString(nv.getNgaysinh()));
			 cv_nv.setText(nv.getChucvu());
			 sdt_nv.setText(Integer.toString(nv.getSdt()));
			 diachi_nv.setText(nv.getDiachi());
			 cmnd_nv.setText(Integer.toString(nv.getCmnd()));
			 byte[] getImageInBytes = nv.getImage();
			 
			  try{
		            FileOutputStream fos = new FileOutputStream(new File("photo.jpg")); 
		            fos.write(getImageInBytes);
		            fos.close();
		            image = new Image("file:photo.jpg",imgnhanvien.getFitHeight(),imgnhanvien.getFitHeight(),true,true);
		            imgnhanvien.setImage(image);
		        }catch(Exception e){
		            e.printStackTrace();
		        }			 
		 });
		 
		
	 }
	 
	
	 

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	

}

