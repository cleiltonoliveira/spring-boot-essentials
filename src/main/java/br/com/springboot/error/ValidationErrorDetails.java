/**
 * @author cleilton
 * File: ValidationErrorDetails.java - Date: Sep 21, 2019
 */
package br.com.springboot.error;

import javax.annotation.Generated;

public class ValidationErrorDetails extends ErrorDetails {
	private String field;
	private String fieldMessage;

	@Generated("SparkTools")
	private ValidationErrorDetails(Builder validationErrorDetails) {
		this.setTitle(validationErrorDetails.title);
		this.setStatus(validationErrorDetails.status);
		this.setDetails(validationErrorDetails.details);
		this.setTimestamp(validationErrorDetails.timestamp);
		this.setDeveloperMessage(validationErrorDetails.developerMessage);
		this.field = validationErrorDetails.field;
		this.fieldMessage = validationErrorDetails.fieldMessage;
	}

	private ValidationErrorDetails() {
	}

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
		private String field;
		private String fieldMessage;

		private Builder() {
		}

		public ValidationErrorDetails build() {
			return new ValidationErrorDetails(this);
		}

		public Builder Title(String title) {
			this.title = title;
			return this;
		}

		public Builder Status(int status) {
			this.status = status;
			return this;
		}

		public Builder Details(String details) {
			this.details = details;
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

		public Builder FieldMessage(String fieldMessage) {
			this.fieldMessage = fieldMessage;
			return this;
		}

		public Builder Field(String field) {
			this.field = field;
			return this;
		}
	}

	public String getField() {
		return field;
	}

	public String getFieldMessage() {
		return fieldMessage;
	}
}
