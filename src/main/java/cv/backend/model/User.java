package cv.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

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
    String username;
    String email;
    String password;
    String phoneNumber;
    String roles;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate = LocalDate.now(); // mock
    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    Address address;
    @OneToMany( mappedBy = "user")
    Set<Ticket> tickets;

    public User(String login, String username, String email, String password, String phoneNumber, LocalDate birthDate, Address address, Set<Ticket> tickets) {
        this.login = login;
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.address = address;
        this.tickets = tickets;
    }

    public User(String login, String username, String email, String password, Set<Ticket> tickets) {
        this.login = login;
        this.username = username;
        this.email = email;
        this.password = password;
        this.tickets = tickets;
    }

    public Ticket addTicket(Ticket ticket){
        tickets.add(ticket);
        return ticket;
    }

    private Ticket removeTicket(Ticket ticket){
        tickets.remove(ticket);
        return ticket;
    }

    public void setRoles(String roles) {
        this.roles = roles.toUpperCase();
    }
}
