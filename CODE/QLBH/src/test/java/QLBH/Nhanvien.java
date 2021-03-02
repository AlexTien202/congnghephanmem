package QLBH;
import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="nhanvien")

public class Nhanvien implements Serializable {
	@Id 
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Image imgnhanvien;
	private String id;
	private String hovaten;
	private int ngaysinh;
	private String chucvu;
	private int sdt;
	private int cmnd;
	private String diachi;
	private byte[] image;
	public Nhanvien() {
		super();
	}
	
	public Nhanvien(String id,String hovaten,int ngaysinh,String chucvu,int sdt,int cmnd,String diachi,byte[] image) {
		super();
		this.id=id;
		this.hovaten=hovaten;
		this.ngaysinh=ngaysinh;
		this.chucvu=chucvu;
		this.sdt=sdt;
		this.cmnd=cmnd;
		this.diachi=diachi;
		this.image = image;
	}
	public Nhanvien(String id,String hovaten,int ngaysinh,String chucvu,int sdt,int cmnd,String diachi) {
		super();
		this.id=id;
		this.hovaten=hovaten;
		this.ngaysinh=ngaysinh;
		this.chucvu=chucvu;
		this.sdt=sdt;
		this.cmnd=cmnd;
		this.diachi=diachi;
		
	}
	
	public Nhanvien(String id) {
		super();
		this.id=id;
	}
	
	
	
	
	
	public Nhanvien(String hovaten,int ngaysinh,String chucvu,int sdt,int cmnd,String diachi) {
		super();
		//this.id=id;
		this.hovaten=hovaten;
		this.ngaysinh=ngaysinh;
		this.chucvu=chucvu;
		this.sdt=sdt;
		this.cmnd=cmnd;
		this.diachi=diachi;
	}
	
	/*public Nhanvien(Image imgnhanvien,String hovaten,int ngaysinh,String chucvu,int sdt,int cmnd,String diachi ) {
		super();
		this.imgnhanvien=imgnhanvien;
		//this.id=id;
		this.hovaten=hovaten;
		this.ngaysinh=ngaysinh;
		this.chucvu=chucvu;
		this.sdt=sdt;
		this.cmnd=cmnd;
		this.diachi=diachi;
	}*/
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
//	public Image getImgnhanvien() {
	//	return imgnhanvien;
	//}
//	public void setImgnhanvien(Image imgnhanvien) {
	//	this.imgnhanvien = imgnhanvien;
//	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getHovaten() {
		return hovaten;
	}
	public void setHovaten(String hovaten) {
		this.hovaten = hovaten;
	}
	public int getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(int ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	public int getSdt() {
		return sdt;
	}
	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	public int getCmnd() {
		return cmnd;
	}
	public void setCmnd(int cmnd) {
		this.cmnd = cmnd;
	}
 ;

	

}
