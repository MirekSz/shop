package pl.altkom.shop.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class SaleDocumentTest {
	@Test
	public void shoulSummarizeDocumentAfterItem() throws Exception {
		// given
		Product product = new Product();
		product.setPrice(BigDecimal.TEN);

		SaleDocumentItem saleDocumentItem = new SaleDocumentItem();
		saleDocumentItem.setProduct(product);
		saleDocumentItem.setQuantity(4);

		SaleDocument saleDocument = new SaleDocument();

		// when
		saleDocument.addItem(saleDocumentItem);

		// then
		assertThat(saleDocument.getTotalPrice()).isEqualTo(
				BigDecimal.valueOf(40));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shoulThrowExceptionWhenSale0Quantity() throws Exception {
		// given
		Product product = new Product();
		product.setPrice(BigDecimal.TEN);

		SaleDocumentItem saleDocumentItem = new SaleDocumentItem();
		saleDocumentItem.setProduct(product);
		saleDocumentItem.setQuantity(0);

		SaleDocument saleDocument = new SaleDocument();

		// when
		saleDocument.addItem(saleDocumentItem);

		// then
		assertThat(saleDocument.getTotalPrice()).isEqualTo(
				BigDecimal.valueOf(40));
	}
}
