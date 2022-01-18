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
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Id
    @SequenceGenerator(name = "id", sequenceName = "id", allocationSize = 1, initialValue = 10000000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
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
