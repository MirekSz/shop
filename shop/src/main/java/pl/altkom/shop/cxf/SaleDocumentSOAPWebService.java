package pl.altkom.shop.cxf;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.validation.Valid;

import org.springframework.stereotype.Component;

import pl.altkom.shop.model.SaleDocument;

@Component
@WebService
public class SaleDocumentSOAPWebService {
	@WebMethod
	public @Valid SaleDocument findById(Long id) {
		SaleDocument saleDocument = new SaleDocument();
		saleDocument.setNumber("SOAP " + id);

		return saleDocument;
	}

	@WebMethod
	public void save(@Valid SaleDocument saleDocument) {
	}
}
