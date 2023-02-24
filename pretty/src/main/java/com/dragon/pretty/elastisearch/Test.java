package com.dragon.pretty.elastisearch;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;

public class Test {

	/**
	 * @param args
	 * @throws ElasticsearchException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws ElasticsearchException, IOException, InterruptedException {

		// Create the low-level client
		RestClient restClient = RestClient.builder(new HttpHost("192.168.0.81", 11110)).build();

		// Create the transport with a Jackson mapper
		ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

		// And create the API client
		ElasticsearchClient client = new ElasticsearchClient(transport);

		System.out.println(client.info());

		// 根据id查询
		GetResponse<Object> response = client.get(fn -> fn.index("user_index_name").id("4611686027042922243-0"),
				Object.class);
		System.out.println(response.found());
		if (response.found()) {
			System.out.println(response.source());
		}

//		SearchResponse<Object> search = client.search(
//				s -> s.index("user_index_name").query(q -> q.term(t -> t.field("name").value(v -> v.stringValue("NU1251")))),
//				Object.class);
		
//		SearchResponse<Object> search = client.search(
//				s -> s.index("user_index_name").query(fn->fn.prefix(t->t.field("name").value("NU"))),
//				Object.class);
		
		SearchResponse<Object> search = client.search(
				s -> s.index("user_index_name").query(fn->fn.match(t->t.field("name").query("wzj"))),
				Object.class);
		
//		SearchResponse<Object> search = client.search(
//				s -> s.index("user_index_name").query(q -> q.term(t -> t.field("_id").value(v -> v.stringValue("4611686027042922243-0")))),
//				Object.class);

		System.out.println(search);
		
		for (Hit<Object> hit : search.hits().hits()) {
			System.out.println(hit.source());
		}
	}

}
