package br.com.springboot.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.springboot.util.CustomSortDeserializer;

public class PageableResponse<T> extends PageImpl<T> {

//	private static final long serialVersionUID = 1L;

	private boolean last;
	private boolean first;
	private int totalPages;

	@JsonCreator
	public PageableResponse(@JsonProperty("content") List<T> content, @JsonProperty("number") int page, @JsonProperty("size") int size,
			@JsonProperty("totalElements") long totalElements, @JsonProperty("pageable") JsonNode pageable,
			@JsonProperty("sort") @JsonDeserialize(using = CustomSortDeserializer.class) Sort sort) {

		super(content, PageRequest.of(page, size, sort), totalElements);

	}

//	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
//	public PageableResponse(@JsonProperty("content") List<T> content, @JsonProperty("number") int number,
//			@JsonProperty("size") int size, @JsonProperty("totalElements") Long totalElements,
//			@JsonProperty("pageable") JsonNode pageable, @JsonProperty("last") boolean last,
//			@JsonProperty("totalPages") int totalPages,
//			@JsonProperty("sort") @JsonDeserialize(using = CustomSortDeserializer.class) Sort sort,
//			@JsonProperty("first") boolean first, @JsonProperty("numberOfElements") int numberOfElements) {
//
//		super(content, PageRequest.of(number, size, sort), totalElements);
//	}

	public PageableResponse() {
		super(new ArrayList<>());
	}

	public boolean isLast() {
		return last;
	}

	public void setLast(boolean last) {
		this.last = last;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}
