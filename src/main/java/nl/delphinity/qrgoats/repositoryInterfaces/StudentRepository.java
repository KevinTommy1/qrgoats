package nl.delphinity.qrgoats.repositoryInterfaces;

import nl.delphinity.qrgoats.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}