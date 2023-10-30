package nl.delphinity.qrgoats.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Objects;
import java.util.SortedSet;

@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "education", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private SortedSet<Student> students;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "education_id")
    private SortedSet<Question> questions;

    public Education() {

    }

    public Education(String name) {
        this.name = name;
    }

    public Education(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SortedSet<Student> getStudents() {
        return students;
    }

    public void setStudents(SortedSet<Student> students) {
        this.students = students;
    }

    public SortedSet<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(SortedSet<Question> questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return Objects.equals(id, education.id) && Objects.equals(name, education.name) && Objects.equals(students, education.students) && Objects.equals(questions, education.questions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, students, questions);
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                ", questions=" + questions +
                '}';
    }

    public void removeStudent(Student student) {
    // TODO Needs to be implemented
    }

    public void addStudent(Student student) {
    // TODO Needs to be implemented
    }

    public void addQuestion(Question question) {
    // TODO Needs to be implemented
    }

    public void removeQuestion(Question question) {
    // TODO Needs to be implemented
    }

    public Report studentCallingSick(Student student) {
    // TODO Needs to be implemented
        return null;
    }

    public Report studentCallingLate(String studentNr, String reason , String remark) {
    // TODO Needs to be implemented
        return null;
    }

    public Report studentRequestLeave(String studenrNr, String reason, LocalDate begindate, LocalTime begintime, LocalDate enddate, LocalTime endtime) {
        // TODO Needs to be implemented
        return null;
    }

}
