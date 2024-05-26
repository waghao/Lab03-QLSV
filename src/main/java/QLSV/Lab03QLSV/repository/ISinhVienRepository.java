package QLSV.Lab03QLSV.repository;
import QLSV.Lab03QLSV.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISinhVienRepository extends JpaRepository<SinhVien, Long> {

}
