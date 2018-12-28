package com.example.huaile.marrycarrent;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SousuoActivity extends Activity {
    private TextView textView;
    private Button button;
    private EditText editText;
    private AutoCompleteTextView autoCompleteTextView;
    private static final String[] data = new String[]{"小白车", "小黑车", "小红车", "小蓝车", "小绿车"};//这里只举例说明，数据较少

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_sousuo);
       editText = (EditText) findViewById(R.id.autocomplete_country);
      autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.cc);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, data);//配置Adaptor
       autoCompleteTextView.setAdapter(adapter);

        button = (Button) findViewById(R.id.bb);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals("小白车")) {
                    Intent o = new Intent(SousuoActivity.this, XbcActivity.class);
                    startActivity(o);
                }else if(editText.getText().toString().equals("小黑车")){
                    Intent o = new Intent(SousuoActivity.this, XhcActivity.class);
                    startActivity(o);
                }
            }

        });
    }
}