package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "evaluations", schema = "congresso", catalog = "")
public class EvaluationsEntity {
    private String note;
    private String position;

    @Basic
    @Column(name = "note", nullable = true, length = 10)
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "position", nullable = true, length = 10)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvaluationsEntity that = (EvaluationsEntity) o;
        return Objects.equals(note, that.note) &&
                Objects.equals(position, that.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(note, position);
    }
}
