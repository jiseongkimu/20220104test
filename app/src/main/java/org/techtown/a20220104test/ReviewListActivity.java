package org.techtown.a20220104test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ReviewListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_list);

        Button btnWrite = findViewById(R.id.review_write);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "작성하기", Toast.LENGTH_SHORT);
                toast.show();

                Intent intent = new Intent(getApplicationContext(), WriteReviewActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        CommentAdapter adapter = new CommentAdapter();

        adapter.addItem(new Comment("leejaey****", "누가 만들었나 싶을 정도로 너무 재밌다"));
        adapter.addItem(new Comment("jiseong*****", "여자랑 봤는데 너무 재밌었음(^오^)b"));
        adapter.addItem(new Comment("kimsula18****", "영화는 재밌는데 같이 본 사람이 재미없어서 실망"));
        adapter.addItem(new Comment("sangwook5***", "개쌉노잼이쥬? 이럴거면 나도 감독했지"));
        adapter.addItem(new Comment("kimsula18****", "영화는 재밌는데 같이 본 사람이 재미없어서 실망"));
        adapter.addItem(new Comment("sangwook5***", "개쌉노잼이쥬? 이럴거면 나도 감독했지"));
        adapter.addItem(new Comment("kimsula18****", "영화는 재밌는데 같이 본 사람이 재미없어서 실망"));
        adapter.addItem(new Comment("sangwook5***", "개쌉노잼이쥬? 이럴거면 나도 감독했지"));

        recyclerView.setAdapter(adapter);
    }
}