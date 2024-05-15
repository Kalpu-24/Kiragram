package org.kiragram.ui.Charts;

import android.animation.Animator;

import org.kiragram.ui.Charts.data.ChartData;
import org.kiragram.ui.Charts.view_data.StackLinearViewData;

public class PieChartViewData extends StackLinearViewData {

    float selectionA;
    float drawingPart;
    Animator animator;

    public PieChartViewData(ChartData.Line line) {
        super(line);
    }
}
