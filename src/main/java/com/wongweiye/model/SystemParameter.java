package com.wongweiye.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

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
    @NotNull(message="parGroup field cannot null")
    @Size(max = 20, message = "must be between 0 and 20 characters")
    @Pattern(regexp = "^[ A-Za-z0-9_@./#&+-]*$")
    private String parGroup;

    @Column(name = "PAR_NAME")
    @NotNull(message="parName field cannot null")
    @Size(max = 50, message = "must be between 0 and 50 characters")
    @Pattern(regexp = "^[ A-Za-z0-9_@./#&+-]*$")
    private String parName;

    @JsonIgnore
    @Column(name = "PAR_ENABLED")
    private Boolean parEnabled;

    @JsonIgnore
    @Column(name = "PAR_VERSION")
    @Size(min = 1, max = 8, message = "must be between 1 and 80 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 [.]]*$")
    private String parVersion;

    @JsonIgnore
    @Column(name = "PAR_ACCESS")
    @NotNull
    @Positive(message="parAccess must be a positive value.")
    private int parAccess;

    @Column(name = "PAR_VALUE")
    @Size(min = 1, max = 2000, message = "must be between 1 and 2000 characters")
    @Pattern(regexp = "^[ A-Za-z0-9_@./#&+-]*$")
    private String parValue;


}
