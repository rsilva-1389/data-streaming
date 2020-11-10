package br.com.outbox.study.domain.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Class comments go here...
 *
 * @author Renan Farias Silva
 * @version 1.0 09/11/2020
 */
@Entity
public class Account {

    @Id
    @GeneratedValue
    @JsonProperty
    private Long id;

    @JsonProperty
    private String username;

    @JsonProperty
    private String email;

    public Account() {
    }

    public Account(final String username, final String password, final String email) {
        this.username = username;
        this.email = email;
    }

}
