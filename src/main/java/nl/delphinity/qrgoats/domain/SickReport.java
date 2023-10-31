package nl.delphinity.qrgoats.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.PrimaryKeyJoinColumn;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_ziekmelding_meldingID"))
@OnDelete(action = OnDeleteAction.CASCADE)
public class SickReport extends Report {

    public SickReport() {
    }

    public SickReport(Integer id, Student student) {
        super(id, student);
    }

}

