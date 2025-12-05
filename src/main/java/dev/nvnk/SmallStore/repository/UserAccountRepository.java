package dev.nvnk.SmallStore.repository;

import dev.nvnk.SmallStore.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByCpf (String cpf);
    Optional<UserAccount> findByEmail (String email);
}
