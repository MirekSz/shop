package pl.altkom.shop.service;

public class ProductAddedEvent {
	private Long productId;

	public ProductAddedEvent(Long id) {
		productId = id;
		// TODO Auto-generated constructor stub
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
}
