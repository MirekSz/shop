package pl.altkom.shop.service;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.model.SaleDocument;
import pl.altkom.shop.model.SaleDocumentItem;

@Service
public class SaleDocumentService {
	@Inject
	EntityManager em;
	@Inject
	AllegroIntegrationService service;

	public void insert(DocumentRequest documentRequest) {
		SaleDocument saleDocument = new SaleDocument();
		em.persist(saleDocument);
		List<Item> items = documentRequest.items;
		for (Item item : items) {
			SaleDocumentItem saleDocumentItem = new SaleDocumentItem();
			Product product = em.find(Product.class, item.idProduct);
			saleDocumentItem.setProduct(product);
			saleDocumentItem.setQuantity(item.quantity);
			saleDocumentItem.setSaleDocument(saleDocument);
			product.setQuantity(product.getQuantity() - item.quantity);
		}
		service.send(saleDocument);
	}

}
