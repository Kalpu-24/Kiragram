package org.kiragram.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

import com.google.android.exoplayer2.util.Log;

import org.kiragram.messenger.Utilities;
import org.kiragram.ui.ActionBar.ActionBar;
import org.kiragram.ui.ActionBar.BaseFragment;
import org.kiragram.ui.ActionBar.DrawerLayoutContainer;
import org.kiragram.ui.ActionBar.INavigationLayout;
import org.kiragram.ui.ActionBar.Theme;
import org.kiragram.ui.Components.BackButtonMenu;
import org.kiragram.ui.Components.LayoutHelper;
import org.kiragram.ui.Components.RecyclerListView;

import java.util.List;

public class ChatActivityContainer extends FrameLayout {

    public final ChatActivity chatActivity;
    private final INavigationLayout parentLayout;
    private View fragmentView;

    public ChatActivityContainer(
        Context context,
        Utilities.Callback0Return<FrameLayout> resizableView,
        INavigationLayout parentLayout,
        Bundle args
    ) {
        super(context);
        this.parentLayout = parentLayout;

        chatActivity = new ChatActivity(args) {
            @Override
            public void setNavigationBarColor(int color) {}

            @Override
            protected void onSearchLoadingUpdate(boolean loading) {
                ChatActivityContainer.this.onSearchLoadingUpdate(loading);
            }
        };
        chatActivity.insideContainerResizableView = resizableView;
        chatActivity.isInsideContainer = true;
    }

    protected void onSearchLoadingUpdate(boolean loading) {

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        if (!chatActivity.onFragmentCreate()) {
            return;
        }

        fragmentView = chatActivity.fragmentView;
        chatActivity.setParentLayout(parentLayout);
        if (fragmentView == null) {
            fragmentView = chatActivity.createView(getContext());
        } else {
            ViewGroup parent = (ViewGroup) fragmentView.getParent();
            if (parent != null) {
                chatActivity.onRemoveFromParent();
                parent.removeView(fragmentView);
            }
        }
        chatActivity.openedInstantly();
        addView(fragmentView, LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT, LayoutHelper.MATCH_PARENT));
        if (isActive) {
            chatActivity.onResume();
        }
    }

    private boolean isActive = true;
    public void onPause() {
        isActive = false;
        if (fragmentView != null) {
            chatActivity.onPause();
        }
    }

    public void onResume() {
        isActive = true;
        if (fragmentView != null) {
            chatActivity.onResume();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
