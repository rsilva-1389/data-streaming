package br.com.outbox.study.entrypoint;

import br.com.outbox.study.domain.account.Account;
import br.com.outbox.study.domain.account.AccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Class comments go here...
 *
 * @author Renan Farias Silva
 * @version 1.0 09/11/2020
 */
@RestController
@RequestMapping("/account")
public class AccountResource {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public void create(@RequestBody Account account) {
        accountService.save(account);
    }

    @PutMapping
    public void update(@RequestBody Account account) {
        accountService.update(account);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        accountService.delete(id);
    }

    @GetMapping
    public List<Account> list() {
        return accountService.list();
    }
}
