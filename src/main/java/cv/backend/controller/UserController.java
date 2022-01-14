package cv.backend.controller;

import cv.backend.dao.AddressRepository;
import cv.backend.dto.AddressDto;
import cv.backend.dto.UserDto;
import cv.backend.model.Address;
import cv.backend.model.User;
import cv.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/user")
    public boolean addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/user/{login}")
    public UserDto getUser(@PathVariable String login){
        return userService.getUser(login);
    }

    @GetMapping("/users")
    public Set<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

//    @GetMapping("/user/address")
//    public AddressDto getAddress(@RequestBody AddressDto addressDto){
//        return userService.getAddress(addressDto.getCity(), addressDto.getCountry(), addressDto.getStreet());
//    }

    @GetMapping("/user/address")
    public AddressDto getAddressByAddressDto(@RequestBody AddressDto addressDto){
        return userService.getAddressByAddressDto(addressDto);
    }

}
