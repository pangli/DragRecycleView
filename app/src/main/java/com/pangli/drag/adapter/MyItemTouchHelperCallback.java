package com.pangli.drag.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.pangli.drag.interfaces.CallbackItemTouch;


/**
 * Created by pangli on 09/06/2017.
 */
public class MyItemTouchHelperCallback extends ItemTouchHelper.Callback {

    CallbackItemTouch callbackItemTouch; // interface

    public MyItemTouchHelperCallback(CallbackItemTouch callbackItemTouch) {
        this.callbackItemTouch = callbackItemTouch;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return false; // swiped disabled
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags;// movements drag
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            dragFlags = ItemTouchHelper.DOWN | ItemTouchHelper.UP
                    | ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT;
        } else {
            dragFlags = ItemTouchHelper.DOWN | ItemTouchHelper.UP;
        }
        return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG, dragFlags); // as parameter, action drag and flags drag
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder
            target) {
        int fromPosition = viewHolder.getAdapterPosition();
        int toPosition = target.getAdapterPosition();
        callbackItemTouch.itemTouchOnMove(fromPosition, toPosition);
        // information to the interface
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        // swiped disabled
    }
}
