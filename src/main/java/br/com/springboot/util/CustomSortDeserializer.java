package br.com.springboot.util;

import java.io.IOException;

import org.springframework.data.domain.Sort;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomSortDeserializer extends JsonDeserializer<Sort> {

	@Override
	public Sort deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();

		JsonNode node = objectMapper.readTree(jsonParser);

		if (node.isArray()) {

			Sort.Order[] orders = new Sort.Order[node.size()];

			int i = 0;

			for (JsonNode jsonNode : node) {

				orders[i] = new Sort.Order(Sort.Direction.valueOf(jsonNode.get("direction").asText()),
						jsonNode.get("property").asText());
				i++;

			}

			return new Sort(orders);
		}

		return Sort.unsorted();
	}
}
