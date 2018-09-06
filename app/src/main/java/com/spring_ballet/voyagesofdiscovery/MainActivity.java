package com.spring_ballet.voyagesofdiscovery;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.baidu.ar.constants.ARConfigKey;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    private String[] mArName;
    private List<ListItemBean> mListData;
    private VideoView mVideoView_desc;
    private TextView mTextView_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        initData();
        initView();
    }

    private void initData() {
        mArName = getResources().getStringArray(R.array.ar_name);
        mListData = getListItemData();
    }

    private void initView() {
        mTextView_desc=findViewById(R.id.tv_desc);
        mVideoView_desc=findViewById(R.id.vv_desc);
//        ListView listView = findViewById(R.id.demo_list);
//        listView.addFooterView(new ViewStub(this));
//        ArrayAdapter adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, mArName);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(MainActivity.this, ARActivity.class);
//                ListItemBean listItemBean = mListData.get(position);
//                intent.putExtra(ARConfigKey.AR_KEY, listItemBean.getARKey());
//                intent.putExtra(ARConfigKey.AR_TYPE, listItemBean.getARType());
//                startActivity(intent);
//            }
//        });

        final String videoUrl = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
        Uri uri = Uri.parse( videoUrl );

        //设置视频控制器
        mVideoView_desc.setMediaController(new MediaController(this));

//        //播放完成回调
//        mVideoView_desc.setOnCompletionListener( new MyPlayerOnCompletionListener());

        //设置视频路径
        mVideoView_desc.setVideoURI(uri);

        //开始播放视频
        mVideoView_desc.start();

    }

    private List<ListItemBean> getListItemData() {
        List<ListItemBean> list = new ArrayList<>();
        // 故宫
        list.add(new ListItemBean(5, "10190835", mArName[0]));
        // 本地识图
        list.add(new ListItemBean(6, "", mArName[1]));
        return list;
    }

    private class ListItemBean {
        String mARKey;
        int mARType;
        String mName;

        ListItemBean(int arType, String arKey, String name) {
            this.mARType = arType;
            this.mARKey = arKey;
            this.mName = name;
        }

        String getARKey() {
            return mARKey;
        }

        int getARType() {
            return mARType;
        }

        public String getName() {
            return mName;
        }

    }
    @Override
    public void onNavigationDrawerItemSelected(int position) {
        //update the main content by replacing fragments
//        FragmentManager fragmentManager = getFragmentManager();
//        fragmentManager.beginTransaction()
//                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
//                .commit();
        switch (position){
            case 1:
                //调用与朱元璋合影的SLAM模型
                break;

            case 2:
                break;
            case 3:
                break;
        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }


}
