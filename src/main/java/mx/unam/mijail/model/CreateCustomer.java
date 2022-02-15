package mx.unam.mijail.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class CreateCustomer {
  @ApiModelProperty("Nombre del Cliente")
  @JsonProperty("nombre")
  String nombre;

  @ApiModelProperty("Apellido del Cliente")
  @JsonProperty("apellido")
  String apellido;

  @ApiModelProperty("RFC del Cliente")
  @JsonProperty("rfc")
  String rfc;

  @ApiModelProperty("Mail del Cliente")
  @JsonProperty("mail")
  String mail;

  @ApiModelProperty("ID de Region del cliente, debe ser una region existente; HAY 4 regiones id:1(Norte), id:2(Oeste), id:3(Este), id:4(Sur)")
  @JsonProperty("region")
  Integer region;
}
