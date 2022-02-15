package mx.unam.mijail.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "region")
@Data
public class Region implements Serializable {
  @Id
  @Column(name = "id")
  private int region_id;

  @Column(name = "region")
  private String region;
}
