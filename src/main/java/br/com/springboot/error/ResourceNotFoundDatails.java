/**
 * @author cleilton
 * File: ResourceNotFoundDatails.java - Date: Sep 19, 2019
 */
package br.com.springboot.error;

import javax.annotation.Generated;

public class ResourceNotFoundDatails {

	private String title;
	private int status;
	private String datails;
	private long timestamp;
	private String developerMessage;

	@Generated("SparkTools")
	private ResourceNotFoundDatails(Builder resourceNotFoundDatailsBuilder) {
		this.title = resourceNotFoundDatailsBuilder.title;
		this.status = resourceNotFoundDatailsBuilder.status;
		this.datails = resourceNotFoundDatailsBuilder.datails;
		this.timestamp = resourceNotFoundDatailsBuilder.timestamp;
		this.developerMessage = resourceNotFoundDatailsBuilder.developerMessage;
	}

	private ResourceNotFoundDatails() {
	}

	public String getTitle() {
		return title;
	}

	public int getStatus() {
		return status;
	}

	public String getDatails() {
		return datails;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	@Generated("SparkTools")
	public static Builder Builder() {
		return new Builder();
	}

	@Generated("SparkTools")
	public static final class Builder {
		private String title;
		private int status;
		private String datails;
		private long timestamp;
		private String developerMessage;

		private Builder() {
		}

		public ResourceNotFoundDatails newBuilder() {
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

		public Builder Datails(String datails) {
			this.datails = datails;
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
