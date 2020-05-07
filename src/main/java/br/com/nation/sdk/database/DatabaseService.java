package br.com.nation.sdk.database;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
public interface DatabaseService {

    boolean connect();

    boolean disconnect();

    boolean isConnected();

}
