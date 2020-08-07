/********************************************************************************
 * Copyright (c) 2020 EclipseSource and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 ********************************************************************************/
package org.eclipse.glsp.example.simple;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.eclipse.glsp.server.launch.DefaultGLSPServerLauncher;
import org.eclipse.glsp.server.launch.GLSPServerLauncher;

public final class SimpleServerLauncher {
   private SimpleServerLauncher() {}

   public static void main(final String[] args) {
      configureLogger();
      GLSPServerLauncher launcher = new DefaultGLSPServerLauncher(new SimpleGLSPModule());
      launcher.start("localhost", 5007);
   }

   public static void configureLogger() {
      Logger root = Logger.getRootLogger();
      if (!root.getAllAppenders().hasMoreElements()) {
         root.addAppender(new ConsoleAppender(
            new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN)));
      }
      root.setLevel(Level.DEBUG);

   }
}
