package pl.altkom.shop;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import pl.altkom.shop.asynch.IntegrationDoneEvent;

@Component
public class NewsletterService {
	@EventListener(classes = IntegrationDoneEvent.class)
	public void handle(IntegrationDoneEvent event) {
		System.out.println(event);
	}
}
