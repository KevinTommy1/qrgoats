package nl.delphinity.qrgoats.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "awnser")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(nullable = false, name = "answer_name")
    private String answerName;

    public Answer() {
    }

    public Answer(Question question, String awnserName) {
        this.question = question;
        this.answerName = awnserName;
    }

    public Answer(Integer id, Question question, String awnserName) {
        this.id = id;
        this.question = question;
        this.answerName = awnserName;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question owningQuestion) {
        this.question = owningQuestion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAwnserName() {
        return answerName;
    }

    public void setAwnserName(String awnserName) {
        this.answerName = awnserName;
    }

    @Override
    public String toString() {
        return "Awnser{" +
                "id=" + id +
                ", question=" + question +
                ", awnserName='" + answerName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(id, answer.id) && Objects.equals(question, answer.question) && Objects.equals(answerName, answer.answerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answerName);
    }

    public int compareTo(Answer other) {
        return answerName.compareTo(other.answerName);
    }
}
