package dev.nvnk.SmallStore.service;

import dev.nvnk.SmallStore.controller.dto.request.UserAccountRequest;
import dev.nvnk.SmallStore.controller.dto.response.UserAccountResponse;
import dev.nvnk.SmallStore.entity.UserAccount;
import dev.nvnk.SmallStore.exception.UserCpfAlreadyInUseException;
import dev.nvnk.SmallStore.exception.UserEmailAlreadyInUseException;
import dev.nvnk.SmallStore.mapper.UserAccountMapper;
import dev.nvnk.SmallStore.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserAccountRepository repository;
    private final UserAccountMapper userAccountMapper;
    private final PasswordEncoder passwordEncoder;

    public UserAccountResponse registerUserAccount (UserAccountRequest userAccountDTO){

        if (repository.findByEmail(userAccountDTO.email()).isPresent()){
            throw new UserEmailAlreadyInUseException(("This email address is already in use."));
        }

        if (repository.findByCpf(userAccountDTO.cpf()).isPresent()){
            throw new UserCpfAlreadyInUseException(("This CPF is already in use."));
        }

        UserAccount user = userAccountMapper.toEntity(userAccountDTO);

        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));

        UserAccount userSaved = repository.save(user);

        return userAccountMapper.toResponse(userSaved);
    }

}
