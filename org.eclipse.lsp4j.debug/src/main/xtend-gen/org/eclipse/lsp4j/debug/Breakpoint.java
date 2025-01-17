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

import org.eclipse.lsp4j.debug.Source;
import org.eclipse.lsp4j.debug.util.Preconditions;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Information about a Breakpoint created in setBreakpoints or setFunctionBreakpoints.
 */
@SuppressWarnings("all")
public class Breakpoint {
  /**
   * An optional unique identifier for the breakpoint. It is needed if breakpoint events are used to update or remove
   * breakpoints.
   * <p>
   * This is an optional property.
   */
  private Long id;
  
  /**
   * If true breakpoint could be set (but not necessarily at the desired location).
   */
  @NonNull
  private Boolean verified;
  
  /**
   * An optional message about the state of the breakpoint. This is shown to the user and can be used to explain why
   * a breakpoint could not be verified.
   * <p>
   * This is an optional property.
   */
  private String message;
  
  /**
   * The source where the breakpoint is located.
   * <p>
   * This is an optional property.
   */
  private Source source;
  
  /**
   * The start line of the actual range covered by the breakpoint.
   * <p>
   * This is an optional property.
   */
  private Long line;
  
  /**
   * An optional start column of the actual range covered by the breakpoint.
   * <p>
   * This is an optional property.
   */
  private Long column;
  
  /**
   * An optional end line of the actual range covered by the breakpoint.
   * <p>
   * This is an optional property.
   */
  private Long endLine;
  
  /**
   * An optional end column of the actual range covered by the breakpoint. If no end line is given, then the end
   * column is assumed to be in the start line.
   * <p>
   * This is an optional property.
   */
  private Long endColumn;
  
  /**
   * An optional unique identifier for the breakpoint. It is needed if breakpoint events are used to update or remove
   * breakpoints.
   * <p>
   * This is an optional property.
   */
  @Pure
  public Long getId() {
    return this.id;
  }
  
  /**
   * An optional unique identifier for the breakpoint. It is needed if breakpoint events are used to update or remove
   * breakpoints.
   * <p>
   * This is an optional property.
   */
  public void setId(final Long id) {
    this.id = id;
  }
  
  /**
   * If true breakpoint could be set (but not necessarily at the desired location).
   */
  @Pure
  @NonNull
  public Boolean getVerified() {
    return this.verified;
  }
  
  /**
   * If true breakpoint could be set (but not necessarily at the desired location).
   */
  public void setVerified(@NonNull final Boolean verified) {
    this.verified = Preconditions.checkNotNull(verified, "verified");
  }
  
  /**
   * An optional message about the state of the breakpoint. This is shown to the user and can be used to explain why
   * a breakpoint could not be verified.
   * <p>
   * This is an optional property.
   */
  @Pure
  public String getMessage() {
    return this.message;
  }
  
  /**
   * An optional message about the state of the breakpoint. This is shown to the user and can be used to explain why
   * a breakpoint could not be verified.
   * <p>
   * This is an optional property.
   */
  public void setMessage(final String message) {
    this.message = message;
  }
  
  /**
   * The source where the breakpoint is located.
   * <p>
   * This is an optional property.
   */
  @Pure
  public Source getSource() {
    return this.source;
  }
  
  /**
   * The source where the breakpoint is located.
   * <p>
   * This is an optional property.
   */
  public void setSource(final Source source) {
    this.source = source;
  }
  
  /**
   * The start line of the actual range covered by the breakpoint.
   * <p>
   * This is an optional property.
   */
  @Pure
  public Long getLine() {
    return this.line;
  }
  
  /**
   * The start line of the actual range covered by the breakpoint.
   * <p>
   * This is an optional property.
   */
  public void setLine(final Long line) {
    this.line = line;
  }
  
  /**
   * An optional start column of the actual range covered by the breakpoint.
   * <p>
   * This is an optional property.
   */
  @Pure
  public Long getColumn() {
    return this.column;
  }
  
  /**
   * An optional start column of the actual range covered by the breakpoint.
   * <p>
   * This is an optional property.
   */
  public void setColumn(final Long column) {
    this.column = column;
  }
  
  /**
   * An optional end line of the actual range covered by the breakpoint.
   * <p>
   * This is an optional property.
   */
  @Pure
  public Long getEndLine() {
    return this.endLine;
  }
  
  /**
   * An optional end line of the actual range covered by the breakpoint.
   * <p>
   * This is an optional property.
   */
  public void setEndLine(final Long endLine) {
    this.endLine = endLine;
  }
  
  /**
   * An optional end column of the actual range covered by the breakpoint. If no end line is given, then the end
   * column is assumed to be in the start line.
   * <p>
   * This is an optional property.
   */
  @Pure
  public Long getEndColumn() {
    return this.endColumn;
  }
  
  /**
   * An optional end column of the actual range covered by the breakpoint. If no end line is given, then the end
   * column is assumed to be in the start line.
   * <p>
   * This is an optional property.
   */
  public void setEndColumn(final Long endColumn) {
    this.endColumn = endColumn;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("id", this.id);
    b.add("verified", this.verified);
    b.add("message", this.message);
    b.add("source", this.source);
    b.add("line", this.line);
    b.add("column", this.column);
    b.add("endLine", this.endLine);
    b.add("endColumn", this.endColumn);
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
    Breakpoint other = (Breakpoint) obj;
    if (this.id == null) {
      if (other.id != null)
        return false;
    } else if (!this.id.equals(other.id))
      return false;
    if (this.verified == null) {
      if (other.verified != null)
        return false;
    } else if (!this.verified.equals(other.verified))
      return false;
    if (this.message == null) {
      if (other.message != null)
        return false;
    } else if (!this.message.equals(other.message))
      return false;
    if (this.source == null) {
      if (other.source != null)
        return false;
    } else if (!this.source.equals(other.source))
      return false;
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
    if (this.endLine == null) {
      if (other.endLine != null)
        return false;
    } else if (!this.endLine.equals(other.endLine))
      return false;
    if (this.endColumn == null) {
      if (other.endColumn != null)
        return false;
    } else if (!this.endColumn.equals(other.endColumn))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.id== null) ? 0 : this.id.hashCode());
    result = prime * result + ((this.verified== null) ? 0 : this.verified.hashCode());
    result = prime * result + ((this.message== null) ? 0 : this.message.hashCode());
    result = prime * result + ((this.source== null) ? 0 : this.source.hashCode());
    result = prime * result + ((this.line== null) ? 0 : this.line.hashCode());
    result = prime * result + ((this.column== null) ? 0 : this.column.hashCode());
    result = prime * result + ((this.endLine== null) ? 0 : this.endLine.hashCode());
    return prime * result + ((this.endColumn== null) ? 0 : this.endColumn.hashCode());
  }
}
