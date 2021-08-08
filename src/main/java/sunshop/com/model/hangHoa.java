package sunshop.com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hanghoa")
public class hangHoa implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MaSoHangHoa")
	private int id;

	@Column(name = "TenHangHoa")
	private String tenHangHoa;

	@Column(name = "TacGia")
	private String tacGia;

	@Column(name = "SoLuong")
	private int soLuong;

	@Column(name = "Gia")
	private double gia;

	@Column(name = "GiamGia")
	private double giamGia;

	@Column(name = "Hinh")
	private String hinh;

	@Column(name = "MoTa")
	private String moTa;

	@ManyToOne
	@JoinColumn(name = "MaSoLoaiHang")
	private loaiHangHoa maSoLoaiHang;

	@OneToMany(mappedBy = "maSoHangHoa")
	private List<chiTietDatHang> chiTietDatHang;

	public hangHoa() {
	}

	public hangHoa(int id, String tenHangHoa, String tacGia, int soLuong, double gia, double giamGia, String hinh,
			String moTa, loaiHangHoa maSoLoaiHang, List<sunshop.com.model.chiTietDatHang> chiTietDatHang) {

		this.id = id;
		this.tenHangHoa = tenHangHoa;
		this.tacGia = tacGia;
		this.soLuong = soLuong;
		this.gia = gia;
		this.giamGia = giamGia;
		this.hinh = hinh;
		this.moTa = moTa;
		this.maSoLoaiHang = maSoLoaiHang;
		this.chiTietDatHang = chiTietDatHang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getTenHangHoa() {
		return tenHangHoa;
	}

	public void setTenHangHoa(String tenHangHoa) {
		this.tenHangHoa = tenHangHoa;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGia() {
		return gia;
	}
	

	public void setGia(double gia) {
		this.gia = gia;
	}

	public double getGiamGia() {
		return giamGia;
	}

	public void setGiamGia(double giamGia) {
		this.giamGia = giamGia;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public loaiHangHoa getMaSoLoaiHang() {
		return maSoLoaiHang;
	}

	public void setMaSoLoaiHang(loaiHangHoa maSoLoaiHang) {
		this.maSoLoaiHang = maSoLoaiHang;
	}

	public List<chiTietDatHang> getChiTietDatHang() {
		return chiTietDatHang;
	}

	public void setChiTietDatHang(List<chiTietDatHang> chiTietDatHang) {
		this.chiTietDatHang = chiTietDatHang;
	}
	

}
