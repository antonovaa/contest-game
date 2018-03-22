package com.listners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;

public class ListnerDestroyedSession  implements ApplicationListener<HttpSessionDestroyedEvent> {


   private static final Logger logger = LoggerFactory.getLogger(ListnerDestroyedSession.class);

   @Override
   public void onApplicationEvent(HttpSessionDestroyedEvent event) {
      logger.debug(event.getSession().getId()+" destroyed");
      System.out.println(event.getSession().getId()+" destroyed");

   }
}
