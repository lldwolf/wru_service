package lld.wru.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BaseController {
    protected ApplicationContext applicationContext;

    public BaseController() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
