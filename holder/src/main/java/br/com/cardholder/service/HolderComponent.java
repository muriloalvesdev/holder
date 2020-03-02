package br.com.cardholder.service;

import java.util.Arrays;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HolderComponent {

    private static final Logger LOG = Logger.getLogger(HolderComponent.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${uri.bank.auth}")
    private String uriBankAuth;

    public ResponseEntity<Object> sendRequest(Object request) {
        LOG.info("Sending message to Module Bank using this Request [ "
                + request + " ]");
        HttpHeaders headers = createHttpHeaders();
        HttpEntity<Object> entity = createHttpEntity(request, headers);
        return restTemplate.exchange(uriBankAuth, HttpMethod.POST, entity,
                Object.class);
    }

    private HttpEntity<Object> createHttpEntity(Object request,
            HttpHeaders headers) {
        HttpEntity<Object> entity = new HttpEntity<Object>(request, headers);
        return entity;
    }

    private HttpHeaders createHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

}
