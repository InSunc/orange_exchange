package orange.exchange;

import lombok.RequiredArgsConstructor;
import orange.exchange.model.entity.Cash;
import orange.exchange.model.entity.CurrencyDictionary;
import orange.exchange.model.entity.Rate;
import orange.exchange.model.entity.User;
import orange.exchange.repository.CashRepository;
import orange.exchange.repository.CurrencyDictionaryRepository;
import orange.exchange.repository.RateRepository;
import orange.exchange.repository.UserRepository;
import orange.exchange.service.CurrencyDictionaryService;
import orange.exchange.service.RateService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
public class ExchangeApplication implements CommandLineRunner {
	// Dependencies to populate the DB
	private final CurrencyDictionaryRepository currencyDictionaryRepository;
	private final UserRepository userRepository;
	private final CashRepository cashRepository;
	private final RateRepository rateRepository;
	private final CurrencyDictionaryService currencyDictionaryService;

	public static void main(String[] args) {
		SpringApplication.run(ExchangeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Populate the DB
		CurrencyDictionary currencyDictionary = new CurrencyDictionary();
		currencyDictionary.setCode("MDL");
		currencyDictionaryRepository.save(currencyDictionary);
		currencyDictionary = new CurrencyDictionary();
		currencyDictionary.setCode("USD");
		currencyDictionaryRepository.save(currencyDictionary);
		currencyDictionary = new CurrencyDictionary();
		currencyDictionary.setCode("EUR");
		currencyDictionaryRepository.save(currencyDictionary);

		User user = new User();
		user.setUsername("bob");
		userRepository.save(user);
		user = new User();
		user.setUsername("stan");
		userRepository.save(user);
		user = new User();
		user.setUsername("ann");
		userRepository.save(user);

		Cash cash = new Cash();
		cash.setUser(user);
		cash.setCurrency(currencyDictionary);
		cash.setAmount(500);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = "12/12/2019";
		cash.setDate(LocalDate.parse(date, formatter));
		cashRepository.save(cash);

		Rate rate = new Rate();
		rate.setRate(1);
		rate.setDate(LocalDate.now());
		rate.setBuyFor(19);
		rate.setSellFor(21);
		rate.setCurrency(currencyDictionary);
		rateRepository.save(rate);
	}
}
