package pl.altkom.shop.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class ProductPDFView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
				"attachement;filename=ala.pdf");
		Table table = new Table(1);
		table.addCell("Name");
		table.addCell("Wartość");
		document.add(table);

	}
}
