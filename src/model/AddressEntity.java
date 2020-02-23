package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address", schema = "congresso", catalog = "")
public class AddressEntity {
    private String cep;
    private String address;
    private int id;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id; }

    @Basic
    @Column(name = "cep", nullable = false, insertable = true, updatable = true, length = 10)
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) { this.cep = cep; }

    @Basic
    @Column(name = "address",  nullable = false, insertable = true, updatable = true, length = 50)
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return Objects.equals(cep, that.cep) &&
                Objects.equals(address, that.address) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, address, id);
    }
}
