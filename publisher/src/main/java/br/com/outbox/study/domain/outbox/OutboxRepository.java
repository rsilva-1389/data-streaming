package br.com.outbox.study.domain.outbox;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class comments go here...
 *
 * @author Renan Farias Silva
 * @version 1.0 09/11/2020
 */
@Repository
public interface OutboxRepository extends JpaRepository<Outbox, Long> {

}
