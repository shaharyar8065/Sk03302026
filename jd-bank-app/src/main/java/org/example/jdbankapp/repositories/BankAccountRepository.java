package org.example.jdbankapp.repositories;

import org.example.jdbankapp.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
