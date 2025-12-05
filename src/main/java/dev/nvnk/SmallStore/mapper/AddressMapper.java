package dev.nvnk.SmallStore.mapper;

import dev.nvnk.SmallStore.controller.dto.request.AddressRequest;
import dev.nvnk.SmallStore.controller.dto.response.AddressResponse;
import dev.nvnk.SmallStore.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toEntity (AddressRequest request){
        return Address
                .builder()
                .id(null)
                .cep(request.cep())
                .state(request.state())
                .city(request.city())
                .neighborhood(request.neighborhood())
                .number(request.number())
                .build();
    }

    public AddressResponse toResponse (Address entity){
        return new AddressResponse(
                entity.getId(),
                entity.getCep(),
                entity.getState(),
                entity.getCity(),
                entity.getNeighborhood(),
                entity.getNumber()
        );
    }

}
