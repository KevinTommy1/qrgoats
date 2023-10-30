package nl.delphinity.qrgoats.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date", nullable = false)
    @CreationTimestamp
    private LocalDateTime date;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Student student;

    public Report() { }

    public Report(Integer id, Student student) {
        this.id = id;
        this.student = student;
    }

    public Report(Integer id,LocalDateTime date, Student student) {
        this.id = id;
        this.date = date;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Report report)) return false;
        return Objects.equals(
                getId(),
                report.getId()) && Objects.equals(
                        getDate(),
                report.getDate()) && Objects.equals(
                        getStudent(),
                report.getStudent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getId(),
                getDate(),
                getStudent()
        );
    }
}

