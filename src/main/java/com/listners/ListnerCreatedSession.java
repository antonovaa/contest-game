package com.listners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.web.session.HttpSessionCreatedEvent;

public class ListnerCreatedSession implements ApplicationListener<HttpSessionCreatedEvent>  {


   private static final Logger logger = LoggerFactory.getLogger(ListnerCreatedSession.class);


   @Override
   public void onApplicationEvent(HttpSessionCreatedEvent event) {
      logger.debug(event.getSession().getId()+" created");
      System.out.println(event.getSession().getId()+" created");
   }
}
