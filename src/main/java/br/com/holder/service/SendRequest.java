package br.com.holder.service;

import java.util.Arrays;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SendRequest {

  private static final Logger LOG = Logger.getLogger(SendRequest.class);

  private RestTemplate restTemplate;

  @Value("${uri.bank.auth}")
  private String uriBankAuth;

  public SendRequest(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public ResponseEntity<Object> send(Object request) {
    LOG.info("Sending message to Module Bank using this Request [ " + request + " ]");
    return restTemplate.exchange(uriBankAuth, HttpMethod.POST,
        getHttpEntity(request, getHttpHeaders()), Object.class);
  }

  private HttpEntity<Object> getHttpEntity(Object request, HttpHeaders headers) {
    return new HttpEntity<Object>(request, headers);
  }

  private HttpHeaders getHttpHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    return headers;
  }

}
