package cv.backend.dto;

import cv.backend.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserWithoutAddressDto {
    String login;
    String username;
    String email;
    String phoneNumber;
    String roles;
    LocalDate birthDate;
//    Set<TicketDto> tickets;
}
