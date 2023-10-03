package com.webnorm.prototypever1.dto.request.address;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.webnorm.prototypever1.dto.request.RequestInterface;
import com.webnorm.prototypever1.entity.member.Address;
import lombok.Data;
import lombok.Getter;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class AddressAddRequest implements RequestInterface {
    private String name;
    private String address;
    private String detailAddress;
    private String extraAddress;
    private String postCode;
    private boolean _default;

    @Override
    public Address toEntity() {
        return Address.builder()
                .name(name)
                .address(address)
                .detailAddress(detailAddress)
                .extraAddress(extraAddress)
                .postCode(postCode)
                .build();
    }
}
