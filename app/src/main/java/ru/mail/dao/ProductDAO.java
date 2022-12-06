package ru.mail.dao;

import generated.tables.records.ProductRecord;
import org.jetbrains.annotations.NotNull;
import org.jooq.Record;
import ru.mail.Product;
import ru.mail.common.DSLContextHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static generated.Tables.PRODUCT;

public class ProductDAO {
    public List<Product> getProductsByCompanyId(int companyId) {
        final var list = new ArrayList<Product>();

        try {
            var context = DSLContextHelper.getContext();
            var result = context
                    .select()
                    .from(PRODUCT)
                    .where(PRODUCT.COMPANY_ID.eq(companyId))
                    .fetch();

            list.addAll(result.map(record -> {
                final var boxed = (ProductRecord) record;
                return new Product(boxed.getProductId(),
                        boxed.getName(),
                        boxed.getCompanyId(),
                        boxed.getCount());
            }));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public Product getByName(@NotNull String name) {
        try {
            var context = DSLContextHelper.getContext();
            var result = context
                    .select()
                    .from(PRODUCT)
                    .where(PRODUCT.NAME.eq(name))
                    .fetch();

            for (Record record : result) {
                int id = record.getValue(PRODUCT.PRODUCT_ID);
                int dbCompanyId = record.getValue(PRODUCT.COMPANY_ID);
                int count = record.getValue(PRODUCT.COUNT);
                return new Product(id, name, dbCompanyId, count);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        throw new IllegalStateException("Record with that name " + name + " not found");
    }

    public void save(@NotNull String productName,
                     int companyId,
                     int count) {
        try {
            var context = DSLContextHelper.getContext();
            context
                    .insertInto(PRODUCT, PRODUCT.NAME, PRODUCT.COMPANY_ID, PRODUCT.COUNT)
                    .values(productName, companyId, count)
                    .execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try {
            var context = DSLContextHelper.getContext();

            context
                    .delete(PRODUCT)
                    .where(PRODUCT.PRODUCT_ID.eq(id))
                    .execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
