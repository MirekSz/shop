package pl.altkom.shop.model;

import javax.persistence.EntityListeners;

import org.hibernate.cfg.beanvalidation.BeanValidationEventListener;

@EntityListeners(BeanValidationEventListener.class)
public class BaseEntity {

}
