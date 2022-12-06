package ru.mail.common;

import org.jetbrains.annotations.NotNull;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.SQLException;

public final class DSLContextHelper {
    public static @NotNull DSLContext getContext() throws SQLException {
        final var connection = DbConnectionHelper.getConnection();
        return DSL.using(connection, SQLDialect.POSTGRES);
    }
}
