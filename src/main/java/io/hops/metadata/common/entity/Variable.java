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
package io.hops.metadata.common.entity;

import io.hops.metadata.common.FinderType;

import java.util.EnumMap;

public abstract class Variable {

  public final static EnumMap<Finder, byte[]> defaultValues =
      new EnumMap(Finder.class);

  public static void registerVariableDefaultValue(Finder variable,
      byte[] defaultValue) {
    defaultValues.put(variable, defaultValue);
  }

  public static enum Finder implements FinderType<Variable> {

    //Named Variables
    BlockID,
    INodeID,
    QuotaUpdateID,
    ReplicationIndex,
    StorageInfo,
    BlockTokenKeys,
    BTCurrKey,
    BTNextKey,
    BTSimpleKey,
    SIdCounter,
    StorageMap, // TODO do we need this?
    HdfsLeParams,
    YarnLeParams,
    MisReplicatedFilesIndex,
    ClusterInSafeMode,
    BrLbMaxBlkPerTW,
    RMStateStoreVersion,
    RMStateStoreEpoch,
    AMRMToken,
    RMDTSequenceNumber,
    QuotaTicksCounter,
    //Generic Variables
    GenericInteger,
    GenericLong,
    GenericString,
    GenericByteArray,
    GenericArray,
    Seed;

    public int getId() {
      return this.ordinal();
    }

    public byte[] getDefaultValue() {
      return defaultValues.get(this);
    }

    public static Finder getFinder(int varType) {
      if (varType >= Finder.values().length) {
        throw new IllegalArgumentException(
            "Variable Type " + varType + " doesn't exist");
      }
      return Finder.values()[varType];
    }

    @Override
    public Class getType() {
      return Variable.class;
    }

    @Override
    public Annotation getAnnotated() {
      return Annotation.PrimaryKey;
    }
  }

  private final Finder type;

  public Variable(Finder type) {
    this.type = type;
  }

  public abstract void setValue(byte[] val);

  public abstract byte[] getBytes();

  public abstract Object getValue();

  public abstract int getLength();

  public Finder getType() {
    return type;
  }

  public static Variable getVariable(byte varType) {
    Finder type = Finder.getFinder(varType);
    return getVariable(type);
  }

  public static Variable getVariable(Finder varType) {
    switch (varType) {

      case GenericInteger:
        return new IntVariable(varType);
      case GenericLong:
        return new LongVariable(varType);
      case GenericString:
        return new StringVariable(varType);
      case GenericByteArray:
        return new ByteArrayVariable(varType);
      case GenericArray:
        return new ArrayVariable(varType);
      case BlockID:
        return new LongVariable(varType);
      case INodeID:
        return new IntVariable(varType);
      case QuotaUpdateID:
        return new IntVariable(varType);
      case ReplicationIndex:
        return new ArrayVariable(varType);
      case StorageInfo:
        return new ArrayVariable(varType);
      case BlockTokenKeys:
        return new ArrayVariable(varType);
      case BTCurrKey:
      case BTNextKey:
      case BTSimpleKey:
        return new ByteArrayVariable(varType);
      case SIdCounter:
        return new IntVariable(varType);
      case HdfsLeParams:
      case YarnLeParams:
        return new StringVariable(varType);
      case MisReplicatedFilesIndex:
        return new LongVariable(varType);
      case ClusterInSafeMode:
        return new IntVariable(varType);
      case BrLbMaxBlkPerTW:
        return new LongVariable(varType);
      case RMStateStoreVersion:
        return new ByteArrayVariable(varType);
      case RMStateStoreEpoch:
        return new LongVariable(varType);
      case AMRMToken:
        return new ByteArrayVariable(varType);
      case RMDTSequenceNumber:
        return new IntVariable(varType);
      case QuotaTicksCounter:
        return new LongVariable(varType);
      case Seed:
        return new ByteArrayVariable(varType);
    }
    return null;
  }

  public static Variable initVariable(Finder varType, byte[] varData) {
    Variable var = getVariable(varType);
    if (var != null) {
      var.setValue(varData);
    }
    return var;
  }
}
