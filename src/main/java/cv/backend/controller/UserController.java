package cv.backend.controller;

import cv.backend.dto.address.AddressDto;
import cv.backend.dto.address.AddressResponseDto;
import cv.backend.dto.events.EventParamDto;
import cv.backend.dto.tickets.TicketForEventDto;
import cv.backend.dto.tickets.TicketForUserDto;
import cv.backend.dto.users.UserDto;
import cv.backend.dto.users.UserResponseDto;
import cv.backend.model.Ticket;
import cv.backend.model.User;
import cv.backend.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/user/{login}")
    public UserDto getUser(@PathVariable String login) {
        return userService.getUser(login);
    }

    @PostMapping("/login")
    public UserResponseDto login(Authentication authentication) {
        return userService.loginUser(authentication.getName());
    }

    @GetMapping("/users")
    public Set<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/address")
    public AddressResponseDto getAddressByAddressDto(@RequestBody AddressDto addressDto) {
        return userService.getAddressByAddressDto(addressDto);
    }

    @PutMapping("/user/tickets/{login}/{id}")
    public TicketForUserDto buyTicket(@PathVariable String login, @PathVariable Long id) {
        return userService.addTicket(login, id);
    }

    @DeleteMapping("/ticket/remove/{id}")
    public TicketForEventDto removeTicket(@PathVariable Long id){
        return userService.removeTicket(id);
    }
    @GetMapping("/ticket/{id}")
    public TicketForEventDto findTicketById(@PathVariable Long id){
        return userService.findTicketById(id);
    }

}
