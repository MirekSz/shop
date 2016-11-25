package pl.altkom.shop.integration;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import pl.altkom.shop.asynch.IntegrationDoneEvent;

@Component
public class AllegroInt {
	@Inject
	ApplicationEventPublisher eventBus;

	@Async
	public void add() {
		try {
			Thread.sleep(2000);
			System.out.println("Tik AllegroInt" + new Date());
			eventBus.publishEvent(new IntegrationDoneEvent());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
