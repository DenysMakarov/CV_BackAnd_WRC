package cv.backend.dto.users;

import cv.backend.dto.address.AddressDto;
import cv.backend.dto.tickets.TicketForUserDto;
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
    String login;
    String username;
    String email;
    String password;
    String phoneNumber;
    String roles;
    LocalDate birthDate;
    AddressDto address;
    Set<TicketForUserDto> tickets;
}
