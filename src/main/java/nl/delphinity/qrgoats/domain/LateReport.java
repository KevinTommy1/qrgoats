package nl.delphinity.qrgoats.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.PrimaryKeyJoinColumn;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Objects;

@Entity
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_latereport_reportID"))
@OnDelete(action = OnDeleteAction.CASCADE)
public class LateReport extends Report {

    @Column(name = "remark", nullable = false)
    private String remark;

    @Column(name = "reason", nullable = false)
    private String reason;

    public LateReport() { }

    public LateReport(Integer id, Student student, String remark, String reason) {
        super(id, student);
        this.remark = remark;
        this.reason = reason;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LateReport that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getRemark(), that.getRemark()) && Objects.equals(getReason(), that.getReason());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getRemark(), getReason());
    }

    @Override
    public String toString() {
        return "LateReport{" +
                "remark='" + remark + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}
