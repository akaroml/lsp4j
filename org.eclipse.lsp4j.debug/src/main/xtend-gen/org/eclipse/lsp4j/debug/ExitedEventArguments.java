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
 * The event indicates that the debuggee has exited and returns its exit code.
 */
@SuppressWarnings("all")
public class ExitedEventArguments {
  /**
   * The exit code returned from the debuggee.
   */
  @NonNull
  private Long exitCode;
  
  /**
   * The exit code returned from the debuggee.
   */
  @Pure
  @NonNull
  public Long getExitCode() {
    return this.exitCode;
  }
  
  /**
   * The exit code returned from the debuggee.
   */
  public void setExitCode(@NonNull final Long exitCode) {
    this.exitCode = Preconditions.checkNotNull(exitCode, "exitCode");
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("exitCode", this.exitCode);
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
    ExitedEventArguments other = (ExitedEventArguments) obj;
    if (this.exitCode == null) {
      if (other.exitCode != null)
        return false;
    } else if (!this.exitCode.equals(other.exitCode))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * 1 + ((this.exitCode== null) ? 0 : this.exitCode.hashCode());
  }
}
