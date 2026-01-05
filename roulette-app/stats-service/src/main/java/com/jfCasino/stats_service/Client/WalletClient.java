package com.jfCasino.stats_service.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jfCasino.stats_service.dto.internal.WalletResponse;

@FeignClient(
    name = "wallet-service",
    url = "${wallet.service.url}" // Use property placeholder
)
public interface WalletClient {

    @GetMapping("/wallets")
    public ResponseEntity<List<WalletResponse>> getAllWallets(@RequestParam(name = "order",defaultValue = "asc") String order,
    @RequestParam(name = "limit", defaultValue = "10") int limit);

}