package com.wongweiye.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
public class ShipInformationDTO {

    private long shipID;

    private String shipReferenceID;

    private int shipRecordID;

    private boolean shipEnabled;

    private String shipCode;

    private String shipName;

    private int shipType;

    public ShipInformationDTO(long shipID, String shipReferenceID, int shipRecordID, boolean shipEnabled, String shipCode, String shipName, int shipType) {
        this.shipID = shipID;
        this.shipReferenceID = shipReferenceID;
        this.shipRecordID = shipRecordID;
        this.shipEnabled = shipEnabled;
        this.shipCode = shipCode;
        this.shipName = shipName;
        this.shipType = shipType;
    }


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
