package br.com.holder.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.holder.domain.model.Holder;
import br.com.holder.domain.utils.HolderName;

@Repository
public interface HolderRepository extends JpaRepository<Holder, UUID> {
  Optional<Holder> findByName(HolderName holderName);
}
