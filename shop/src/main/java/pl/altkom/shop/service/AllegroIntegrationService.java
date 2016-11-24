package pl.altkom.shop.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import pl.altkom.shop.Profiles;
import pl.altkom.shop.model.SaleDocument;

@Service
@Profile(Profiles.PROD)
public class AllegroIntegrationService {

	public void send(SaleDocument saleDocument) {
		throw new IllegalStateException("Only for prod use");

	}

}
