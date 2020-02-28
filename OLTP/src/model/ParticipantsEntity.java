package model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "participants", schema = "congresso", catalog = "")
public class ParticipantsEntity {
    private int id;
    private String telephone;
    private String name;
    private String email;
    private AddressEntity address;
    private AddressEntity job;
    private CardsEntity card;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id", nullable = false)
    public CardsEntity getCard() {
        return card;
    }
    public void setCard(CardsEntity card) { this.card = card; }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    public AddressEntity getAddress() {
        return address;
    }
    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    public AddressEntity getJob() {
        return job;
    }
    public void setJob(AddressEntity job) {
        this.job = job;
    }

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true, length = 10)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "telephone", nullable = true, insertable = true, updatable = true, length = 10)
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 10)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 10)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    };

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
