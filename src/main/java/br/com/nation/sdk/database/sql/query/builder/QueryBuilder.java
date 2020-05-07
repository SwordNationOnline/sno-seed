package br.com.nation.sdk.database.sql.query.builder;

import br.com.nation.sdk.database.sql.query.SQLQuery;
import com.google.common.base.Joiner;
import javafx.util.Builder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class QueryBuilder implements Builder<SQLQuery>, IQueryBuilder {

    private final String table;
    @Getter private final StringBuilder query = new StringBuilder();
    @Getter private String[] columns;

    public static QueryBuilder createQuery(String table) {
        return new QueryBuilder(table);
    }

    @Override
    public QueryBuilder createTable(String[] columns, String[] columnTypes) {
        if (columns.length != columnTypes.length)
            throw new IllegalArgumentException("A quantidade de colunas deve ser a mesma que a dos tipos");
        this.columns = columns;
        query.append("CREATE TABLE IF NOT EXISTS ").append(table).append(" ").append("(ID INT NOT NULL AUTO_INCREMENT,");
        for (int i = 0; i < columns.length; i++) {
            query.append(columns[i]).append(" ").append(columnTypes[i]).append(",");
        }
        query.append(" PRIMARY KEY (ID))");
        return this;
    }

    @Override
    public QueryBuilder select(String... columns) {
        this.columns = columns;
        query.append("SELECT ").append(Joiner.on(",").join(columns)).append(" FROM ").append(table);
        return this;
    }

    @Override
    public QueryBuilder insert(String... columns) {
        this.columns = columns;
        query.append("INSERT INTO ").append(table).append(" ").append("(").append(Joiner.on(",").join(columns)).append(")");
        query.append(" ").append("VALUES (").append(
                Joiner.on(",").join(StringUtils.repeat('?', columns.length).split(""))
        ).append(")");
        return this;
    }

    @Override
    public QueryBuilder replace(String... columns) {
        this.columns = columns;
        query.append("REPLACE INTO ").append(table).append(" ").append("(").append(Joiner.on(",").join(columns)).append(")");
        query.append(" ").append("VALUES (").append(
                Joiner.on(",").join(StringUtils.repeat('?', columns.length).split(""))
        ).append(")");
        return this;
    }

    @Override
    public QueryBuilder update(String... columns) {
        this.columns = columns;
        query.append("UPDATE ").append(table).append(" SET ");
        for (int i = 0; i < columns.length; i++) {
            if (i > 0) query.append(",");
            query.append(columns[i]).append(" = ?");
        }
        return this;
    }

    @Override
    public QueryBuilder delete() {
        query.append("DELETE FROM ").append(table);
        return this;
    }

    @Override
    public QueryBuilder where(String... colums) {
        query.append(" ").append("WHERE ");
        for (int i = 0; i < colums.length; i++) {
            if (i > 0) query.append(" AND ");
            query.append(colums[i]).append(" = ?");
        }
        return this;
    }

    @Override
    public QueryBuilder decreasingOrderBy(String... columns) {
        query.append(" ").append("ORDER BY ").append(Joiner.on(",").join(columns)).append(" DESC");
        return this;
    }

    @Override
    public QueryBuilder limit(int limit) {
        query.append(" ").append("LIMIT ").append(limit);
        return this;
    }

    @Override
    public SQLQuery build() {
        return SQLQuery.of(this);
    }

}
