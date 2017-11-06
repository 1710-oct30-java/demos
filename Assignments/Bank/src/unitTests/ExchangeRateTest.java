package unitTests;

import java.math.BigDecimal;

import javax.money.CurrencyUnit;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

import com.revature.goshornm.bank.AdvancedManager;
import com.revature.goshornm.bank.CurrencyOptions;
import com.revature.goshornm.bank.User;

public class ExchangeRateTest {

	@Test
	public void testExchange() throws Exception {
		MonetaryAmount amount = Money.of(new BigDecimal(1000), "USD");
		AdvancedManager manager = new AdvancedManager(new User("TestUser", "TestUser", null));
		
		CurrencyUnit to = new CurrencyOptions().promptForChangeCurrencyFromDefault();
		
		System.out.println(to);
		
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			
		}
		
		MonetaryAmount exchanged = manager.getExchangeRates(amount, to);
		
		
		
		System.out.println(amount);
		System.out.println(exchanged);
		
	}
}
