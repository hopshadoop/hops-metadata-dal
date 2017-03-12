package io.hops.metadata.rollBack.dal;

import java.io.IOException;
import io.hops.metadata.common.EntityDataAccess;

/**
 *
 * @author pushparaj
 */
public interface RollBackAccess extends EntityDataAccess {

    boolean processInodesPhase1() throws IOException;//Delete all rows with status=2 or status=3

    boolean processInodesPhase2() throws IOException;//Update all rows with id>0 and isDeleted=1 to isDeleted=0

    boolean processInodesPhase3() throws IOException;//Insert new row for each backup row with [new row's id]=-[back-up row's id] and [new row's parentid]=-[back-up row's parentid]

    boolean processInodeAttributesPhase1() throws IOException;//Delete all rows with status=2 or status=3

    boolean processInodeAttributesPhase2() throws IOException;//Insert new row for each backup row with [new row's id]=-[back-up row's id]

    boolean processBlocksPhase1() throws IOException;//Delete all rows with status=2 or status=3

    boolean processBlocksPhase2() throws IOException;//Insert new row for each backup row with [new row's id]=-[back-up row's id]
    
    boolean unSetSubTreeLockedOnRoot() throws IOException;

    boolean  waitForSubTreeOperations() throws IOException;

    boolean waitForQuotaUpdates() throws IOException;
}
