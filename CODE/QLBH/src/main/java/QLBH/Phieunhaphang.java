package QLBH;

import javax.persistence.*;

@Entity
@Table (name="nhaphang")


public class Phieunhaphang {
	
	@Id
	private int manhaphang;
	private Integer thoigiannhap;
	private int tongtien;
	private int mancc;
	private int manv;
	
	
	
	public Phieunhaphang(int manhaphang, Integer thoigiannhap, int tongtien, int mancc, int manv) {
		super();
		this.manhaphang = manhaphang;
		this.thoigiannhap = thoigiannhap;
		this.tongtien = tongtien;
		this.mancc = mancc;
		this.manv = manv;
	}

	public int getManhaphang() {
		return manhaphang;
	}

	public void setManhaphang(int manhaphang) {
		this.manhaphang = manhaphang;
	}

	public Integer getThoigiannhap() {
		return thoigiannhap;
	}

	public void setThoigiannhap(Integer thoigiannhap) {
		this.thoigiannhap = thoigiannhap;
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

	public Phieunhaphang() {
		// TODO Auto-generated constructor stub
	}

}
