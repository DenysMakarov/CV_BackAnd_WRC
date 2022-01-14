package cv.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import sun.util.resources.LocaleData;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = {"login"})
@Entity
public class User {
    private static final long serialVersionUID = 7186284224602196251L;
    @Id
    String login;
    String firstName;
    String lastName;
    String email;
    String password;
    Integer phoneNumber;
    String roles;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    Address address;
//    Set<Ticket> ticketSet;

}
