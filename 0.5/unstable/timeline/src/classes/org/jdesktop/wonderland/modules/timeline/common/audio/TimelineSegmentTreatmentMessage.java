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

package org.jdesktop.wonderland.modules.timeline.common.audio;

import org.jdesktop.wonderland.modules.timeline.common.TimelineSegment;

import org.jdesktop.wonderland.common.cell.CellID;

import org.jdesktop.wonderland.common.cell.messages.CellMessage;

import com.jme.math.Vector3f;

/**
 *
 *  
 */
public class TimelineSegmentTreatmentMessage extends CellMessage {

    private TimelineSegment segment;
    private Vector3f location;
    private String treatment;

    public TimelineSegmentTreatmentMessage(CellID cellID, TimelineSegment segment,
	    Vector3f location, String treatment) {

	super(cellID);

	this.segment = segment;
	this.location = location;
	this.treatment = treatment;
    }

    public TimelineSegment getSegment() {
	return segment;
    }

    public Vector3f getLocation() {
	return location;
    }

    public String getTreatment() {
	return treatment;
    }

}
