package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "revisors", schema = "congresso", catalog = "")
public class RevisorsEntity {
    private String id;
    private String evaluation;

    @Id
    @Column(name = "id", nullable = false, length = 10)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "evaluation", nullable = true, length = 10)
    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RevisorsEntity that = (RevisorsEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(evaluation, that.evaluation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, evaluation);
    }
}
