package orange.exchange.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "currency_dictionary")
public class CurrencyDictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String code;
    String description;
}
