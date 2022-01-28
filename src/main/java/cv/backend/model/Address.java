package cv.backend.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
public class Address implements Serializable {
    private static final long serialVersionUID = -6138544089636649083L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    long id;
    String country;
    String city;
    String street;
    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    Set<User> users;

    public Address(String country, String city, String street) {
        this.country = country;
        this.city = city;
        this.street = street;
    }
}
