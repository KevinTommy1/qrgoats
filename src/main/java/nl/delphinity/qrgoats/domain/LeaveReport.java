package nl.delphinity.qrgoats.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@PrimaryKeyJoinColumn(
        foreignKey = @ForeignKey(
                name = "FK_leaveReport_reportID"
        )
)
public class LeaveReport extends Report {

    @Column(name = "remark", nullable = false)
    private String remark;

    @Column(name = "reason", nullable = false)
    private String reason;

    @Column(name = "startDate", nullable = false)
    private LocalDate startDate;

    @Column(name = "startTime", nullable = false)
    private LocalTime startTime;

    @Column(name = "endDate", nullable = false)
    private LocalDate endDate;

    @Column(name = "endTime", nullable = false)
    private LocalTime endTime;

    public LeaveReport() {
    }

    public LeaveReport(Integer id, Student student, String remark, String reason, LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        super(id, student);
        this.remark = remark;
        this.reason = reason;
        this.startDate = startDate;
        this.startTime = startTime;
        this.endDate = endDate;
        this.endTime = endTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LeaveReport that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(
                getRemark(),
                that.getRemark()) && Objects.equals(
                        getReason(),
                that.getReason()) && Objects.equals(
                        getStartDate(),
                that.getStartDate()) && Objects.equals(
                        getStartTime(),
                that.getStartTime()) && Objects.equals(
                        getEndDate(),
                that.getEndDate()) && Objects.equals(
                        getEndTime(),
                that.getEndTime()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                super.hashCode(),
                getRemark(),
                getReason(),
                getStartDate(),
                getStartTime(),
                getEndDate(),
                getEndTime()
        );
    }

    @Override
    public String toString() {
        return "LeaveReport{" +
                "remark='" + remark + '\'' +
                ", reason='" + reason + '\'' +
                ", startDate=" + startDate +
                ", startTime=" + startTime +
                ", endDate=" + endDate +
                ", endTime=" + endTime +
                '}';
    }
}
