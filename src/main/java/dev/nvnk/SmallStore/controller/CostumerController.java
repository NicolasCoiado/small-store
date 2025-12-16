package dev.nvnk.SmallStore.controller;

import dev.nvnk.SmallStore.controller.dto.request.CostumerRequest;
import dev.nvnk.SmallStore.controller.dto.response.CostumerResponse;
import dev.nvnk.SmallStore.service.CostumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CostumerController {

    private final CostumerService service;

    public ResponseEntity<Map<String, Object>> registerCostumer (@RequestBody CostumerRequest costumerRequest) {
        CostumerResponse costumerResponse = service.registerCostumer(costumerRequest);

        Map<String, Object> response = new HashMap<>();
        response.put("Message", "The costumer has been successfully registered.");
        response.put("Costumer", costumerResponse);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    public ResponseEntity<Map<String, Object>> findCostumerById (@PathVariable Long id){
        CostumerResponse costumer = service.findCostumerById(id);

        Map<String, Object> response = new HashMap<>();
        response.put("Costumer", costumer);

        return ResponseEntity.ok(response);
    }
}
