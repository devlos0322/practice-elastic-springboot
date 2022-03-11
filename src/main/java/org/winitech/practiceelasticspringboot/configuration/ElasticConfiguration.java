package org.winitech.practiceelasticspringboot.configuration;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
/**
* org.winitech.practiceelasticspringboot.configuration
* ㄴ ElasticConfiguration.java
* @author : 박준희 과장 (부설연구소)
* @since : 2022-03-11 오후 5:14
* @see : None
 **/
@EnableElasticsearchRepositories
@Configuration
public class ElasticConfiguration extends AbstractElasticsearchConfiguration {
    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private Number port;

    @Override
    public RestHighLevelClient elasticsearchClient() {

        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo("192.168.200.115:9201")
                .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
