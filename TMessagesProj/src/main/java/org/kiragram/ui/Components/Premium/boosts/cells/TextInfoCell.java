package org.kiragram.ui.Components.Premium.boosts.cells;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import org.kiragram.messenger.R;
import org.kiragram.ui.ActionBar.Theme;
import org.kiragram.ui.Cells.TextInfoPrivacyCell;
import org.kiragram.ui.Components.CombinedDrawable;

@SuppressLint("ViewConstructor")
public class TextInfoCell extends TextInfoPrivacyCell {
    private final Theme.ResourcesProvider resourcesProvider;

    public TextInfoCell(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context, resourcesProvider);
        this.resourcesProvider = resourcesProvider;
    }

    public void setBackground(boolean onlyTopDivider) {
        Drawable shadowDrawable = Theme.getThemedDrawable(getContext(), onlyTopDivider ? R.drawable.greydivider_bottom : R.drawable.greydivider, Theme.getColor(Theme.key_windowBackgroundGrayShadow, resourcesProvider));
        Drawable background = new ColorDrawable(Theme.getColor(Theme.key_windowBackgroundGray, resourcesProvider));
        CombinedDrawable combinedDrawable = new CombinedDrawable(background, shadowDrawable, 0, 0);
        combinedDrawable.setFullsize(true);
        setBackground(combinedDrawable);
    }
}