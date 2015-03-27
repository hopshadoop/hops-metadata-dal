/*
 * Copyright (C) 2015 hops.io.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.hops.metadata.yarn.entity;

/**
 * Pojo representing Token class.
 */
public class Token {

  private int id;
  private byte[] identifier;
  private String kind;
  private byte[] password;
  private String service;

  public Token(int id, byte[] identifier, String kind, byte[] password,
      String service) {
    this.id = id;
    this.identifier = identifier;
    this.kind = kind;
    this.password = password;
    this.service = service;
  }

  public int getId() {
    return id;
  }

  public byte[] getIdentifier() {
    return identifier;
  }

  public String getKind() {
    return kind;
  }

  public byte[] getPassword() {
    return password;
  }

  public String getService() {
    return service;
  }
}
