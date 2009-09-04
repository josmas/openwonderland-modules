/**
 * Project Looking Glass
 *
 * $RCSfile: EncodeException.java,v $
 *
 * Copyright (c) 2004-2008, Sun Microsystems, Inc., All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * $Revision: 1.3 $
 * $Date: 2008/03/14 18:14:27 $
 * $State: Exp $
 * $Id: EncodeException.java,v 1.3 2008/03/14 18:14:27 bernard_horan Exp $
 */

package org.jdesktop.wonderland.modules.movierecorder.client.utils;

/**
 * This exception is thrown if there is an error while trying to encode a movie.
 *
 * @author Mikael Nordenberg, <a href="http://www.ikanos.se">www.ikanos.se</a>
 */
public class EncodeException extends Exception {
    public EncodeException(String msg) {
        super(msg);
    }
    
    public EncodeException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

