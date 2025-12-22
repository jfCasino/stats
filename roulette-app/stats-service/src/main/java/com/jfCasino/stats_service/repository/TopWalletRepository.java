package com.jfCasino.stats_service.repository;


import com.jfCasino.stats_service.Entities.TopWallet;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopWalletRepository extends JpaRepository<TopWallet, Long> {

    List<TopWallet> findAllByOrderByBalanceDesc(Pageable pageable);
    List<TopWallet> findAllByOrderByBalanceAsc(Pageable pageable);
    List<TopWallet> findTop5ByOrderByBalanceDesc();

}

