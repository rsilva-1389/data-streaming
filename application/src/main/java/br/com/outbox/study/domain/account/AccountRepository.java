package br.com.outbox.study.domain.account;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class comments go here...
 *
 * @author Renan Farias Silva
 * @version 1.0 09/11/2020
 */
interface AccountRepository extends JpaRepository<Account, Long> {
}
