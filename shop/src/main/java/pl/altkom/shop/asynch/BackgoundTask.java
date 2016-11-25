package pl.altkom.shop.asynch;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BackgoundTask {

	@Scheduled(fixedDelay = 10000)
	public void doit() {
		System.out.println("Tik " + new Date());
	}
}
