package com.example.xyzreader.ui;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.xyzreader.R;

public class CoolPageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();
        float alpha;

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            page.setAlpha(0);

        } else if (position <= 1) { // [-1,1]
            page.setAlpha(1f);

            // move image with half the normal speed
            page.findViewById(R.id.photo).setTranslationX(-position * (pageWidth / 2));

            // rotate fab
            page.findViewById(R.id.share_fab).setRotation(position * 360f);

            // fade in and out for other views
            alpha = 1f - Math.abs(position);
            page.findViewById(R.id.article_title).setAlpha(alpha);
            page.findViewById(R.id.article_byline).setAlpha(alpha);
            page.findViewById(R.id.article_body).setAlpha(alpha);

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            page.setAlpha(0);
        }

    }
}
