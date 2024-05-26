package QLSV.Lab03QLSV.repository;
import QLSV.Lab03QLSV.entity.Lop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILopRepository extends JpaRepository<Lop, Long> {

}
