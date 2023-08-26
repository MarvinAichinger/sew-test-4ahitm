package at.htl;

import at.htl.model.Zaehler;
import at.htl.repository.ZaehlerRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Path("/api/zaehler")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ZaehlerResource {

    @Inject
    ZaehlerRepository repo;

    @GET
    @Path("/list_all")
    public List<Zaehler> listAll() {
        return repo.getAll();
    }

    @GET
    @Path("/list/{zaehlernr}")
    public List<Zaehler> listAll(@PathParam("zaehlernr") long zaehlernr) {
        return repo.getAll(zaehlernr);
    }

    @GET
    @Path("/{zaehlernr}/{datum}")
    public Zaehler getZaehler(@PathParam("zaehlernr") long zaehlernr, @PathParam("datum") String datum) {
        return repo.get(zaehlernr, LocalDate.parse(datum));
    }

    @GET
    @Path("last/{zaehlernr}")
    public double getLastValue(@PathParam("zaehlernr") long zaehlernr) {
        return repo.getLast(zaehlernr);
    }

    @POST
    @Transactional
    public Response save(Zaehler zaehler) {
        repo.persist(zaehler);
        return Response
                .created(URI.create("/api/zaehler/" + zaehler.getZaehlernr() + "/" + zaehler.getDatum().format(DateTimeFormatter.ISO_DATE)))
                .build();
    }
}