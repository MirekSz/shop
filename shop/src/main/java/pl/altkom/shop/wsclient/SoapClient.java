package pl.altkom.shop.wsclient;

import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;

import pl.altkom.shop.wsclient.soap.SaleDocument;
import pl.altkom.shop.wsclient.soap.SaleDocumentSOAPWebService;
import pl.altkom.shop.wsclient.soap.SaleDocumentSOAPWebServiceService;

public class SoapClient {

	public static void main(String[] args) {
		SaleDocumentSOAPWebServiceService saleDocumentSOAPWebServiceService = new SaleDocumentSOAPWebServiceService();
		SaleDocumentSOAPWebService saleDocumentSOAPWebServicePort = saleDocumentSOAPWebServiceService
				.getSaleDocumentSOAPWebServicePort(new LoggingFeature());
		Client client = ClientProxy.getClient(saleDocumentSOAPWebServicePort);
		HTTPConduit http = (HTTPConduit) client.getConduit();
		AuthorizationPolicy authPolicy = new AuthorizationPolicy();
		authPolicy.setAuthorizationType("Basic");
		authPolicy.setUserName("user");
		authPolicy.setPassword("user");
		http.setAuthorization(authPolicy);
		SaleDocument findById = saleDocumentSOAPWebServicePort.findById(1L);

	}

}
