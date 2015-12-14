/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.hops.util;

public class HopsWorksHelper {

  public static String getUserName(String totalName){
    return totalName.split("__")[1];
  }
  
  public static String getProjectName(String totalName){
    return totalName.split("__")[0];
  }
}
