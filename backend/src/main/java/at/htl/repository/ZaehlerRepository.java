package at.htl.repository;

import at.htl.model.Zaehler;
import at.htl.model.ZaehlerId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class ZaehlerRepository {

    @Inject
    EntityManager em;

    public List<Zaehler> getAll() {
        return em.createQuery("select z from Zaehler z order by z.datum desc", Zaehler.class).getResultList();
    }

    public List<Zaehler> getAll(long zaehlernr) {
        return em.createQuery("select z from Zaehler z where z.zaehlernr=?1 order by z.datum desc", Zaehler.class)
                .setParameter(1, zaehlernr)
                .getResultList();
    }


    public void persist(Zaehler zaehler) {
        em.persist(zaehler);
    }

    public Zaehler get(long zaehlernr, LocalDate datum) {
        return em.find(Zaehler.class, new ZaehlerId(zaehlernr, datum));
    }

    public double getLast(long zaehlernr) {
        try {
            return em.createQuery("select max(z.zaehlerstand) from Zaehler z where z.zaehlernr=?1", Double.class)
                    .setParameter(1, zaehlernr)
                    .getSingleResult();
        } catch (Exception e) {
            return 0.0;
        }
    }
}
