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
    String event;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_login")
    User user;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date = LocalDate.now();
    String phoneNumber;
    String place;
    boolean expDate;

    public Ticket(String event) {
        this.event = event;
    }

    public Ticket(String event, User user, LocalDate date, String phoneNumber, String place) {
        this.event = event;
        this.user = user;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.place = place;
    }
}
