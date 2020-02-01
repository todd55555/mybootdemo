package com.todd.boot_es_module.repository;


import com.todd.boot_es_module.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * user cur操作
 */

public interface UserRepository extends ElasticsearchRepository<User,Long> {

}
