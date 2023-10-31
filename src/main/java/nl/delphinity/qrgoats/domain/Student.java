package nl.delphinity.qrgoats.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

@Entity
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_Student_personID"))
@Table(name = "student")
public class Student extends Person {

    @Column(name = "student_nr", nullable = false, unique = true, length = 6)
    private String studentNr;

    @OneToOne
    @JoinColumn(name = "account_email")
    private Account account;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private SortedSet<Report> reports;

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "education_id", nullable = false)
    private Education education;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private SortedSet<CardLog> cardLogs;


    @Transient
    private QRCode qrCode;

    @Transient
    private boolean isCheckedIn;

    public Student() {

    }

    public Student(String studentNr, Integer id, String naam, String tussenvoegsel, String achternaam) {
        super(id, naam, tussenvoegsel, achternaam);
        this.studentNr = studentNr;
    }

    public String getStudentNr() {
        return studentNr;
    }

    public void setStudentNr(String studentNr) {
        this.studentNr = studentNr;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public SortedSet<Report> getReports() {
        return reports;
    }

    public void setReports(SortedSet<Report> reports) {
        this.reports = reports;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public SortedSet<CardLog> getCardLogs() {
        return cardLogs;
    }

    public void setCardLogs(SortedSet<CardLog> cardLogs) {
        this.cardLogs = cardLogs;
    }

    public QRCode getQrCode() {
        return qrCode;
    }

    public void setQrCode(QRCode qrCode) {
        this.qrCode = qrCode;
    }

    public boolean isCheckedIn() {
        return isCheckedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        isCheckedIn = checkedIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return isCheckedIn() == student.isCheckedIn() &&
                Objects.equals(getStudentNr(),
                        student.getStudentNr()) && Objects.equals(getAccount(),
                student.getAccount()) && Objects.equals(getReports(),
                student.getReports()) && Objects.equals(getEducation(),
                student.getEducation()) && Objects.equals(getCardLogs(),
                student.getCardLogs()) && Objects.equals(getQrCode(),
                student.getQrCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentNr(),
                getAccount(),
                getReports(),
                getEducation(),
                getCardLogs(),
                getQrCode(),
                isCheckedIn());
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNr='" + studentNr + '\'' +
                ", account=" + account +
                ", reports=" + reports +
                ", education=" + education +
                ", cardLogs=" + cardLogs +
                ", qrCode=" + qrCode +
                ", isCheckedIn=" + isCheckedIn +
                '}';
    }

    public void addCardlog(CardLog log) {
        // Todo: Implement this method
    }

    public void addReport(Report report) {
        // Todo: Implement this method
    }

    public void removeReport(Report report) {
        // Todo: Implement this method
    }

    public Report reportLate(String remark, String reason){
        // Todo: Implement this method
        return null;
    }

    public Report reportAbsent(String remark, String reason){
        // Todo: Implement this method
        return null;
    }

    public Report reportLeave(String remark, LocalDate begindate, LocalTime beginTime, LocalDate enddate, LocalTime endTime){
        // Todo: Implement this method
        return null;
    }

}
