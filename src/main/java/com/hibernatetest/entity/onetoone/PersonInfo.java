package com.hibernatetest.entity.onetoone;

import com.hibernatetest.FamilyState;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Cache;

import javax.persistence.*;

@Entity
@Table(name = "PersonInfo")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "personCacheRegion")
public class PersonInfo {
    @Id
    @Column(name = "person_id")
    @GeneratedValue(generator="gen")
    @GenericGenerator(name="gen", strategy="foreign",parameters=@Parameter(name="property", value="person"))
    private long personId;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "family_state")
    @Enumerated(EnumType.STRING)
    private FamilyState familyState;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Person person;

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "personId=" + personId +
                ", passportNumber='" + passportNumber + '\'' +
                '}';
    }

    public FamilyState getFamilyState() {
        return familyState;
    }

    public void setFamilyState(FamilyState familyState) {
        this.familyState = familyState;
    }
}
