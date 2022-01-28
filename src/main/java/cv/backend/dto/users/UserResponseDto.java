package cv.backend.dto.users;

import cv.backend.dto.address.AddressDto;
import cv.backend.dto.tickets.TicketForUserDto;
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
    AddressDto address;
    Set<TicketForUserDto> tickets;
}
