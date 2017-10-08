package com.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Lord on 22.09.2017.
 */
@EnableWebSocketMessageBroker
@Configuration
public class JdbcConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/hello").withSockJS();
    }



    @Bean
    public static DataSource dataSource() {
        return new DriverManagerDataSource(
                "jdbc:postgresql://192.168.1.242:5432/contest-game",
                "testremote",
                "postgres"
        );
    }

    //private final JdbcTemplate jdbcTemplate;

    @Bean
    public JdbcTemplate ServiceData() {
        return new JdbcTemplate(dataSource());
    }

//        @Bean
//        public SqlSessionFactory sqlSessionFactory(DataSource dataSourse) {
//            Environment environment = new Environment("development",
//                    new JdbcTransactionFactory()/*ManagedTransactionFactory()*/,
//                 /*dataSource()*/dataSourse);
//            org.apache.ibatis.session.Configuration conf = new org.apache.ibatis.session.Configuration(environment);
//
//            String databaseId = new VendorDatabaseIdProvider().getDatabaseId(dataSourse);
//            if(databaseId == null) databaseId = "PostgreSQL";
//
//            conf.setDatabaseId(databaseId);
//            conf.setCacheEnabled(false);
//            conf.setLocalCacheScope(LocalCacheScope.STATEMENT);
//            return new SqlSessionFactoryBuilder().build(conf);
//        }

    @Bean
    public SqlSessionFactory sqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
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
