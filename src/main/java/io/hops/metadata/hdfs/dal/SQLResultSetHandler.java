package io.hops.metadata.hdfs.dal;

import io.hops.exception.StorageException;
import io.hops.metadata.common.EntityDataAccess;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SQLResultSetHandler<R> {
  R handle(ResultSet result) throws SQLException, StorageException;
}

