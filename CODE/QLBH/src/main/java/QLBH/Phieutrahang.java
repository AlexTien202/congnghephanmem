package QLBH;

import javax.persistence.*;

@Entity
@Table (name="phieutra")

public class Phieutrahang {
	
	@Id 
	private int maphieutra;
	private Integer thoigiantra;
	private int mancc;
	private int manv;
	
	
	
	public Phieutrahang(int maphieutra, Integer thoigiantra, int mancc, int manv) {
		super();
		this.maphieutra = maphieutra;
		this.thoigiantra = thoigiantra;
		this.mancc = mancc;
		this.manv = manv;
	}

	public int getMaphieutra() {
		return maphieutra;
	}

	public void setMaphieutra(int maphieutra) {
		this.maphieutra = maphieutra;
	}

	public Integer getThoigiantra() {
		return thoigiantra;
	}

	public void setThoigiantra(Integer thoigiantra) {
		this.thoigiantra = thoigiantra;
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

	public Phieutrahang() {
		// TODO Auto-generated constructor stub
	}

}
