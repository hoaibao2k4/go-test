package com.example.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("NATURAL")
@Getter
@Setter

public class NaturalScore extends CommonScore {

  @Column(name = "vat_li")
  private Double vatLi;

  @Column(name = "hoa_hoc")
  private Double hoaHoc;

  @Column(name = "sinh_hoc")
  private Double sinhHoc;

}
