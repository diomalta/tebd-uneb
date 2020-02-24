package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "cards")
public class CardsEntity {
    private String flag;
    private String ccv;
    private String number;
    private Date due;
    private int id;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "number", nullable = false, insertable = true, updatable = true, length = 16)
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) { this.number = number; }

    @Basic
    @Column(name = "flag", nullable = false, insertable = true, updatable = true, length = 10)
    public String getFlag() {
        return flag;
    }
    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "CCV", nullable = true, insertable = true, updatable = true, length = 4)
    public String getCcv() {
        return ccv;
    }
    public void setCcv(String ccv) {
        this.ccv = ccv;
    }

    @Basic
    @Column(name = "due", nullable = true, insertable = true, updatable = true, length = 10)
    public Date getDue() {
        return due;
    }
    public void setDue(Date due) {
        this.due = due;
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
