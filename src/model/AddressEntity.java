package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address", schema = "congresso", catalog = "")
public class AddressEntity {
    private String cep;
    private String address;
    private String id;

    @Basic
    @Column(name = "CEP", nullable = true, length = 10)
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Basic
    @Column(name = "address", nullable = true, length = -1)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
