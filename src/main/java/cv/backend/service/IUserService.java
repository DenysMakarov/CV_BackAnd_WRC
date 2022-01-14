package cv.backend.service;

import cv.backend.dto.AddressDto;
import cv.backend.dto.TicketDto;
import cv.backend.dto.UserDto;
import cv.backend.model.Address;
import cv.backend.model.User;

import java.util.Set;

public interface IUserService {
    boolean addUser(User user);

    UserDto getUser(String id);

    Set<UserDto> getAllUsers();

    UserDto updateUser(UserDto userDto);

    UserDto removeUser(String id);

    AddressDto getAddressByAddressDto(AddressDto addressDto);

    TicketDto addTicket(String login, TicketDto ticketDto);
}
