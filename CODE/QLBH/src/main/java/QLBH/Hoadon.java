package QLBH;
import javax.persistence.*;
@Entity
@Table(name="hoadon")
public class Hoadon {
	@Id 
	private int mahoadon;
	private int thoigian;
	private int tonggia;
	private int makh;
	private int manv;
	
	
	public Hoadon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Hoadon(int mahoadon, int thoigian, int tonggia, int makh, int manv) {
		super();
		//this.id=id;
		this.mahoadon=mahoadon;
		this.thoigian=thoigian;
		this.tonggia=tonggia;
		this.makh=makh;
		this.manv=manv;
	}
	public int getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(int mahoadon) {
		this.mahoadon = mahoadon;
	}
	public int getThoigian() {
		return thoigian;
	}
	public void setThoigian(int thoigian) {
		this.thoigian = thoigian;
	}
	public int getTonggia() {
		return tonggia;
	}
	public void setTonggia(int tonggia) {
		this.tonggia = tonggia;
	}
	public int getMakh() {
		return makh;
	}
	public void setMakh(int makh) {
		this.makh = makh;
	}
	public int getManv() {
		return manv;
	}
	public void setManv(int manv) {
		this.manv = manv;
	}
	
	
	

}
