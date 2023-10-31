package nl.delphinity.qrgoats.domain;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.SortedSet;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private SortedSet<Answer> answers;

    @ManyToOne
    @JoinColumn(name = "education_id")
    private Education education;

    @Column(nullable = false, name = "question_name")
    private String questionName;


    public Question() { }

    public Question(Integer id, SortedSet<Answer> answers, Education education, String questionName) {
        this.id = id;
        this.answers = answers;
        this.education = education;
        this.questionName = questionName;
    }

    public Question(String questionName) {
        this.questionName = questionName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SortedSet<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(SortedSet<Answer> answers) {
        this.answers = answers;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String question) {
        this.questionName = question;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = prime * result + (id == null ? 0 : id.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Question other = (Question) obj;

        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return questionName;
    }

}
