/**
 * @author cleilton
 * File: ResourceNotFoundDatails.java - Date: Sep 19, 2019
 */
package br.com.springboot.error;

import javax.annotation.Generated;

public class ResourceNotFoundDatails extends ErrorDetails {

	@Generated("SparkTools")
	private ResourceNotFoundDatails(Builder resourceNotFoundDatailsBuilder) {
		this.setTitle(resourceNotFoundDatailsBuilder.title);
		this.setStatus(resourceNotFoundDatailsBuilder.status);
		this.setDetails(resourceNotFoundDatailsBuilder.details);
		this.setTimestamp(resourceNotFoundDatailsBuilder.timestamp);
		this.setDeveloperMessage(resourceNotFoundDatailsBuilder.developerMessage);
	}

	private ResourceNotFoundDatails() {
	}

	@Generated("SparkTools")

	public static Builder newBuilder() {
		return new Builder();
	}

	@Generated("SparkTools")
	public static final class Builder {
		private String title;
		private int status;
		private String details;
		private long timestamp;
		private String developerMessage;

		private Builder() {
		}

		public ResourceNotFoundDatails build() {
			return new ResourceNotFoundDatails(this);
		}

		public Builder Title(String title) {
			this.title = title;
			return this;
		}

		public Builder Status(int status) {
			this.status = status;
			return this;
		}

		public Builder Details(String datails) {
			this.details = datails;
			return this;
		}

		public Builder Timestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder DeveloperMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}
	}
}
