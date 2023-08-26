package at.htl.model;

import java.io.Serializable;
import java.time.LocalDate;

public class ZaehlerId implements Serializable {
    private Long zaehlernr;
    private LocalDate datum;

    public ZaehlerId() {
    }

    public ZaehlerId(Long zaehlernr, LocalDate datum) {
        this.zaehlernr = zaehlernr;
        this.datum = datum;
    }
}
