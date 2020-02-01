package com.todd.boot_es_module.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description
 * @Author todd
 * @Date 2020/2/1 2:56 下午
 * @Version v.1.0
 **/

@Data
@Document(indexName = "user",type = "java")
public class User implements Serializable {

    @Id
    private Long id;

    private String name;

    private Integer sex;

    private String mobile;

}
