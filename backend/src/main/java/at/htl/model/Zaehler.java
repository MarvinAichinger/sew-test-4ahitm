package at.htl.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;


@Entity
@IdClass(ZaehlerId.class)
public class Zaehler {
    @Id
    private Long zaehlernr;
    @Id
    private LocalDate datum;

    private double zaehlerstand;


    public Long getZaehlernr() {
        return zaehlernr;
    }

    public void setZaehlernr(Long zaehlernr) {
        this.zaehlernr = zaehlernr;
    }

    public double getZaehlerstand() {
        return zaehlerstand;
    }

    public void setZaehlerstand(double zaehlerstand) {
        this.zaehlerstand = zaehlerstand;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
