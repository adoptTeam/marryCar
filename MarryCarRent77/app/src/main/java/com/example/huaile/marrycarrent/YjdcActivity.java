package com.example.huaile.marrycarrent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YjdcActivity extends Activity implements OnItemClickListener {
    List<Map<String,Object>>data =new ArrayList();
    List<Map<String,Object>> cdata =new ArrayList();
    ListView lv;
    TextView tv;
    Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yjdc);
        lv=(ListView) findViewById(R.id.listView1);
        tv=(TextView) findViewById(R.id.totalPrice);
        bt=(Button) findViewById(R.id.payBt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(YjdcActivity.this,SubmitActivity.class);
                startActivity(i);
            }
        });
        initData();
        initLv();
    }

    private void initLv() {
        ShopAdapter sa = new ShopAdapter(this,data,R.layout.activity_shop_adapter);
        lv.setAdapter(sa);
        lv.setOnItemClickListener(this);
    }

    private void initData() {
        for (int i = 1; i <3; i++) {
            Map<String,Object> item =new HashMap();
            item.put("id", i);
            item.put("img", R.drawable.c1+i);
            item.put("name","物品"+i);
            item.put("price", 10010f+500*i);
            item.put("count", 1);
            data.add(item);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        Map item = data.get(arg2);
        Log.i("Msg", "arg0="+arg0.getClass() +"  ,arg1="+arg1.getClass());
        CheckBox box =(CheckBox) arg1.findViewById(R.id.lv_item_check);
        if(cdata.contains(item)){
            cdata.remove(item);
            box.setChecked(false);
        }else{
            cdata.add(item);
            box.setChecked(true);
        }
        sumPrice();
    }
    public void sumPrice(){
        float sum=0;
        for(Map<String,Object> item : cdata){
            sum+=(Float)item.get("price")*(Integer)item.get("count");
        }
        tv.setText("总价：￥ "+sum);
    }
}
