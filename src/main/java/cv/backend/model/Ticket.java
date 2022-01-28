package cv.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Ticket {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @SequenceGenerator(name = "id", sequenceName = "id", allocationSize = 1, initialValue = 10000000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
    long id;
    String title;
    String place;
    String loginOfUser;
    String nameOfUser;
    String email;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_login")
    User user;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date = LocalDate.now();
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    Event event;
    Double price;

    public Ticket(String title, String place, String userLogin, String userName, String email, User user, LocalDate date, Event event, Double price) {
        this.title = title;
        this.place = place;
        this.loginOfUser = userLogin;
        this.nameOfUser = userName;
        this.email = email;
        this.user = user;
        this.date = date;
        this.event = event;
        this.price = price;
    }

    public Ticket(String title, String place, User user, LocalDate date, Event event, Double price) {
        this.title = title;
        this.place = place;
        this.user = user;
        this.date = date;
        this.event = event;
        this.price = price;
    }
}
