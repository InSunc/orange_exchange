package orange.exchange.model.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Cash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    float amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    CurrencyDictionary currency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    User user;


    @Column
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDate date;
}
