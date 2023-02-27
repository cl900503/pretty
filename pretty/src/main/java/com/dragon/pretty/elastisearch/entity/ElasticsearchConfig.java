package com.dragon.pretty.elastisearch.entity;

import lombok.Data;

/**
 * Elasticsearch 配置
 * 
 * @author chenlong
 * @date 2023-02-24 18:01:07
 */
@Data
public class ElasticsearchConfig {

	/**
	 * 地址
	 */
	private String ip;

	/**
	 * 端口
	 */
	private int port;

}
