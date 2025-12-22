package com.jfCasino.stats_service.repository;


import com.jfCasino.stats_service.Entities.TopWallet;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import java.util.List;

@Repository
@EnableJpaRepositories("com.jfCasino.stats_service.repository")
@EntityScan("com.jfCasino.stats_service.Entities")
public interface TopWalletRepository extends JpaRepository<TopWallet, UUID> {

    List<TopWallet> findAllByOrderByBalanceDesc(Pageable pageable);
    List<TopWallet> findAllByOrderByBalanceAsc(Pageable pageable);
    List<TopWallet> findTop5ByOrderByBalanceDesc();

}

