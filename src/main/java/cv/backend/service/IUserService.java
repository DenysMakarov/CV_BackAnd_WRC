package cv.backend.service;

import cv.backend.dto.*;
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

    TicketDto addTicket(String login, EventParamDto eventParamDto);
}
