package com.example.backend.entity; 
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "entrance_scores")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "entrance_group", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class CommonScore {

  @Id
  @Column(name = "sbd",length = 20)
  protected String sbd;

  protected Double toan;

  @Column(name = "ngu_van")
  protected Double nguVan;

  @Column(name = "ngoai_ngu")
  protected Double ngoaiNgu;

  @Column(name = "ma_ngoai_ngu")
  protected String maNgoaiNgu;

}
