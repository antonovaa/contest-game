package com.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by Lord on 22.09.2017.
 */
@EnableWebSocketMessageBroker
@Configuration
@PropertySources(@PropertySource("file:${user.dir}/conf/application.properties"))
public class JdbcConfig extends AbstractWebSocketMessageBrokerConfigurer {


  private final DataSource dataSource;

  @Autowired
  public JdbcConfig(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
    config.enableSimpleBroker("/topic");
    config.setApplicationDestinationPrefixes("/app");
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/getMessagePoint").withSockJS();
  }


  @Bean
  public JdbcTemplate ServiceData() {
    return new JdbcTemplate(dataSource);
  }


//        @Configuration
//        @EnableSwagger2
//        public static class SwaggerConfig extends WebMvcConfigurerAdapter {
//            @Override
//            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                registry.addResourceHandler("/**").addResourceLocations("classpath:/resources/");
//            }
//        }
}
