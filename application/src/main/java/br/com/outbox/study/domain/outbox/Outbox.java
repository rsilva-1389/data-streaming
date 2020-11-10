package br.com.outbox.study.domain.outbox;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import javax.persistence.*;
import org.hibernate.annotations.TypeDef;

/**
 * Class comments go here...
 *
 * @author Renan Farias Silva
 * @version 1.0 09/11/2020
 */
@Entity
@TypeDef(
        typeClass = JsonBinaryType.class,
        defaultForType = JsonNode.class
)
public class Outbox {

    @Id
    @GeneratedValue
    private Long id;

    private Long contentId;

    @Column(columnDefinition = "jsonb")
    private JsonNode content;

    @Enumerated(EnumType.STRING)
    private EventType type;

    private LocalDateTime createdOn;

    public Outbox() {
    }

    public static final Outbox of(final Object object, final EventType type) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.convertValue(object, JsonNode.class);
        Long id = node.get("id").asLong();

        return new Outbox(id, node, type);
    }

    private Outbox(final Long id, final JsonNode content, final EventType type) {
        this.contentId = id;
        this.content = content;
        this.type = type;
        this.createdOn = LocalDateTime.now(ZoneOffset.UTC);
    }
}
