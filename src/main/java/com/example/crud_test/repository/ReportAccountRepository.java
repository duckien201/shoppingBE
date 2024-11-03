package com.example.crud_test.repository;

import com.example.crud_test.model.ReportAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportAccountRepository extends JpaRepository<ReportAccount, Long> {
    ReportAccount findById(long id);
}
