package com.jifenke.lepluslive.sales.domain.entities;

import com.jifenke.lepluslive.merchant.domain.entities.Merchant;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.List;

/**
 * Created by lss on 2016/8/10.
 */
@Entity
@Table(name = "SALES_STAFF") //对应数据库中de表
public class SalesStaff {

  @Id //表示下方的构件字段是当前实体的主键
  @GeneratedValue(strategy = GenerationType.AUTO)  //配置主键生成策略为自动增长。
  private Long id;

  private String name;
  private String age;

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  @OneToMany(mappedBy = "salesStaff", fetch = FetchType.LAZY)
  private List<Merchant> merchant;

  public List<Merchant> getMerchant() {
    return merchant;
  }

  public void setMerchant(List<Merchant> merchant) {
    this.merchant = merchant;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {

    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SalesStaff(String salesStaffId) {
    this.id = Long.parseLong(salesStaffId);
  }

  public SalesStaff() {
  }

  public void addMerchant(Merchant mer) {
    if (mer != null) {
      merchant.add(mer);
    }
  }
}
