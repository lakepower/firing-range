/*
 * Copyright 2018 Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.testing.security.firingrange.tests.invalidframingconfig;

import com.google.common.net.HttpHeaders;
import com.google.testing.security.firingrange.utils.Responses;
import com.google.testing.security.firingrange.utils.Templates;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles setting CSP frame-ancestors without corresponding ALLOW-FROM X-FRAME-OPTIONS header. */
public class FrameAncestorsNoXFOAllowFrom extends HttpServlet {
  private static final String BASE_TEMPLATE = "frameancestorsnoxfoallowfrom.tmpl";

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String template = Templates.getTemplate(BASE_TEMPLATE, this.getClass());
    response.setHeader(HttpHeaders.CONTENT_SECURITY_POLICY, "frame-ancestors https://example.com");

    Responses.sendNormalPage(response, template);
  }
}
