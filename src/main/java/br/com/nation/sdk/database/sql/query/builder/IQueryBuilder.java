package br.com.nation.sdk.database.sql.query.builder;

import br.com.nation.sdk.util.EnumUtils;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
@SuppressWarnings("rawtypes")
interface IQueryBuilder {

    QueryBuilder createTable(String[] columns, String[] columnTypes);
    default QueryBuilder createTable(Enum[] enumColumns, String[] columnTypes) {
        return createTable(EnumUtils.transform(enumColumns), columnTypes);
    }

    QueryBuilder select(String... columns);
    default QueryBuilder select(Enum... enumColumns) {
        return select(EnumUtils.transform(enumColumns));
    }

    QueryBuilder insert(String... columns);
    default QueryBuilder insert(Enum... enumColumns) {
        return insert(EnumUtils.transform(enumColumns));
    }

    QueryBuilder replace(String... columns);
    default QueryBuilder replace(Enum... enumColumns) {
        return replace(EnumUtils.transform(enumColumns));
    }

    QueryBuilder update(String... columns);
    default QueryBuilder update(Enum... enumColumns) {
        return update(EnumUtils.transform(enumColumns));
    }

    QueryBuilder delete();

    QueryBuilder where(String... colums);
    default QueryBuilder where(Enum... enumColumns) {
        return where(EnumUtils.transform(enumColumns));
    }

    QueryBuilder decreasingOrderBy(String... columns);
    default QueryBuilder decreasingOrderBy(Enum... enumsColumns) {
        return decreasingOrderBy(EnumUtils.transform(enumsColumns));
    }

    QueryBuilder limit(int limit);

}
