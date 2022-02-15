package mx.unam.mijail.service.implementation;

import lombok.extern.slf4j.Slf4j;
import mx.unam.mijail.model.CreateCustomer;
import mx.unam.mijail.service.PracticaService;
import mx.unam.mijail.entity.Customer;
import mx.unam.mijail.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PracticaServiceImplementation implements PracticaService {

  private CustomerRepository customerRepository;

  public PracticaServiceImplementation(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public List<Customer> getCustomers() {
    List<Customer> lista = new ArrayList<>();
    customerRepository.findAll().forEach(customer -> lista.add(customer));
    return lista;
  }

  @Override
  public void createCustomer(CreateCustomer createCustomer) {
    Customer nuevoCliente = new Customer();
    nuevoCliente.setName(createCustomer.getNombre());
    nuevoCliente.setSurname(createCustomer.getApellido());
    nuevoCliente.setRfc(createCustomer.getRfc());
    nuevoCliente.setMail(createCustomer.getMail());
    nuevoCliente.setRegion(createCustomer.getRegion());
    customerRepository.save(nuevoCliente);
  }

  @Override
  public void deleteCustomer(int customerId) {
    customerRepository.delete(customerRepository.findById(customerId).get());
  }
}
