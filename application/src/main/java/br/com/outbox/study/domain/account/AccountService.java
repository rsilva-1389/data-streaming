package br.com.outbox.study.domain.account;

import br.com.outbox.study.domain.outbox.EventType;
import br.com.outbox.study.domain.outbox.Outbox;
import br.com.outbox.study.domain.outbox.OutboxRepository;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class comments go here...
 *
 * @author Renan Farias Silva
 * @version 1.0 09/11/2020
 */
@Service
public class AccountService {

    @Autowired
    private OutboxRepository outboxRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void save(final Account account) {
        accountRepository.save(account);
        outboxRepository.save(Outbox.of(account, EventType.CREATE_ACCOUNT));
    }

    @Transactional
    public void update(final Account account) {
        accountRepository.save(account);
        outboxRepository.save(Outbox.of(account, EventType.UPDATE_ACCOUNT));
    }

    @Transactional
    public void delete(final Long id) {
        final Optional<Account> accountOptional = accountRepository.findById(id);
        Account account = accountOptional.get();

        accountRepository.delete(account);
        outboxRepository.save(Outbox.of(account, EventType.DELETE_ACCOUNT));
    }

    public List<Account> list() {
        return Collections.unmodifiableList(accountRepository.findAll());
    }


}
