package nl.delphinity.qrgoats.repositoryInterfaces;

import nl.delphinity.qrgoats.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}