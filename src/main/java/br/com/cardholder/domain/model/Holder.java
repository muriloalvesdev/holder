package br.com.cardholder.domain.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import br.com.cardholder.domain.utils.Bank;
import br.com.cardholder.domain.utils.HolderName;

@Entity
@Table(name = "holder", uniqueConstraints = {@UniqueConstraint(columnNames = {"name"})})
public class Holder extends BaseEntity {

  private static final long serialVersionUID = -1464187253255284808L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID uuid;

  @Enumerated(EnumType.STRING)
  @Column(name = "name")
  private HolderName name;

  @Enumerated(EnumType.STRING)
  @Column(name = "bank")
  private Bank bank;

  @SuppressWarnings("unused")
  private Holder() {}

  public Holder(HolderName name, Bank bank) {
    this.name = name;
    this.bank = bank;
  }

  public Bank getBank() {
    return bank;
  }

  public void setBank(Bank bank) {
    this.bank = bank;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public HolderName getName() {
    return name;
  }

  public void setName(HolderName name) {
    this.name = name;
  }

}
