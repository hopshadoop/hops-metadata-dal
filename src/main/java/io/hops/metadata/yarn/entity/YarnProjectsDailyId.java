/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.hops.metadata.yarn.entity;

/**
 *
 * @author rizvi
 */
public class YarnProjectsDailyId {
    private final String projectName;
    private final String projectUser;
    private final long day;
    
    public YarnProjectsDailyId(String projectName, 
                                String projectUser,
                                long day) {
        this.projectName = projectName;
        this.projectUser = projectUser;
        this.day = day;
    }
    
    @Override
    public String toString() {
        return "YarnProjectsQuota{" + "projectName=" + projectName + ", user=" + projectUser  + ", day=" + day  + " }";
    }
    
    @Override
    public boolean equals(Object o) {
        if (o != null && getClass() == o.getClass()) {
          YarnProjectsDailyId other = (YarnProjectsDailyId) o;
          if (day == other.day){
              if (projectName.equals(other.projectName) 
                  && projectUser.equals(other.projectUser)) {
                  return true;
              }
          }
        }
        return false;  
    }
    
    @Override
    public int hashCode() {
      return projectName.hashCode() + projectUser.hashCode() + (int)day;
    }    

    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @return the projectUser
     */
    public String getProjectUser() {
        return projectUser;
    }

    /**
     * @return the day
     */
    public long getDay() {
        return day;
    }

//    /**
//     * @param projectName the projectName to set
//     */
//    public void setProjectName(String projectName) {
//        this.projectName = projectName;
//    }
//
//    /**
//     * @param projectUser the projectUser to set
//     */
//    public void setProjectUser(String projectUser) {
//        this.projectUser = projectUser;
//    }
//
//    /**
//     * @param day the day to set
//     */
//    public void setDay(long day) {
//        this.day = day;
//    }
}
