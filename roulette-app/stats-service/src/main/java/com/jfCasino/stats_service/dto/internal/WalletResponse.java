package com.jfCasino.stats_service.dto.internal;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;



@Schema(
    name = "WalletResponse",
    description = "Response representing a user's wallet in the statistics service"
)
public class WalletResponse {

    @Schema(
        description = "Unique identifier of the wallet",
        example = "3fa85f64-5717-4562-b3fc-2c963f66afa6"
    )
    private UUID walletID;

    @Schema(
        description = "Current balance of the wallet",
        example = "850"
    )
    private int balance;


    public WalletResponse() {};

    public WalletResponse(UUID walletID, int balance) {
        this.walletID = walletID;
        this.balance = balance;
    }

    //getters and setters
    public UUID getwalletID() {
        return walletID;
    }

    public void setwalletID(UUID walletID) {
        this.walletID = walletID;
    }

    public int getBalance() {
        return balance;
    }
    
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
