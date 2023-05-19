//package com.eve.config;
//
//import lombok.Data;
//import org.apache.http.HttpHost;
//import org.elasticsearch.client.RestClient;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Author han aijun
// * @Date 2021/5/8 17:12
// * @Version 1.0
// */
//@Configuration
//@ConfigurationProperties(prefix = "elasticsearch")
//@Data
//public class EsConfig {
//
//    private String host;
//    private Integer port;
//
//    @Bean(destroyMethod = "close")
//    public RestHighLevelClient client() {
//        return new RestHighLevelClient(RestClient.builder(
//                new HttpHost(host, port, "http")
//        ));
//    }
//}
