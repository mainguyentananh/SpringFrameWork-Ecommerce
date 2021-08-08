package sunshop.com.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "loaihanghoa")
public class loaiHangHoa implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MaSoLoaiHang")
	private int id;

	@Column(name = "TenLoaiHang")
	private String tenLoaiHang;

	@OneToMany(mappedBy = "maSoLoaiHang")
	private List<hangHoa> hangHoa;

	public loaiHangHoa() {
	}

	public loaiHangHoa(int id, String tenLoaiHang, List<sunshop.com.model.hangHoa> hangHoa) {

		this.id = id;
		this.tenLoaiHang = tenLoaiHang;
		this.hangHoa = hangHoa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenLoaiHang() {
		return tenLoaiHang;
	}

	public void setTenLoaiHang(String tenLoaiHang) {
		this.tenLoaiHang = tenLoaiHang;
	}

	public List<hangHoa> getHangHoa() {
		return hangHoa;
	}

	public void setHangHoa(List<hangHoa> hangHoa) {
		this.hangHoa = hangHoa;
	}

}
