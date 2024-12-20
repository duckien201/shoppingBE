package com.example.crud_test.controller;

import com.example.crud_test.dto.TransferDto;
import com.example.crud_test.model.HistoryWallet;
import com.example.crud_test.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.crud_test.constant.Constant.URL_ORIGIN;

@RestController
@CrossOrigin(URL_ORIGIN)
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @GetMapping
    public List<HistoryWallet> getHistoryWallet(@RequestParam long idUser) {
        return walletService.getHistoryWallet(idUser);
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> transferWallet(@RequestBody TransferDto transferDto) {
        return walletService.transferWallet(transferDto);
    }

    @GetMapping("/getHistory")
    public ResponseEntity<?> getHistory(@RequestParam String code) {
        return walletService.getHistoryByCode(code);
    }
}
