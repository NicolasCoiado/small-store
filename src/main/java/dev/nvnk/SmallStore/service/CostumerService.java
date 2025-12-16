package dev.nvnk.SmallStore.service;

import dev.nvnk.SmallStore.controller.dto.request.CostumerRequest;
import dev.nvnk.SmallStore.controller.dto.response.CostumerResponse;
import dev.nvnk.SmallStore.entity.Costumer;
import dev.nvnk.SmallStore.exception.CostumerNotFoundException;
import dev.nvnk.SmallStore.mapper.CostumerMapper;
import dev.nvnk.SmallStore.repository.CostumerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CostumerService {

    private final CostumerRepository repository;
    private final CostumerMapper mapper;

    public CostumerResponse registerCostumer (CostumerRequest costumerRequest){
        Costumer costumerSaved = repository.save(mapper.toEntity(costumerRequest));
        return mapper.toResponse(costumerSaved);
    }

    public CostumerResponse findCostumerById (Long id){
        Costumer costumer = repository.findById(id).orElseThrow(() -> new CostumerNotFoundException("Costumer not found."));
        return mapper.toResponse(costumer);
    }

}
