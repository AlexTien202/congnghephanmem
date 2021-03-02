package QLBH;

import javax.persistence.*;

@Entity
@Table (name = "dathang")


public class Phieudathang {
	
	@Id
	private int madathang;
	private Integer thoigiandat;
	private int tongtien;
	private int mancc;
	private int manv;
	
	
	public Phieudathang(int madathang, Integer thoigiandat, int tongtien, int mancc, int manv) {
		super();
		this.madathang = madathang;
		this.thoigiandat = thoigiandat;
		this.tongtien = tongtien;
		this.mancc = mancc;
		this.manv = manv;
	}


	public int getMadathang() {
		return madathang;
	}


	public void setMadathang(int madathang) {
		this.madathang = madathang;
	}


	public Integer getThoigiandat() {
		return thoigiandat;
	}


	public void setThoigiandat(Integer thoigiandat) {
		this.thoigiandat = thoigiandat;
	}


	public int getTongtien() {
		return tongtien;
	}


	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}


	public int getMancc() {
		return mancc;
	}


	public void setMancc(int mancc) {
		this.mancc = mancc;
	}


	public int getManv() {
		return manv;
	}


	public void setManv(int manv) {
		this.manv = manv;
	}


	public Phieudathang() {
		// TODO Auto-generated constructor stub
	}

}
