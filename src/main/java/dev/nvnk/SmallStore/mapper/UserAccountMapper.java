package dev.nvnk.SmallStore.mapper;


import dev.nvnk.SmallStore.controller.dto.request.UserAccountRequest;
import dev.nvnk.SmallStore.controller.dto.response.UserAccountResponse;
import dev.nvnk.SmallStore.entity.UserAccount;
import org.springframework.stereotype.Component;

@Component
public class UserAccountMapper {

    public UserAccount toEntity (UserAccountRequest request){
        return UserAccount.builder()
                .id(null)
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .cpf(request.cpf())
                .role(request.role())
                .company(request.company())
                .build();
    }

    public UserAccountResponse toResponse (UserAccount entity){
        return new UserAccountResponse (
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getCpf(),
                entity.getRole(),
                entity.getCompany(),
                entity.getCreatedAt()
        );
    }
}
