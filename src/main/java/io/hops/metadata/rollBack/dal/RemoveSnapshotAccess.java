package io.hops.metadata.rollBack.dal;

import java.io.IOException;

/**
 * Copyright (c) 01/08/16 DigitalRoute
 * All rights reserved.
 * Usage of this program and the accompanying materials is subject to license terms
 *
 * @author pushparaj.motamari
 */
public interface RemoveSnapshotAccess {

    boolean processInodesPhase1() throws IOException;//Remove all backup rows

    boolean processInodesPhase2() throws IOException;//Change all modified and new into Original

    boolean processInodeAttributesPhase1() throws IOException;//Remove all back-up rows

    boolean processInodeAttributesPhase2() throws IOException;//Change all modified and new to  Original

    boolean processBlocksPhase1() throws IOException;//Remove all backup rows

    boolean processBlocksPhase2() throws IOException;//Change all modified and new to  Original

    boolean  waitForSubTreeOperations() throws IOException;

    boolean waitForQuotaUpdates() throws IOException;
}
