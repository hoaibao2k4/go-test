package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("SOCIAL")
@Getter
@Setter
public class SocialScore extends CommonScore {

  @Column(name = "lich_su")
  private Double lichSu;

  @Column(name = "dia_li")
  private Double diaLi;

  @Column(name = "gdcd")
  private Double gdcd;

}

