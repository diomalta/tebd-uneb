package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "participants", schema = "congresso", catalog = "")
public class ParticipantsEntity {
    private String telephone;
    private String name;
    private String email;
    private String id;

    @Id
    @Column(name = "id", nullable = false, length = 10)
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "telephone", nullable = true, length = 10)
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 10)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 10)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantsEntity that = (ParticipantsEntity) o;
        return Objects.equals(telephone, that.telephone) &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telephone, name, email, id);
    }
}
