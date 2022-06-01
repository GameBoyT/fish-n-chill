package com.tim23.fishnchill.user.model;

import com.tim23.fishnchill.general.model.VerificationToken;
import com.tim23.fishnchill.reservation.model.CottageReservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Client extends User {


    private Integer penaltyCount;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CottageReservation> cottageReservations;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private VerificationToken verificationToken;

    public Client(User u){
        super(u);
        this.penaltyCount=0;
    }

}
