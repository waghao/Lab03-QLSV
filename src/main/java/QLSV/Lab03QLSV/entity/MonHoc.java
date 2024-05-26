package QLSV.Lab03QLSV.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity(name = "MonHoc")
@Table(name = "MonHoc")
public class MonHoc {

    @Id
    @Column(name = "MaHoc", length = 10)
    @Size(min =1, max = 10,message="Mã môn phải từ 1 đến 10 ký tự")
    private String maMon;

    @Size(min = 5, max = 50, message="Tên môn phải từ 1 đến 50 ký tự")
    @Column(name="TenMonHoc",length=50)
    private String tenMonHoc;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name ="SinhVien_MonHoc",
            joinColumns = {@JoinColumn(name ="MSSV")}
    )
    private Set<SinhVien> sinhViens;
}
