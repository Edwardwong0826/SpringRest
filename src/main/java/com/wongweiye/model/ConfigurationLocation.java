package com.wongweiye.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;

@Entity
@Table(name = "LOC")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ConfigurationLocation {

    @Id
    @Column(name="LOC_ID")
    private long locationID;

    @Column(name="LOC_ART")
    private String locationArt;

    @Column(name="LOC_TITLE")
    private String locationTitle;

    @Column(name="LOC_DESCR")
    private String locationDescr;

    @Column(name="LOC_DECK")
    private String locationDeck;

    @Column(name="LOC_FILENAME")
    private String locationFilename;

    @Column(name="LOC_STATUS")
    private boolean locationStatus;

    @Column(name="LOC_OVERLAP")
    private boolean locationOverlap;

    @Column(name="LOC_COMMENT")
    private String locationComment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumnOrFormula(column=@JoinColumn(name="LOC_DECK", updatable = false, insertable = false, referencedColumnName = "TYP_ART"))
    private ConfigurationLocationDeckView locationDeckView;

}
