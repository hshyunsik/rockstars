package com.rockstars.finder.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;

@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
@Data
@Entity
@JsonIgnoreProperties
public class Artist {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(unique=true)
  @JsonProperty("Id")
  private Long id;

  @Column(nullable=false)
  @JsonProperty("Name")
  String name;

  public Artist(Long id, String name){
    this.id = id;
    this.name = name;
  }

  public Artist(String Name) {
    this.name = Name;
  }

  public Artist(){}
}
