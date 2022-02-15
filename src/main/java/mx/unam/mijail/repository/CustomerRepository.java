package mx.unam.mijail.repository;

import mx.unam.mijail.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
}
