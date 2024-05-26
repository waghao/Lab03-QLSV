
package QLSV.Lab03QLSV.repository;
import QLSV.Lab03QLSV.entity.MonHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMonHocRepository extends JpaRepository<MonHoc, Long> {

}
