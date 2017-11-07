package unitTests;

import java.math.BigDecimal;

import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;
import org.junit.jupiter.api.Test;

import com.revature.goshornm.bank.user.AdvancedManager;
import com.revature.goshornm.bank.user.User;

public class ExchangeRateTest {

	@Test
	public void testExchangeString() throws Exception {
		MonetaryAmount amount = Money.of(new BigDecimal(1000), "USD");
		AdvancedManager manager = new AdvancedManager(new User("TestUser", "TestUser", null));
		
		String to = "KRW";
		System.out.println(to);
		
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			
		}
		
		MonetaryAmount exchanged = manager.currencyConversion(amount, "KRW");
		
		
		
		System.out.println(amount);
		System.out.println(exchanged);
		
	}
}
