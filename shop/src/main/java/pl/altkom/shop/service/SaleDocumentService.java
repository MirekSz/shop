package pl.altkom.shop.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.altkom.shop.aop.Monitoring;
import pl.altkom.shop.model.Product;
import pl.altkom.shop.model.SaleDocument;
import pl.altkom.shop.model.SaleDocumentItem;
import pl.altkom.shop.repo.ProductRepo;

@Service
@Monitoring
@Transactional
public class SaleDocumentService {
	@Inject
	ProductRepo productRepo;

	public void insert(DocumentRequest documentRequest) {
		SaleDocument saleDocument = new SaleDocument();
		productRepo.save(saleDocument);
		List<Item> items = documentRequest.items;
		for (Item item : items) {
			SaleDocumentItem saleDocumentItem = new SaleDocumentItem();
			Product product = productRepo.find(item.idProduct);
			saleDocumentItem.setProduct(product);
			saleDocumentItem.setQuantity(item.quantity);
			saleDocumentItem.setSaleDocument(saleDocument);
			product.setQuantity(product.getQuantity() - item.quantity);

		}
	}

	public Integer count() {
		return null;

	}

}
