package cv.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = {"id"})
@Entity
public class Event {
    private static final long serialVersionUID = -5721367724690719099L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Long id;
    String textTop;
    String imgPath;
    String textCenter;
    String textBottom;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
    String price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(textBottom, event.textBottom) && Objects.equals(date, event.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textBottom, date);
    }
}
