package vn.gddvietnam.workshop1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jupiter (vu.cao.duy@gmail.com) on 12/12/15.
 */
public class ScrollViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        LinearLayout llItems = (LinearLayout) findViewById(R.id.ll_items);
        List<String> storyData = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            llItems.addView(generateChildView(new String("Story number " + i)));
        }
    }

    private View generateChildView(String storyName) {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View childView = layoutInflater.inflate(R.layout.item_story, null);
        TextView tvStoryName = (TextView) childView.findViewById(R.id.tv_story_name);
        tvStoryName.setText(storyName);
        return  childView;
    }
}
