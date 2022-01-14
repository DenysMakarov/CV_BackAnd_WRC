package cv.backend.dto;

import cv.backend.model.Address;
import cv.backend.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    String firstName;
    String lastName;
    String email;
    Integer phoneNumber;
    String roles;
    LocalDate birthDate;
    Address address;
    Set<TicketDto> tickets;
}
