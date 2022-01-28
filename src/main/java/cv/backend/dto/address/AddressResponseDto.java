package cv.backend.dto.address;

import cv.backend.dto.users.UserWithoutAddressDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddressResponseDto {
    String country;
    String city;
    String street;
    Set<UserWithoutAddressDto> users;
}
