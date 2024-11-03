package com.example.crud_test.service;

import com.example.crud_test.dto.TransferDto;
import com.example.crud_test.model.HistoryWallet;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WalletService {
    List<HistoryWallet> getHistoryWallet(long idUser);

    void addHistoryWallet(HistoryWallet historyWallet);

    ResponseEntity<?> transferWallet(TransferDto transferDto);

    ResponseEntity<?> getHistoryByCode(String code);
}
