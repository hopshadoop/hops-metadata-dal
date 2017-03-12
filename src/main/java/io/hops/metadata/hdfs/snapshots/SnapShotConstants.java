package io.hops.metadata.hdfs.snapshots;
/**
 *
 * @author pushparaj
 */
public class SnapShotConstants {
    //This Inode is Original INode[Existing before taking snapshot] && Newly created row for modified Original INode

    public static final int Original = 1;
    //Newly Created Inode & Newly created Inode which is modified
    public static final int New = 3;
    //Modified Original Inode
    public static final int Modified = 2;
    //Deleted Inode
    public static final int isDeleted = 1;
    //INode which is not deleted
    public static final int isNotDeleted = 0;
    //Snapshot was taken
    public static final int snapShotTaken = 1;
    //Snapshot was not taken
    public static final int snapShotNotTaken = 0;


}
