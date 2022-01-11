package org.techtown.a20220104test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int int_upCount = 15;
    int int_downCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
         * 해당 메소드의 인자로 레이아웃 리소스 ID를 전달(객체와-인플레이션)
         * 실행하게 되면 activity_main.xml 로 만든 레이아웃이 출력됨(뷰의 설정 배치)
         * 뒤에 findViewById()와 같은 메서드가 실행되기 위해 필수적임
         */
        setContentView(R.layout.activity_main);


        //findViewById() : ID 값을 이용해 특정 뷰를 받아오는 메서드
        TextView upCount = (TextView) findViewById(R.id.up_count);
        TextView downCount = (TextView) findViewById(R.id.down_count);
        Button btn_write = (Button) findViewById(R.id.review_write);
        Button btn_seeAll = (Button) findViewById(R.id.see_all);
        ImageButton btn_like = (ImageButton) findViewById(R.id.thumb_up);
        ImageButton btn_dislike = (ImageButton) findViewById(R.id.thumb_down);

        upCount.setText(int_upCount + "");
        downCount.setText(int_downCount + "");


        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "작성하기 버튼이 눌렸습니다", Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(getApplicationContext(), WriteReviewActivity.class);
                startActivity(intent);
            }
        });

        btn_seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "모두보기 버튼이 눌렸습니다", Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(getApplicationContext(), ReviewListActivity.class);
                startActivity(intent);

            }
        });

        btn_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn_dislike.isActivated()) {
                    btn_dislike.setActivated(false);
                    int_downCount--;
                    btn_like.setActivated(!btn_like.isActivated());
                    int_upCount++;
                    upCount.setText(int_upCount + "");
                    downCount.setText(int_downCount + "");

                } else if (btn_like.isActivated()) {
                    btn_like.setActivated(false);
                    int_upCount--;
                    upCount.setText(int_upCount + "");
                } else {
                    btn_like.setActivated(!btn_like.isActivated());
                    int_upCount++;
                    upCount.setText(int_upCount + "");
                }
            }
        });

        btn_dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn_like.isActivated()) {
                    btn_like.setActivated(false);
                    int_upCount--;
                    btn_dislike.setActivated(!btn_dislike.isActivated());
                    int_downCount++;
                    downCount.setText(int_downCount + "");
                    upCount.setText(int_upCount + "");
                } else if (btn_dislike.isActivated()) {
                    btn_dislike.setActivated(false);
                    int_downCount--;
                    downCount.setText(int_downCount + "");
                } else {
                    btn_dislike.setActivated(!btn_dislike.isActivated());
                    int_downCount++;
                    downCount.setText(int_downCount + "");
                }
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        CommentAdapter adapter = new CommentAdapter();

        adapter.addItem(new Comment("leejaey****", "누가 만들었나 싶을 정도로 너무 재밌다"));
        adapter.addItem(new Comment("jiseong*****", "여자랑 봤는데 너무 재밌었음(^오^)b"));
        adapter.addItem(new Comment("kimsula18****", "영화는 재밌는데 같이 본 사람이 재미없어서 실망"));
        adapter.addItem(new Comment("ssdfsdf*", "개쌉노잼이쥬? 이럴거면 나도 감독했지"));
        adapter.addItem(new Comment("sasdfsdf***", "개쌉노잼이쥬? 이럴거면 나도 감독했지"));

        recyclerView.setAdapter(adapter);


    }
}