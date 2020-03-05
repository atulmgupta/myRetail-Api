package com.target.retail.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;

@EnableMongoRepositories(basePackages = "com.target.retail.repository")
@Configuration
public class MongoConfig extends AbstractMongoConfiguration {
    private static final Logger log = LoggerFactory.getLogger(MongoConfig.class);

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.port}")
    private String port;

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Value("${spring.data.mongodb.username}")
    private String username;

    @Value("${spring.data.mongodb.username.max-wait:5000}")
    private int maxWait;

    @Override
    protected Collection<String> getMappingBasePackages() {
        return super.getMappingBasePackages();
    }

    @Bean
    @Primary
    @Override
    public MongoClient mongoClient() {
        log.info("Creating Mongo Connection {} {} {} {}", username, password.replaceAll(password, "*******"), host, database);
        ServerAddress serverAddress = new ServerAddress(host, Integer.parseInt(port));
        MongoClient mongoClient = null;
        if (StringUtils.isNoneEmpty(username)) {
            MongoCredential mongoCredential = MongoCredential.createCredential(username, database, password.toCharArray());
            mongoClient = new MongoClient(serverAddress, mongoCredential, MongoClientOptions.builder().minConnectionsPerHost(20).maxWaitTime(maxWait).build());
        } else {
            mongoClient = new MongoClient(serverAddress);
        }
        return mongoClient;
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }
}
