package dao;

import generated.tables.records.ReceiptsRecord;
import generated.tables.records.TagsRecord;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.util.List;

import static generated.Tables.TAGS;
import static generated.Tables.RECEIPTS;

public class TagDao {
    DSLContext dsl;

    public TagDao(Configuration jooqConfig) {
        this.dsl = DSL.using(jooqConfig);
    }

    public void insert(String TagToAdd, int ReceiptId) {
            dsl.insertInto(TAGS, TAGS.TAG, TAGS.ID)
                .values(TagToAdd,ReceiptId)
                .execute();
    }

    public void delete(String TagToRemove, int ReceiptId) {
                dsl.delete(TAGS)
                .where(TAGS.ID.eq(ReceiptId)).and(TAGS.TAG.eq(TagToRemove))
                .execute();
    }

    public List<TagsRecord> findTag(String TagToAdd, int ReceiptId) {
        return dsl.selectFrom(TAGS).where(TAGS.ID.eq(ReceiptId)).and(TAGS.TAG.eq(TagToAdd)).fetch();
    }

    public List<ReceiptsRecord> findAllReceiptsTag(String TagToSearch) {
        return dsl.select()
                .from(RECEIPTS)
                .join(TAGS).on(RECEIPTS.ID.equal(TAGS.ID))
                .where(TAGS.TAG.eq(TagToSearch))
                .fetchInto(ReceiptsRecord.class);
    }
}

