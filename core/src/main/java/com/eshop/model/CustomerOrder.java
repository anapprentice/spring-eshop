package com.eshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class CustomerOrder {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private int finalPrice;
  private String orderedGoods;

  private String customerName;
  private String customerEmail;
  private String customerAddress;
  private String customerBankCardNum;

  private Date timestamp;
}
