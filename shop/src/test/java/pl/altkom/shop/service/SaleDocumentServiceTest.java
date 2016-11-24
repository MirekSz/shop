package pl.altkom.shop.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.junit.Test;

import pl.altkom.shop.BaseTest;
import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;
import pl.altkom.shop.repo.SaleDocumentRepo;

public class SaleDocumentServiceTest extends BaseTest {
	@Inject
	SaleDocumentService service;
	@Inject
	ProductRepo productRepo;
	@Inject
	SaleDocumentRepo saleDocumentRepo;

	@Test
	public void shouldUpdateStockWhenSaleProduct() {
		// given
		int BEGNING_STOCK = 100;
		Product product = new Product("Rower", "", BEGNING_STOCK, BigDecimal.TEN);
		Long prodId = productRepo.insert(product);
		DocumentRequest documentRequest = new DocumentRequest();
		documentRequest.items.add(new Item(prodId, 3));

		// when
		service.insert(documentRequest);

		// then@EntityGraph
		assertThat(product.getQuantity()).isLessThan(BEGNING_STOCK);
		assertThat(product.getQuantity()).isLessThan(BEGNING_STOCK);
	}

}
