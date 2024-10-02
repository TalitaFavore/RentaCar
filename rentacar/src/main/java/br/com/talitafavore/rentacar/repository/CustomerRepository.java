package br.com.talitafavore.rentacar.repository;

import br.com.talitafavore.rentacar.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

}
