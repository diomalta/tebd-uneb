package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "cards", schema = "congresso", catalog = "")
public class CardsEntity {
    private String flag;
    private String ccv;
    private Timestamp due;
    private String id;

    @Basic
    @Column(name = "flag", nullable = true, length = 10)
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "CCV", nullable = true, length = 4)
    public String getCcv() {
        return ccv;
    }

    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    @Basic
    @Column(name = "due", nullable = true)
    public Timestamp getDue() {
        return due;
    }

    public void setDue(Timestamp due) {
        this.due = due;
    }

    @Id
    @Column(name = "id", nullable = false, length = 10)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardsEntity that = (CardsEntity) o;
        return Objects.equals(flag, that.flag) &&
                Objects.equals(ccv, that.ccv) &&
                Objects.equals(due, that.due) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flag, ccv, due, id);
    }
}
