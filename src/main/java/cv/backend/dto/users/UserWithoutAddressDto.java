package cv.backend.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
