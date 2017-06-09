package com.pangli.drag.interfaces;

/**
 * Interface to listen move in ItemTouchHelper.Callback
 * Created by pangli on 09/06/2017.
 */
public interface CallbackItemTouch {

    /**
     * Called when an item has been dragged
     *
     * @param oldPosition start position
     * @param newPosition end position
     */
    void itemTouchOnMove(int oldPosition, int newPosition);
}
