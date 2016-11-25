package pl.altkom.shop.cxf;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import pl.altkom.shop.model.SaleDocument;
import pl.altkom.shop.repo.ProductRepo;

@Component
@Path("/saleDocument")
@Produces(MediaType.APPLICATION_JSON)
public class SaleDocumentRESTWebService {
	@Inject
	ProductRepo repo;

	@GET
	@Path("/{id}")
	public SaleDocument findById(@PathParam("id") Long id) {
		repo.getAll(null);
		SaleDocument saleDocument = new SaleDocument();
		saleDocument.setNumber("REST " + id);
		return saleDocument;
	}

	@POST
	public void save(@Valid SaleDocument saleDocument) {
	}

}
