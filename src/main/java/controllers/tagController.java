package controllers;

import api.ReceiptResponse;
import dao.ReceiptDao;
import dao.TagDao;
import generated.tables.records.ReceiptsRecord;

import javax.ws.rs.*;
import java.util.List;
import javax.ws.rs.core.MediaType;

import static java.util.stream.Collectors.toList;


@Path("/tags")
public class tagController {
    final ReceiptDao receipts;
    final TagDao tags;

    public tagController(ReceiptDao receipts, TagDao tags) {
        this.receipts = receipts;
        this.tags = tags;
    }

    @PUT
    @Path("/{tag}")
    public void addRemoveTag(@PathParam("tag") String TagToAdd, int ReceiptId) {
        if (tags.findTag(TagToAdd, ReceiptId).isEmpty()) {

            tags.insert(TagToAdd, ReceiptId);

        }
        else {

            tags.delete(TagToAdd, ReceiptId);

        }
    }

    @GET
    @Path("/{tag}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReceiptResponse> findReceiptsTag(@PathParam("tag") String TagToSearch) {

        List<ReceiptsRecord> receiptRecords = tags.findAllReceiptsTag(TagToSearch);

        return receiptRecords.stream().map(ReceiptResponse::new).collect(toList());
    }
}
