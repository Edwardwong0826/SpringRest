package com.wongweiye.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "PAR")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SystemParameter {

    public SystemParameter(String string, String string2, boolean b, String string3, int i, String string4) {
        this.parGroup = string;
        this.parName = string2;
        this.parEnabled = b;
        this.parVersion = string3;
        this.parAccess = i;
        this.parValue = string4;

    }

    @Id
    @Column(name="ROWID")
    //@IgnoreStringSize(reason = "only record selection")
    //@IgnoreREGEXPattern(reason = "only record selection")
    private String rowId;

    @Column(name = "PAR_GROUP")

    private String parGroup;

    @Column(name = "PAR_NAME")

    private String parName;

    @JsonIgnore
    @Column(name = "PAR_ENABLED")
    private Boolean parEnabled;

    @JsonIgnore
    @Column(name = "PAR_VERSION")

    private String parVersion;

    @JsonIgnore
    @Column(name = "PAR_ACCESS")

    private int parAccess;

    @Column(name = "PAR_VALUE")

    private String parValue;


}
