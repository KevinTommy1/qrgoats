package nl.delphinity.qrgoats.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 60)
    private String firstname;

    @Column(name = "surname", nullable = false, length = 60)
    private String lastname;

    @Column(name = "middlename", length = 20)
    private String middleName;

    public Person() {

    }

    public Person(Integer id, String firstname, String lastname, String middleName) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middleName = middleName;
    }

    public Person(String firstname, String lastname, String middleName) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.middleName = middleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(
                getId(),
                person.getId()) && Objects.equals(getFirstname(),
                person.getFirstname()) && Objects.equals(getLastname(),
                person.getLastname()) && Objects.equals(getMiddleName(),
                person.getMiddleName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getId(),
                getFirstname(),
                getLastname(),
                getMiddleName()
        );
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", middleName='" + middleName + '\'' +
                '}';
    }
}
