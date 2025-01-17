/******************************************************************************
 * Copyright (c) 2017 Kichwa Coders Ltd. and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 ******************************************************************************/

package org.eclipse.lsp4j.debug.services;

import org.eclipse.lsp4j.debug.BreakpointEventArguments;
import org.eclipse.lsp4j.debug.CapabilitiesEventArguments;
import org.eclipse.lsp4j.debug.ContinuedEventArguments;
import org.eclipse.lsp4j.debug.ExitedEventArguments;
import org.eclipse.lsp4j.debug.LoadedSourceEventArguments;
import org.eclipse.lsp4j.debug.ModuleEventArguments;
import org.eclipse.lsp4j.debug.OutputEventArguments;
import org.eclipse.lsp4j.debug.ProcessEventArguments;
import org.eclipse.lsp4j.debug.StoppedEventArguments;
import org.eclipse.lsp4j.debug.TerminatedEventArguments;
import org.eclipse.lsp4j.debug.ThreadEventArguments;
import org.eclipse.lsp4j.jsonrpc.services.JsonNotification;

/**
 * Declaration of client notifications for the
 * <a href="https://microsoft.github.io/debug-adapter-protocol/">Debug Adapter
 * Protocol</a>
 */
public interface IDebugProtocolClient {
	/**
	 * Version of Debug Protocol
	 */
	public static final String SCHEMA_VERSION = "1.35.0";

	/**
	 * This event indicates that the debug adapter is ready to accept configuration
	 * requests (e.g. SetBreakpointsRequest, SetExceptionBreakpointsRequest).
	 * <p>
	 * A debug adapter is expected to send this event when it is ready to accept
	 * configuration requests (but not before the 'initialize' request has
	 * finished).
	 * <p>
	 * The sequence of events/requests is as follows:
	 * <ul>
	 * <li>adapters sends 'initialized' event (after the 'initialize' request has
	 * returned)</li>
	 * <li>frontend sends zero or more 'setBreakpoints' requests</li>
	 * <li>frontend sends one 'setFunctionBreakpoints' request</li>
	 * <li>frontend sends a 'setExceptionBreakpoints' request if one or more
	 * 'exceptionBreakpointFilters' have been defined (or if
	 * 'supportsConfigurationDoneRequest' is not defined or false)</li>
	 * <li>frontend sends other future configuration requests</li>
	 * <li>frontend sends one 'configurationDone' request to indicate the end of the
	 * configuration.</li>
	 * </ul>
	 */
	@JsonNotification
	default void initialized() {
	}

	/**
	 * The event indicates that the execution of the debuggee has stopped due to
	 * some condition.
	 * <p>
	 * This can be caused by a break point previously set, a stepping action has
	 * completed, by executing a debugger statement etc.
	 */
	@JsonNotification
	default void stopped(StoppedEventArguments args) {
	}

	/**
	 * The event indicates that the execution of the debuggee has continued.
	 * <p>
	 * Please note: a debug adapter is not expected to send this event in response
	 * to a request that implies that execution continues, e.g. 'launch' or
	 * 'continue'.
	 * <p>
	 * It is only necessary to send a 'continued' event if there was no previous
	 * request that implied this.
	 */
	@JsonNotification
	default void continued(ContinuedEventArguments args) {
	}

	/**
	 * The event indicates that the debuggee has exited and returns its exit code.
	 */
	@JsonNotification
	default void exited(ExitedEventArguments args) {
	}

	/**
	 * The event indicates that debugging of the debuggee has terminated. This does
	 * **not** mean that the debuggee itself has exited.
	 */
	@JsonNotification
	default void terminated(TerminatedEventArguments args) {
	}

	/**
	 * The event indicates that a thread has started or exited.
	 */
	@JsonNotification
	default void thread(ThreadEventArguments args) {
	}

	/**
	 * The event indicates that the target has produced some output.
	 */
	@JsonNotification
	default void output(OutputEventArguments args) {
	}

	/**
	 * The event indicates that some information about a breakpoint has changed.
	 */
	@JsonNotification
	default void breakpoint(BreakpointEventArguments args) {
	}

	/**
	 * The event indicates that some information about a module has changed.
	 */
	@JsonNotification
	default void module(ModuleEventArguments args) {
	}

	/**
	 * The event indicates that some source has been added, changed, or removed from
	 * the set of all loaded sources.
	 */
	@JsonNotification
	default void loadedSource(LoadedSourceEventArguments args) {
	}

	/**
	 * The event indicates that the debugger has begun debugging a new process.
	 * Either one that it has launched, or one that it has attached to.
	 */
	@JsonNotification
	default void process(ProcessEventArguments args) {
	}

	/**
	 * The event indicates that one or more capabilities have changed.
	 * <p>
	 * Since the capabilities are dependent on the frontend and its UI, it might not
	 * be possible to change that at random times (or too late).
	 * <p>
	 * Consequently this event has a hint characteristic: a frontend can only be
	 * expected to make a 'best effort' in honouring individual capabilities but
	 * there are no guarantees.
	 * <p>
	 * Only changed capabilities need to be included, all other capabilities keep
	 * their values.
	 */
	@JsonNotification
	default void capabilities(CapabilitiesEventArguments args) {
	}
}
