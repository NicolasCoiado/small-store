package dev.nvnk.SmallStore.service;

import dev.nvnk.SmallStore.controller.dto.request.AddressRequest;
import dev.nvnk.SmallStore.controller.dto.response.AddressResponse;
import dev.nvnk.SmallStore.entity.Address;
import dev.nvnk.SmallStore.exception.AddressNotFoundException;
import dev.nvnk.SmallStore.mapper.AddressMapper;
import dev.nvnk.SmallStore.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    public AddressResponse registerAddress (AddressRequest request){
        Address saved = addressRepository.save(addressMapper.toEntity(request));
        return addressMapper.toResponse(saved);
    }

    public AddressResponse findById (Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("Address not found."));
        return addressMapper.toResponse(address);
    }

    public AddressResponse replaceAddress (Long id, AddressRequest request){
        addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException("Address not found."));
        Address entity = addressMapper.toEntity(request);
        entity.setId(id);
        return addressMapper.toResponse(addressRepository.save(entity));
    }

    public void deleteAddress (Long id){
        Address address = addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException("Address not found."));
        addressRepository.delete(address);
    }

}
