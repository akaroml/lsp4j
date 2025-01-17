/**
 * Copyright (c) 2017, 2018 Kichwa Coders Ltd. and others.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 * 
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */
package org.eclipse.lsp4j.debug;

import org.eclipse.lsp4j.debug.util.Preconditions;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Properties of a breakpoint or logpoint passed to the setBreakpoints request.
 */
@SuppressWarnings("all")
public class SourceBreakpoint {
  /**
   * The source line of the breakpoint or logpoint.
   */
  @NonNull
  private Long line;
  
  /**
   * An optional source column of the breakpoint.
   * <p>
   * This is an optional property.
   */
  private Long column;
  
  /**
   * An optional expression for conditional breakpoints.
   * <p>
   * This is an optional property.
   */
  private String condition;
  
  /**
   * An optional expression that controls how many hits of the breakpoint are ignored. The backend is expected to
   * interpret the expression as needed.
   * <p>
   * This is an optional property.
   */
  private String hitCondition;
  
  /**
   * If this attribute exists and is non-empty, the backend must not 'break' (stop) but log the message instead.
   * Expressions within {} are interpolated.
   * <p>
   * This is an optional property.
   */
  private String logMessage;
  
  /**
   * The source line of the breakpoint or logpoint.
   */
  @Pure
  @NonNull
  public Long getLine() {
    return this.line;
  }
  
  /**
   * The source line of the breakpoint or logpoint.
   */
  public void setLine(@NonNull final Long line) {
    this.line = Preconditions.checkNotNull(line, "line");
  }
  
  /**
   * An optional source column of the breakpoint.
   * <p>
   * This is an optional property.
   */
  @Pure
  public Long getColumn() {
    return this.column;
  }
  
  /**
   * An optional source column of the breakpoint.
   * <p>
   * This is an optional property.
   */
  public void setColumn(final Long column) {
    this.column = column;
  }
  
  /**
   * An optional expression for conditional breakpoints.
   * <p>
   * This is an optional property.
   */
  @Pure
  public String getCondition() {
    return this.condition;
  }
  
  /**
   * An optional expression for conditional breakpoints.
   * <p>
   * This is an optional property.
   */
  public void setCondition(final String condition) {
    this.condition = condition;
  }
  
  /**
   * An optional expression that controls how many hits of the breakpoint are ignored. The backend is expected to
   * interpret the expression as needed.
   * <p>
   * This is an optional property.
   */
  @Pure
  public String getHitCondition() {
    return this.hitCondition;
  }
  
  /**
   * An optional expression that controls how many hits of the breakpoint are ignored. The backend is expected to
   * interpret the expression as needed.
   * <p>
   * This is an optional property.
   */
  public void setHitCondition(final String hitCondition) {
    this.hitCondition = hitCondition;
  }
  
  /**
   * If this attribute exists and is non-empty, the backend must not 'break' (stop) but log the message instead.
   * Expressions within {} are interpolated.
   * <p>
   * This is an optional property.
   */
  @Pure
  public String getLogMessage() {
    return this.logMessage;
  }
  
  /**
   * If this attribute exists and is non-empty, the backend must not 'break' (stop) but log the message instead.
   * Expressions within {} are interpolated.
   * <p>
   * This is an optional property.
   */
  public void setLogMessage(final String logMessage) {
    this.logMessage = logMessage;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("line", this.line);
    b.add("column", this.column);
    b.add("condition", this.condition);
    b.add("hitCondition", this.hitCondition);
    b.add("logMessage", this.logMessage);
    return b.toString();
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SourceBreakpoint other = (SourceBreakpoint) obj;
    if (this.line == null) {
      if (other.line != null)
        return false;
    } else if (!this.line.equals(other.line))
      return false;
    if (this.column == null) {
      if (other.column != null)
        return false;
    } else if (!this.column.equals(other.column))
      return false;
    if (this.condition == null) {
      if (other.condition != null)
        return false;
    } else if (!this.condition.equals(other.condition))
      return false;
    if (this.hitCondition == null) {
      if (other.hitCondition != null)
        return false;
    } else if (!this.hitCondition.equals(other.hitCondition))
      return false;
    if (this.logMessage == null) {
      if (other.logMessage != null)
        return false;
    } else if (!this.logMessage.equals(other.logMessage))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.line== null) ? 0 : this.line.hashCode());
    result = prime * result + ((this.column== null) ? 0 : this.column.hashCode());
    result = prime * result + ((this.condition== null) ? 0 : this.condition.hashCode());
    result = prime * result + ((this.hitCondition== null) ? 0 : this.hitCondition.hashCode());
    return prime * result + ((this.logMessage== null) ? 0 : this.logMessage.hashCode());
  }
}
