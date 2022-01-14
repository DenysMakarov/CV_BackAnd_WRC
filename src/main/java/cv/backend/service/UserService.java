package cv.backend.service;

import cv.backend.dao.AddressRepository;
import cv.backend.dao.UserRepository;
import cv.backend.dto.AddressDto;
import cv.backend.dto.UserDto;
import cv.backend.model.Address;
import cv.backend.model.User;
import cv.backend.model.exeptions.EntityConflict;
import cv.backend.model.exeptions.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    UserRepository userRepository;
    AddressRepository addressRepository;
    ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, AddressRepository addressRepository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    @Transactional
    public boolean addUser(User user) {
        if (userRepository.getUserByLogin(user.getLogin()) != null) throw new EntityConflict();

        Address address = addressRepository.findAddressByCountryAndCityAndStreet(user.getAddress().getCountry(),
                user.getAddress().getCity(),
                user.getAddress().getStreet());
        if (address == null) {
            address = user.getAddress();
            addressRepository.save(address);
        }
        user.setAddress(address);
        userRepository.save(user);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUser(String login) {
        User user = userRepository.getUserByLogin(login);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public Set<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(e -> modelMapper.map(e, UserDto.class)).collect(Collectors.toSet());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto removeUser(String id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public AddressDto getAddressByAddressDto(AddressDto addressDto) {
        Address address = addressRepository.findAddressByCountryAndCityAndStreet(addressDto.getCountry(), addressDto.getCity(), addressDto.getStreet());
        if (address == null) throw new EntityNotFoundException();
        return modelMapper.map(address, AddressDto.class);
    }


}
