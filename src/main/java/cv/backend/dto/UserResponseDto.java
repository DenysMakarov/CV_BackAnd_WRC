package cv.backend.dto;

import cv.backend.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserResponseDto {
    String login;
    String username;
    String email;
    String password;
    String roles;
    Set<Ticket> tickets;
}
