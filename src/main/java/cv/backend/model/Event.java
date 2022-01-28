package cv.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@EqualsAndHashCode(of = {"id"})
@Entity
public class Event {
    private static final long serialVersionUID = -5721367724690719099L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String place;
    String titleDesc;
    String imgPath;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
    Double price;
    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    Set<Ticket> tickets = new HashSet<>();

    public Event( String title, String place, String titleDesc, String imgPath, LocalDate date, Double price, Set<Ticket> tickets) {
        this.title = title;
        this.place = place;
        this.titleDesc = titleDesc;
        this.imgPath = imgPath;
        this.date = date;
        this.price = price;
    }

    public Ticket addTicketToEvent(Ticket ticket){
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(title, event.title) && Objects.equals(date, event.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date);
    }
}
