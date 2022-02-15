package mx.unam.mijail.controller;

import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import mx.unam.mijail.entity.Customer;
import mx.unam.mijail.model.CreateCustomer;
import mx.unam.mijail.service.PracticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/practica")
public class PracticaController {
  private static final Gson gson = new Gson();
  private final PracticaService practicaService;

  @Autowired
  public PracticaController(PracticaService practicaService) {
    this.practicaService = practicaService;
  }

  @ApiOperation(value = "Lista todos los clientes", notes = "Vacia si no hay clientes")
  @GetMapping("/clientes")
  public ResponseEntity<Object> getClientes() {
    List<Customer> lista = practicaService.getCustomers();
    return ResponseEntity.status(HttpStatus.OK).body(gson.toJson(lista));
  }

  @ApiOperation(
      value = "Borra un cliente de la base de datos",
      notes = "Debe existir el cliente con ese ID")
  @GetMapping("/borrar/{id}")
  public void borrarCliente(
      @ApiParam(value = "Id del cliente a Borrar de la Base de datos", required = true)
          @PathVariable
          String id) {
    practicaService.deleteCustomer(Integer.parseInt(id));
  }

  @ApiOperation(
      value = "Agrega un cliente a la base de datos",
      notes = "El id de la region debe existir en la tabla de Region")
  @PostMapping("/agregar")
  public void agregarCliente(
      @ApiParam(value = "Cliente a agragar con todos sus campos", required = true) @RequestBody
          CreateCustomer customer) {
    practicaService.createCustomer(customer);
  }
}
