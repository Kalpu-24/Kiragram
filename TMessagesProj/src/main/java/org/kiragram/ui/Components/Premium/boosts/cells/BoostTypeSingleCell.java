package org.kiragram.ui.Components.Premium.boosts.cells;

import static org.kiragram.messenger.AndroidUtilities.dp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;

import org.kiragram.messenger.AndroidUtilities;
import org.kiragram.messenger.LocaleController;
import org.kiragram.messenger.R;
import org.kiragram.tgnet.tl.TL_stories;
import org.kiragram.ui.ActionBar.Theme;
import org.kiragram.ui.Components.AvatarDrawable;
import org.kiragram.ui.Components.LayoutHelper;

@SuppressLint("ViewConstructor")
public class BoostTypeSingleCell extends BoostTypeCell {

    public BoostTypeSingleCell(Context context, Theme.ResourcesProvider resourcesProvider) {
        super(context, resourcesProvider);
    }

    public void setGiveaway(TL_stories.TL_prepaidGiveaway prepaidGiveaway) {
        subtitleTextView.setTextColor(Theme.getColor(Theme.key_dialogTextGray3, resourcesProvider));
        avatarDrawable.setAvatarType(AvatarDrawable.AVATAR_TYPE_GIFT);
        titleTextView.setText(LocaleController.formatString("BoostingPreparedGiveawayOne", R.string.BoostingPreparedGiveawayOne));
        String subtitle = LocaleController.formatPluralString("BoostingPreparedGiveawaySubscriptionsPlural", prepaidGiveaway.quantity, LocaleController.formatPluralString("Months", prepaidGiveaway.months));
        setSubtitle(subtitle);
        if (prepaidGiveaway.months == 12) {
            avatarDrawable.setColor(0xFFff8560, 0xFFd55246);
        } else if (prepaidGiveaway.months == 6) {
            avatarDrawable.setColor(0xFF5caefa, 0xFF418bd0);
        } else {
            avatarDrawable.setColor(0xFF9ad164, 0xFF49ba44);
        }
        imageView.setImageDrawable(avatarDrawable);
        imageView.setRoundRadius(dp(20));
    }

    @Override
    protected void updateLayouts() {
        imageView.setLayoutParams(LayoutHelper.createFrame(40, 40, Gravity.CENTER_VERTICAL | (LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT), 16, 0, 16, 0));
        titleTextView.setLayoutParams(LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT, Gravity.CENTER_VERTICAL | (LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT), LocaleController.isRTL ? 20 : (69), 0, LocaleController.isRTL ? (69) : 20, 0));
        subtitleTextView.setLayoutParams(LayoutHelper.createFrame(LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT, Gravity.CENTER_VERTICAL | (LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT), LocaleController.isRTL ? 20 : (69), 0, LocaleController.isRTL ? (69) : 20, 0));
    }

    @Override
    protected boolean needCheck() {
        return false;
    }
}
