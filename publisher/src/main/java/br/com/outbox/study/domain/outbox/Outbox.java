package br.com.outbox.study.domain.outbox;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import java.util.UUID;
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
    private UUID id;

    @Column(name = "aggregatetype")
    private String aggregateType;

    @Column(name = "aggregateid")
    private String aggregateId;

    @Column(columnDefinition = "jsonb")
    private JsonNode payload;

    @Enumerated(EnumType.STRING)
    private EventType type;

    public Outbox() {
    }

    public static final Outbox of(final Object object, final EventType type) {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode payload = mapper.convertValue(object, JsonNode.class);
        String aggregateType = object.getClass().getSimpleName();
        String aggregateId = payload.get("id").asText();

        return new Outbox(aggregateType, aggregateId, payload, type);
    }

    private Outbox(final String aggregateType, final String aggregateId, final JsonNode payload, final EventType type) {
        this.id = UUID.randomUUID();
        this.aggregateType = aggregateType;
        this.aggregateId = aggregateId;
        this.payload = payload;
        this.type = type;
    }
}