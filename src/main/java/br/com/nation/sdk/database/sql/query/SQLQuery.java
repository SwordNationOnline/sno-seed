package br.com.nation.sdk.database.sql.query;

import br.com.nation.sdk.database.sql.query.builder.QueryBuilder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
@Getter
@ToString
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public final class SQLQuery {

    private final String query;
    private final String[] columns;

    public static QueryBuilder createBuilder(String table) {
        return QueryBuilder.createQuery(table);
    }

    public static SQLQuery of(QueryBuilder queryBuilder) {
        return new SQLQuery(queryBuilder.getQuery().toString(), queryBuilder.getColumns());
    }

}
