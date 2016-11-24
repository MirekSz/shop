package pl.altkom.shop.www;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

public class MsgExceptionHandler extends AbstractPhaseInterceptor<Message> {
	public MsgExceptionHandler() {
		super(Phase.POST_LOGICAL);
	}

	@Override
	public void handleMessage(Message message) throws Fault {
		Fault content = (Fault) message.getContent(Exception.class);
		ConstraintViolationException cause = (ConstraintViolationException) content.getCause();
		ConstraintViolation<?> next = cause.getConstraintViolations().iterator().next();
		content.setMessage(next.toString());
		message.setContent(Exception.class, content);
		System.out.println(message);

	}
}
