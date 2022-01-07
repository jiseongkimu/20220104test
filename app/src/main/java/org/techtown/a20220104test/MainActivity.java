package org.techtown.a20220104test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
         * 해당 메소드의 인자로 레이아웃 리소스 ID를 전달(객체와-인플레이션)
         * 실행하게 되면 activity_main.xml 로 만든 레이아웃이 출력됨(뷰의 설정 배치)
         * 뒤에 findViewById()와 같은 메서드가 실행되기 위해 필수적임
         */
        setContentView(R.layout.activity_main);

        /*
         * findViewById() : ID 값을 이용해 특정 뷰를 받아오는 메서드
         * */

        /*        Button button = (Button) findViewById(R.id.buy);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });


        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.simple_list_item_1, R.id.list_id ,LIST_MENU);
        ListView listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get TextView's Text.
                String strText = (String) parent.getItemAtPosition(position) ;
                // TODO : use strText
            }
        }) ;*/

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        CommentAdapter adapter = new CommentAdapter();

        adapter.addItem(new Comment("leejaey****", "누가 만들었나 싶을 정도로 너무 재밌다"));
        adapter.addItem(new Comment("jiseong*****", "여자랑 봤는데 너무 재밌었음(^오^)b"));
        adapter.addItem(new Comment("kimsula18****", "영화는 재밌는데 같이 본 사람이 재미없어서 실망"));
        adapter.addItem(new Comment("sangwook5***","개쌉노잼이쥬? 이럴거면 나도 감독했지"));

        recyclerView.setAdapter(adapter);


    }
//    static final String[] LIST_MENU = {"kimsula18*****", "kimsula18*****"};
}