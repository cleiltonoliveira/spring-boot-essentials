package br.com.springboot.handler;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.DefaultResponseErrorHandler;

@ControllerAdvice
public class RestResponseExcepetionHandler extends DefaultResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		System.out.println("inside hasError");
		return super.hasError(response);
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		System.out.println("Doing something with status code" + response.getStatusCode());
		System.out.println("Doing something with exception body" + IOUtils.toString(response.getBody(), "UTF-8"));
//		super.handleError(response);
	}

}
