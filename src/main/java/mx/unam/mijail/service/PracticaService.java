package mx.unam.mijail.service;

import mx.unam.mijail.entity.Customer;
import mx.unam.mijail.model.CreateCustomer;

import java.util.List;

public interface PracticaService {
  List<Customer> getCustomers();
  void createCustomer(CreateCustomer createCustomer);
  void deleteCustomer(int customerId);
}
