package br.com.cardholder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import br.com.cardholder.domain.model.Holder;
import br.com.cardholder.domain.repository.HolderRepository;
import br.com.cardholder.domain.utils.Bank;
import br.com.cardholder.domain.utils.HolderName;

@Configuration
public class Config {

  @Autowired
  private HolderRepository repository;

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public void persistHolder() {
    if (!repository.findByName(HolderName.MASTERCARD).isPresent()) {
      repository.saveAndFlush(new Holder(HolderName.MASTERCARD, Bank.NUBANK));
    }
  }
}
