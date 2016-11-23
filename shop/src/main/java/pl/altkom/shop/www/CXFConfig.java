package pl.altkom.shop.www;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jws.WebService;
import javax.ws.rs.Path;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.validation.BeanValidationFeature;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import pl.altkom.shop.Profiles;

@Configuration
@ImportResource(value = { "classpath:META-INF/cxf/cxf.xml" })
@Profile(Profiles.WEB)
public class CXFConfig implements ApplicationContextAware {
	@Autowired
	Bus cxfBus;
	private ApplicationContext context;

	@PostConstruct
	public void soapServer() {
		String[] beanNamesForAnnotation = context.getBeanNamesForAnnotation(WebService.class);
		// cxfBus.getOutFaultInterceptors().add(new ExceptionHandler());
		for (String string : beanNamesForAnnotation) {
			Object bean = context.getBean(string);
			EndpointImpl endpoint = new EndpointImpl(cxfBus, bean);
			endpoint.publish("/" + bean.getClass().getSimpleName());
		}

		// enable features
		LoggingFeature loggingFeature = new LoggingFeature();
		loggingFeature.setPrettyLogging(true);
		cxfBus.setFeatures(Arrays.asList(loggingFeature, new BeanValidationFeature()));
	}

	@Bean
	public Server rsServer() {
		JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
		endpoint.setStaticSubresourceResolution(true);
		endpoint.setBus(cxfBus);
		endpoint.setAddress("/rest");
		endpoint.setProvider(new JacksonJsonProvider());
		String[] beanNamesForAnnotation = context.getBeanNamesForAnnotation(Path.class);
		List<Object> webServices = new ArrayList<>();
		for (String string : beanNamesForAnnotation) {
			webServices.add(context.getBean(string));
		}
		endpoint.setServiceBeans(webServices);
		return endpoint.create();
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
}
