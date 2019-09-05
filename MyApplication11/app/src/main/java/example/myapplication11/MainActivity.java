package example.myapplication11;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ArrayList<MyListItem> listData = new ArrayList();   //存放数据
    MyListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //放入适配器并设置一行4列
        GridView gridView = (GridView)findViewById(R.id.id_gridview);
        listAdapter = new MyListAdapter();
        gridView.setAdapter(listAdapter);
        gridView.setNumColumns(4);

        //加载数据
        demoData();

        //设置点击事件
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                MainActivity.this.onItemClick(position);
            }
        });
    }
    public class MyListItem
    {
        public String title;
        public Drawable icon;
        public String website;
    }
    public class MyListAdapter extends BaseAdapter
    {

        @Override
        public int getCount()
        {
            return listData.size();
        }

        @Override
        public Object getItem(int position)
        {
            return listData.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            if(convertView == null)
            {
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                convertView = inflater.inflate(R.layout.grid_item_bookmark, parent, false);
            }
            MyListItem data = (MyListItem)getItem(position);

            //显示数据
            TextView textView = (TextView)convertView.findViewById(R.id.id_textView);
            textView.setText(data.title);
            ImageView imageView = (ImageView)convertView.findViewById(R.id.id_imageView);
            imageView.setImageDrawable(data.icon);

            return  convertView;
        }
    }
    public void demoData()
    {
        MyListItem it = new MyListItem();
        it.title = "润华你好";
        it.website = "http://www.baidu.com";
        it.icon = getDrawable(R.drawable.ic_runhuanihao);
        listData.add(it);

        it = new MyListItem();
        it.title = "w3school";
        it.website = "http://www.w3school.com.cn";
        it.icon = getDrawable(R.drawable.ic_w3school);
        listData.add(it);

        it = new MyListItem();
        it.title = "w3school";
        it.website = "http://www.w3school.com.cn";
        it.icon = getDrawable(R.drawable.ic_w3school);
        listData.add(it);

        it = new MyListItem();
        it.title = "w3school";
        it.website = "http://www.w3school.com.cn";
        it.icon = getDrawable(R.drawable.ic_w3school);
        listData.add(it);

        it = new MyListItem();
        it.title = "w3school";
        it.website = "http://www.w3school.com.cn";
        it.icon = getDrawable(R.drawable.ic_w3school);
        listData.add(it);

        it = new MyListItem();
        it.title = "w3school";
        it.website = "http://www.w3school.com.cn";
        it.icon = getDrawable(R.drawable.ic_w3school);
        listData.add(it);

    }

    //点击事件具体实现，跳转至BrowseActivity
    public void onItemClick(int position)
    {
        MyListItem it = (MyListItem)listAdapter.getItem(position);

        //打开
        Intent intent = new Intent(this, BrowseActivity.class);
        intent.putExtra("website", it.website);
        startActivity(intent);
    }
}
