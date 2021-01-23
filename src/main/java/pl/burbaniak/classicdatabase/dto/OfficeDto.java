package pl.burbaniak.classicdatabase.dto;

import lombok.Builder;
import lombok.Value;
import pl.burbaniak.classicdatabase.dao.entity.Office;

@Value
@Builder
public class OfficeDto {

    private Long officeCode;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;

    public static OfficeDto from(Office office){
        return builder().officeCode(office.getOfficeCode())
                .city(office.getCity())
                .phone(office.getPhone())
                .addressLine1(office.getAddressLine1())
                .addressLine2(office.getAddressLine2())
                .state(office.getState())
                .country(office.getCountry())
                .postalCode(office.getPostalCode())
                .territory(office.getTerritory())
                .build();
    }
}
