package cv.backend.dto;

import cv.backend.model.Address;
import cv.backend.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponseDto {
    String username;
    String email;
    String phoneNumber;
    String roles;
    LocalDate birthDate;
    Address address;
    Set<TicketDto> tickets;
}
