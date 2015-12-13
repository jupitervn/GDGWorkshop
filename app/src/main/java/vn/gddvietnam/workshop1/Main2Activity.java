package vn.gddvietnam.workshop1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    public static final String EXTRA_KEY = "extra-input-data";
    public static final String EXTRA_STORY_CLICKED = "extra-story-clicked";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Data inputData = (Data) getIntent().getSerializableExtra(EXTRA_KEY);
        setTitle(inputData.getInputString());
        ListView listView = (ListView) findViewById(R.id.lv_items);

        final List<String> storyData = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            storyData.add(new String("Story number " + i));
        }

        ItemAdapter itemAdapter = new ItemAdapter(this, R.layout.item_story);
        itemAdapter.addAll(storyData);
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String story = storyData.get(position);
                Intent dataIntent = new Intent();
                CustomApplication application = (CustomApplication) getApplication();
                dataIntent.putExtra(EXTRA_STORY_CLICKED, story);
                setResult(Activity.RESULT_OK, dataIntent);
                finish();
            }
        });
    }

    private static class ItemAdapter extends ArrayAdapter<String> {

        public ItemAdapter(Context context, int resource) {
            super(context, resource);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(getContext());
                convertView = layoutInflater.inflate(R.layout.item_story, parent, false);
            }
            TextView tvStoryName = (TextView) convertView.findViewById(R.id.tv_story_name);
            tvStoryName.setText(getItem(position));
            return convertView;
        }
    }
}
