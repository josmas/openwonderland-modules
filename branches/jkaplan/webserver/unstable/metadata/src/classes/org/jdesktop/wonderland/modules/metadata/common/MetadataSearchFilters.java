/**
 * Project Wonderland
 *
 * Copyright (c) 2004-2009, Sun Microsystems, Inc., All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * Sun designates this particular file as subject to the "Classpath"
 * exception as provided by Sun in the License file that accompanied
 * this code.
 */

package org.jdesktop.wonderland.modules.metadata.common;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A simple container for search filters.
 * @author mabonner
 */
public class MetadataSearchFilters implements Serializable{
  private ArrayList<Metadata> filters = new ArrayList<Metadata>();
  public void addFilter(Metadata m) {
    filters.add(m);
  }

  public int filterCount(){
    return filters.size();
  }

  public ArrayList<Metadata> getFilters(){
    return filters;
  }
}