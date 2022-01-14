package cv.backend.model;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String event;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_login")
    User user;
    LocalDate date = LocalDate.now();

    public Ticket(String event) {
        this.event = event;
    }

    //    numberOfSlide: 1,
//    firstName: "",
//    secondName: "",
//    phoneNumber: "",
//    date: "You need to select event",
//    place: "",
//    nameTicket: "CHOOSE EVENT",
//    month: ""
}