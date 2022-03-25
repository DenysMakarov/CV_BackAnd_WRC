package cv.backend.service.userService;

import cv.backend.dto.address.AddressDto;
import cv.backend.dto.address.AddressResponseDto;
import cv.backend.dto.events.EventParamDto;
import cv.backend.dto.tickets.TicketForEventDto;
import cv.backend.dto.tickets.TicketForUserDto;
import cv.backend.dto.users.UserDto;
import cv.backend.dto.users.UserResponseDto;
import cv.backend.model.Ticket;
import cv.backend.model.User;

import java.util.Set;

public interface IUserService {
    boolean addUser(User user);

    UserDto getUser(String id);

    UserResponseDto loginUser(String id);

    Set<UserDto> getAllUsers();

    UserDto updateUser(UserDto userDto);

    UserDto removeUser(String id);

    AddressResponseDto getAddressByAddressDto(AddressDto addressDto);

    TicketForUserDto addTicket(String login, Long id);

    TicketForEventDto removeTicket(String login, Long id);

    TicketForEventDto findTicketById(Long id);

    UserDto findUserTest(String login);
}
