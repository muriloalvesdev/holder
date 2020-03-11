package br.com.holder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import br.com.holder.domain.model.Holder;
import br.com.holder.domain.repository.HolderRepository;
import br.com.holder.domain.utils.Bank;
import br.com.holder.domain.utils.HolderName;

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
