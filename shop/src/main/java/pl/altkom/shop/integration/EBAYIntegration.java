package pl.altkom.shop.integration;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import pl.altkom.shop.service.ProductAddedEvent;

@Component
public class EBAYIntegration {
	@EventListener
	public void onEvent(ProductAddedEvent event) {
		System.out.println("COPY EVENT " + event);
	}
}
