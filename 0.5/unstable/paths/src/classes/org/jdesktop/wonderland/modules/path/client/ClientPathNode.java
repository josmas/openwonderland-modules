package org.jdesktop.wonderland.modules.path.client;

import java.io.Serializable;
import org.jdesktop.wonderland.modules.path.common.NodePath;
import org.jdesktop.wonderland.modules.path.common.PathNode;

/**
 * This interface extends the basic PathNode interface to provide ease of access to
 * previous and next nodes in order to simplify rendering of nodes and segments.
 *
 * @author Carl Jokl
 */
public interface ClientPathNode extends PathNode, Serializable {

    /**
     * Get the parent NodePath of the ClientPathNode.
     *
     * @return The parent NodePath of this ClientPathNode.
     */
    public NodePath getPath();

    /**
     * Get the last ClientPathNode in the chain of ClientPathNodes. This method
     * traverses all the next node references until it finds a node which
     * has no next node (which is assumed to be the last node.
     * 
     * @return The last ClientPathNode in the chain of ClientPathNodes.
     */
    public ClientPathNode getLast();

    /**
     * Get the next node in the sequence for this PathCell.
     *
     * @return The next ClientPathNode in the sequence for this PathCell.
     */
    public ClientPathNode getNext();

    /**
     * Whether the ClientPathNode which is next after this ClientPathNode
     * has been set.
     * 
     * @return True if the next ClientPathNode is set.
     */
    public boolean hasNext();


    /**
     * Get the first node in the chain of ClientPathNodes. This method
     * will use the previous node and keep linking back unit a node
     * with no previous is encountered. This is assumed to be the first
     * ClientPathNode.
     * 
     * @return The first ClientPathNode in the chain of ClientPathNode.
     */
    public ClientPathNode getFirst();

    /**
     * Get the previous ClientPathNode in the sequence for the PathCell.
     *
     * @return The previous ClientPathNode in the sequence for the PathCell.
     */
    public ClientPathNode getPrevious();

    /**
     * Whether the ClientPathNode which is before this ClientPathNode
     * has been set.
     *
     * @return True if the previous ClientPathNode is set.
     */
    public boolean hasPrevious();

    /**
     * Whether this ClientPathNode is a sentinel node.
     * This is relevant to closed paths where the links from previous to next
     * ClientPathNodes loop around. In these cases another means is needed
     * to identify the start of the path to stop certain operations looping forever.
     * 
     * @return True if this node is a sentinel node in a ClosedPath. 
     */
    public boolean isSentinel();

    /**
     * Clear out the internal state of this ClientPathNode prior to deletion.
     * This helps the node or attached references be garbage collected.
     */
    public void dispose();
}
