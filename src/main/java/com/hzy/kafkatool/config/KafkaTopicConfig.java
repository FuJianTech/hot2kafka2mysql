package com.hzy.kafkatool.config;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: arnold_nie
 * @date: 2020/8/19 11:25
 * FileName: KafkaTopicConfig
 * Description: kafka 操作 topic 配置
 * AdminClient常用方法还有
 *
 * 创建Topic：createTopics(Collection newTopics)
 * 删除Topic：deleteTopics(Collection topics)
 * 罗列所有Topic：listTopics()
 * 增加分区：createPartitions(Map<String, NewPartitions> newPartitions)
 * 查询Topic：describeTopics(Collection topicNames)
 * 查询集群信息：describeCluster()
 * 查询ACL信息：describeAcls(AclBindingFilter filter)
 * 创建ACL信息：createAcls(Collection acls)
 * 删除ACL信息：deleteAcls(Collection filters)
 * 查询配置信息：describeConfigs(Collection resources)
 * 修改配置信息：alterConfigs(Map<ConfigResource, Config> configs)
 * 修改副本的日志目录：alterReplicaLogDirs(Map<TopicPartitionReplica, String> replicaAssignment)
 * 查询节点的日志目录信息：describeLogDirs(Collection brokers)
 * 查询副本的日志目录信息：describeReplicaLogDirs(Collection replicas)
 */
@Component
public class KafkaTopicConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootStrapServer;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> props = new HashMap<>();
        // 配置Kafka实例的连接地址
        props.put( AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
        KafkaAdmin admin = new KafkaAdmin(props);
        return admin;
    }

    @Bean
    public AdminClient adminClient() {
        return AdminClient.create(kafkaAdmin().getConfig());
    }


}
