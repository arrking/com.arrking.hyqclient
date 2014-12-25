package com.arrking.hyqclient.ui.dashboard;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.*;

import com.arrking.hyqclient.R;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hain on 23/12/2014.
 */
public class DashIndexActivity extends Activity implements BaseSliderView.OnSliderClickListener {

    private static final String TAG = new String("DashIndexActivity");
    private SliderLayout recommendSlidesLayout;
    private RelativeLayout recommendListLayout;
    private ListView recommendListView;
    // top bar title text
    private TextView tb_title;
    private List<? extends Map<String, ?>> recommendListData;


    // setup recommendations slides
    private void initSlides() {
        recommendSlidesLayout = (SliderLayout) findViewById(R.id.slider);
        // images can also load from Internet
        // HashMap<String,String> url_maps = new HashMap<String, String>();
//        url_maps.put("Hannibal", "http://static2.hypable.com/wp-content/uploads/2013/12/hannibal-season-2-release-date.jpg");
//        url_maps.put("Big Bang Theory", "http://tvfiles.alphacoders.com/100/hdclearart-10.png");
//        url_maps.put("House of Cards", "http://cdn3.nflximg.net/images/3093/2043093.jpg");
//        url_maps.put("Game of Thrones", "http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("女人节到哪里?", R.drawable.demo_dummy_activity1);
        file_maps.put("新品推荐", R.drawable.demo_dummy_activity2);
        file_maps.put("香辣鸡腿", R.drawable.demo_dummy_activity3);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.getBundle()
                    .putString("extra", name);

            recommendSlidesLayout.addSlider(textSliderView);
        }
        recommendSlidesLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        recommendSlidesLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        recommendSlidesLayout.setCustomAnimation(new DescriptionAnimation());
        recommendSlidesLayout.setDuration(4000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        // set title
        tb_title = (TextView) findViewById(R.id.txt_wb_title);
        tb_title.setText("主页");

        // init recommendations
        initSlides();
        initListView();

//        ListView l = (ListView)findViewById(R.id.transformers);
//        l.setAdapter(new TransformerAdapter(this));
//        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                recommendSlidesLayout.setPresetTransformer(((TextView) view).getText().toString());
//                Toast.makeText(DashIndexActivity.this, ((TextView) view).getText().toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void initListView() {
        this.recommendListLayout = (RelativeLayout) findViewById(R.id.dash_list_items);
        this.recommendListView = new ListView(this);

        SimpleAdapter adapter = new SimpleAdapter(this,
                getRecommendListData(),
                R.layout.dash_list_item,
                new String[]{"title", "desc"},
                new int[]{R.id.recommend_list_item_title_textview, R.id.recommend_list_item_desc_textview});
        this.recommendListView.setAdapter(adapter);
        this.recommendListLayout.addView(this.recommendListView);

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this, slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    private List<Map<String, Object>> getRecommendListData() {
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

        for(int i = 0; i < 10 ; i++){
            Map<String, Object> r = new HashMap<String, Object>();
            r.put("title", "冬天吃什么 index" + Integer.toString(i));
            r.put("desc", "小火锅,小火锅,小火锅,小火锅,小火锅,小火锅,小火锅,");
            data.add(r);
        }
        return data;
    }
}


