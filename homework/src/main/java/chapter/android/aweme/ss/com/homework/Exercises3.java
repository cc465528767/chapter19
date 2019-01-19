package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import chapter.android.aweme.ss.com.homework.adapter.ReAdapter;
import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.model.PullParser;
import chapter.android.aweme.ss.com.homework.widget.ChatActivity;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Message> messageList=new ArrayList<>();
    private ReAdapter reAdapter;
    private static final int NUM_LIST_ITEMS = 100;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises3);
       recyclerView =findViewById(R.id.rv_meslist);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        init();
        reAdapter=new ReAdapter(messageList);
        reAdapter.setOnItemClickListener(new ReAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent =new Intent(Exercises3.this, ChatActivity.class);
                startActivity(intent);
            }

            @Override
            public void onLongClick(int position) {

            }
        });
        recyclerView.setAdapter(reAdapter);



    }
    private void init(){
        try {
            InputStream assetInput = getAssets().open("data.xml");
             messageList = PullParser.pull2xml(assetInput);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
