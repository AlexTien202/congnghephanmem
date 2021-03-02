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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
import javafx.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.*;
import org.hibernate.boot.registry.*;
import QLBH.Nhanvien;

public class ThemNVController extends Application implements Initializable{
	private FileChooser filechooser;
	private Image image;
	private Blob image1;
	private File file;
	
	//private final Desktop desktop = Desktop.getDesktop();
    @FXML
    private TextField tfhovaten;
    
    @FXML
    private AnchorPane ap;
    
    @FXML
    private ImageView imgview;

    @FXML
    private TextField tfns;

    @FXML
    private TextField tfsdt;

    @FXML
    private ComboBox<String> tfcv;

    @FXML
    private TextField tfcmnd;

    @FXML
    private TextField tfdc;

    @FXML
    private Button addImage;

    @FXML
    private Button add;

    @FXML
    private Button huy;
    
    @FXML
    private TextField tfid;
    
    @FXML
     void AddImage(ActionEvent event) {
    	 Stage stage = (Stage) ap.getScene().getWindow();
    	 FileChooser fileChooser = new FileChooser();
    	 FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
    	 fileChooser.getExtensionFilters().add(imageFilter);
    	 file = fileChooser.showOpenDialog(stage);
    	 if(file!=null) {
    		image = new Image(file.toURI().toString(),100,150,false,true);
    		imgview.setImage(image);
    	}
    }
    

    @FXML
     void HuyThemNV(ActionEvent event) {
    	//System.exit(0);
    	 Stage stage = (Stage) huy.getScene().getWindow();
    	 stage.close();
    }

    @FXML
     void ThemNVButton(ActionEvent event) throws IOException  {
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Them nhan vien");
		 
    	String id = tfid.getText();
    	String t1 = tfhovaten.getText();
    	int t2 = Integer.parseInt(tfns.getText());
    	String t3 = tfcv.getValue();
    	int t4 = Integer.parseInt(tfsdt.getText());
    	int t5 = Integer.parseInt(tfcmnd.getText());
    	String t6 = tfdc.getText();
    	StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml")
				.build();
		Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		
		DSNVController ds = new DSNVController();
    	try {
    		 FileInputStream fis = new FileInputStream(file);
    		 byte[] bFile = new byte[(int) (file.length())];
    		 fis.read(bFile);
    		 Nhanvien nv = new Nhanvien(id,t1,t2,t3,t4,t5,t6,bFile);
    		 session.beginTransaction();
    		 session.save(nv);
    		 session.getTransaction().commit();
    		 Stage stage = (Stage) add.getScene().getWindow();
        	 stage.close();
        	 alert.setContentText("Them nhan vien thanh cong !");
        	 alert.showAndWait();    
        	
    	}
    	catch (RuntimeException error){
    		 alert.setContentText("Them nhan vien that bai  !");
    		 alert.showAndWait();
    		session.getTransaction().rollback();
    	}
    	
    	// ds.reload1();
    	
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
	/*public void showMessageDialog() {
		Alert alert = new Alert(AlertType.INFORMATION);
		 alert.setTitle("Test Connection");
	}*/

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ObservableList<String> list=FXCollections.observableArrayList("Nhân viên","Quản lý");
		tfcv.setItems(list);
		
	}

}
