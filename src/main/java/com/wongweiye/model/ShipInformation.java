package com.wongweiye.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "XCET")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShipInformation {

    @Id
    @Column(name="XCET_ID")
    private long shipID;

    @Column(name="XCET_FC_ID")

    private String shipReferenceID;

    @Column(name = "XCET_RECORD_ID")
    private int shipRecordID;

    @Column(name = "XCET_ENABLED")
    private boolean shipEnabled;

    @Column(name = "XCET_CODE")

    private String shipCode;

    @Column(name = "XCET_NAME")

    private String shipName;

    @Column(name = "XCET_TYPE")
    private int shipType;

    public long getShipID() {
        return shipID;
    }

    public void setShipID(long shipID) {
        this.shipID = shipID;
    }

    public String getShipReferenceID() {
        return shipReferenceID;
    }

    public void setShipReferenceID(String shipReferenceID) {
        this.shipReferenceID = shipReferenceID;
    }

    public int getShipRecordID() {
        return shipRecordID;
    }

    public void setShipRecordID(int shipRecordID) {
        this.shipRecordID = shipRecordID;
    }

    public boolean isShipEnabled() {
        return shipEnabled;
    }

    public void setShipEnabled(boolean shipEnabled) {
        this.shipEnabled = shipEnabled;
    }

    public String getShipCode() {
        return shipCode;
    }

    public void setShipCode(String shipCode) {
        this.shipCode = shipCode;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public int getShipType() {
        return shipType;
    }

    public void setShipType(int shipType) {
        this.shipType = shipType;
    }
}
