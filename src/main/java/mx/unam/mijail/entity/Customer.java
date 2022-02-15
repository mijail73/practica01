package mx.unam.mijail.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "customer")
@Data
public class Customer implements Serializable {
  @Id
  @Column(name = "id")
  private int customer_id;

  @Column(name = "fname")
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "rfc")
  private String rfc;

  @Column(name = "mail")
  private String mail;

  @Column(name = "region")
  private int region;
}
