package pl.altkom.shop.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import pl.altkom.shop.model.Product;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

@Component(value = "ProductPDFView")
public class ProductPDFView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("content-disposition",
				"attachment; filename=products.pdf");
		List<Product> prodcuts = (List<Product>) model.get("products");

		Table table = new Table(1);
		table.addCell("id");
		table.addCell("Name");
		table.addCell("quantity");
		table.addCell("price");

		for (Product product : prodcuts) {
			if (product.getName() == null) {
				continue;
			}
			table.addCell(product.getId().toString());
			table.addCell(product.getName());
			table.addCell(product.getQuantity().toString());
			table.addCell(product.getPrice().toString());
		}

		document.add(table);

	}
}
