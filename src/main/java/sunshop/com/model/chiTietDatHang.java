package sunshop.com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "chitietdathang")
public class chiTietDatHang implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private Pk pk;
	
	 @Embeddable
	  public static class Pk implements Serializable {
	    private static final long serialVersionUID = 1L;
	    	    
	    @Column(name="MaSoDatHang")
	    private int maSoDatHang;
	    
	    @Column(name="MaSoHangHoa")
	    private int maSoHangHoa;

		public int getMaSoDatHang() {
			return maSoDatHang;
		}

		public void setMaSoDatHang(int maSoDatHang) {
			this.maSoDatHang = maSoDatHang;
		}

		public int getMaSoHangHoa() {
			return maSoHangHoa;
		}

		public void setMaSoHangHoa(int maSoHangHoa) {
			this.maSoHangHoa = maSoHangHoa;
		}
	    
	 }
	
	@Column(name = "SoLuong")
	private int soLuong;
	
	@Column(name="GiaDatHang")
	private double giaDatHang;
	
	@ManyToOne
	@JoinColumn(name = "MaSoDatHang",insertable=false, updatable=false)
	private datHang maSoDatHang;
	
	@ManyToOne
	@JoinColumn(name = "MaSoHangHoa",insertable=false, updatable=false)
	private hangHoa maSoHangHoa;

	public chiTietDatHang() {
	}

	public chiTietDatHang(Pk pk, int soLuong, double giaDatHang, datHang maSoDatHang, hangHoa maSoHangHoa) {
		this.pk = pk;
		this.soLuong = soLuong;
		this.giaDatHang = giaDatHang;
		this.maSoDatHang = maSoDatHang;
		this.maSoHangHoa = maSoHangHoa;
	}

	public Pk getPk() {
		return pk;
	}

	public void setPk(Pk pk) {
		this.pk = pk;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaDatHang() {
		return giaDatHang;
	}

	public void setGiaDatHang(double giaDatHang) {
		this.giaDatHang = giaDatHang;
	}

	public datHang getMaSoDatHang() {
		return maSoDatHang;
	}

	public void setMaSoDatHang(datHang maSoDatHang) {
		this.maSoDatHang = maSoDatHang;
	}

	public hangHoa getMaSoHangHoa() {
		return maSoHangHoa;
	}

	public void setMaSoHangHoa(hangHoa maSoHangHoa) {
		this.maSoHangHoa = maSoHangHoa;
	}
	
}
