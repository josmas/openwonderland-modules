/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jdesktop.wonderland.modules.pdfpresentation.client;

import com.jme.math.Quaternion;
import com.jme.math.Vector3f;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.wonderland.common.cell.CellTransform;
import org.jdesktop.wonderland.modules.pdf.client.DeployedPDF;
import org.jdesktop.wonderland.modules.pdf.client.PDFDeployer;
import org.jdesktop.wonderland.modules.pdfpresentation.common.PDFSpreaderCellChangeMessage.LayoutType;
import org.jdesktop.wonderland.modules.pdfpresentation.common.SlideMetadata;

/**
 * A helper class for handling layouts.
 * 
 * I've abstracted this out because we need to be able to run layouts in the
 * CellFactory as well as in response to UI updates, so it needed to be
 * somewhere other than where those two events happen.
 *
 * @author Drew Harry <dharry@media.mit.edu>
 */
public class PDFLayoutHelper {

    public static List<SlideMetadata> generateLayoutMetadata(LayoutType layout, DeployedPDF pdf, float spacing) {

        List<SlideMetadata> slidesMetadata = new ArrayList<SlideMetadata>();

//        PresentationSlideMetadata previous = null;
        SlideMetadata current = null;

        int numSlides = pdf.getNumberOfSlides();

        // Loop through the slides, generating a metadata object for each one.
        for(int i=0; i<numSlides; i++) {

            CellTransform trans = getSlideTransform(numSlides, i, layout, spacing);

            current = new SlideMetadata();
            current.setTransform(trans);
            current.setPageIndex(i);

            slidesMetadata.add(current);
        }

        return slidesMetadata;
    }



    private static CellTransform getSlideTransform(int numSlides, int i, LayoutType layout, float spacing) {
        // basically copying this from the client layout code, since layout is always
        // going to happen serverside now.

        Vector3f pos = null;
        Quaternion rot = null;

        float curAngle;
        switch(layout) {
            case CIRCLE:
                curAngle = (float) (i * (2*Math.PI / numSlides));
                rot = new Quaternion().fromAngleNormalAxis((float) (curAngle + Math.PI / 2), new Vector3f(0, 1, 0));
                pos = new Vector3f((float)(spacing*Math.sin(curAngle)), 0.0f, (float)(spacing*Math.cos(curAngle)));
                break;

            case SEMICIRCLE:
                int n = numSlides - i;
                curAngle = (float) (n * (Math.PI / numSlides));
                pos = new Vector3f((float)(spacing*Math.sin(curAngle)), 0.0f, (float)(spacing*Math.cos(curAngle)));
                rot = new Quaternion().fromAngleNormalAxis((float) (curAngle + Math.PI / 2), new Vector3f(0, 1, 0));
                break;

            case LINEAR:
                // i->1 because pages is 1->n, not 0->(n-1)
                // the other negative bit recenters the line around the middle
                // of the set of slides, not the start point.
                pos = new Vector3f(0, 0, (spacing * (i-1) + (spacing*((numSlides-1)/2.0f)*-1)));
                rot = new Quaternion();
                break;

            default:
                break;
        }

        // Use 1.0 scale, because the scale is applied to the entire later in
        // the process.
        return new CellTransform(rot, pos, 1.0f);
    }


}
