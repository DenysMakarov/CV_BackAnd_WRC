package cv.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
