package dev.nvnk.SmallStore.controller;

import dev.nvnk.SmallStore.controller.dto.request.AddressRequest;
import dev.nvnk.SmallStore.controller.dto.response.AddressResponse;
import dev.nvnk.SmallStore.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> registerAddress(@Valid @RequestBody AddressRequest request) {
        AddressResponse addressSaved = addressService.registerAddress(request);

        Map<String, Object> response = new HashMap<>();

        response.put("Message", "Address saved successfully.");
        response.put("Address", addressSaved);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> findAddressById(@PathVariable Long id){
        AddressResponse address = addressService.findById(id);

        Map<String, Object> response = new HashMap<>();

        response.put("Address: ", address);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> replaceAddress(@PathVariable Long id, @Valid @RequestBody AddressRequest request){
        AddressResponse address = addressService.replaceAddress(id, request);
        Map<String, Object> response = new HashMap<>();

        response.put("Message","Address successfully replaced.");
        response.put("Address", address);

        return ResponseEntity.ok(response);
    }
}