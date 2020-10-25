package com.wongweiye.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name = "TYP_DEK")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConfigurationLocationDeckView {

    @Id
    @Column(name="TYP_ART")
    private String code;

    @Column(name="TYP__COMMENT")
    private String comment;

}
