package org.techtown.a20220104test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/*
* 리사이클러뷰는 선택 위젯이기 때문에 어댑터가 데이터 관리와 뷰 객체 관리를 담당한다.
* 리스트 형태로 보일 때 각각의 아이템은 뷰로 만들어지며 각각의 아이템을 위한 뷰는 뷰홀더에 담아둔다.
* 반드시 구현 되어야 하는 메서드가 3개 있다.
* */

public class CommentAdapter extends  RecyclerView.Adapter<CommentAdapter.ViewHolder>{
    ArrayList<Comment> items = new ArrayList<Comment>();

    /*
    * 뷰홀더가 새로 만들어지는 시점에 호출된다.
    * 각 아이템을 위해 정의한 XML 레이아웃을 이용해 뷰 객체(인플레이션)를 만들어 새로 만든 뷰홀더 객체에 담아 반환한다.
    *
    * 인플레이션을 진행하기 위해선 Context 객체가 필요한데 파라미터로 전달되는 뷰그룹 객체의 getContext()를 이용하여 참조한다.
    * */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemview = inflater.inflate(R.layout.simple_list_item_1, parent, false);

        return new ViewHolder(itemview);
    }

    /*
    * 뷰홀더 객체가 재사용될 때 호출된다.
    * 객체는 기존 것을 그대로 사용하고 데이터만 바꿔준다.
    * 뷰 타입을 위한 정수값이 파라미터로 전달된다.
    * 아이템을 위한 뷰를 여러가지(이미지, 텍스트 등)로 보여주고 싶을 때 뷰 타입을 정하고 각각의 뷰타입에 따라 다른 XML 레이아웃을 인플레이션 하여 보여줄 수 있다.
    *
    * 재활용할 수 있는 뷰홀더 객체를 파라미터로 전달하기 때문에 현재 아이템에 맞는 데이터만 설정한다.
    * 데이터는 Comment 객체로 만드는데 클래스 안에 ArrayList 자료형으로 된 변수를 만들어 position 파라미터를 이용해 ArrayList 에서 Comment 객체를 꺼내 설정할 수 있다.
    * 그러기 위해선 전체 아이템 개수를 알아야 하므로 getItemCount() 메서드는 ArrayList 의 size() 를 호출하여 확인 후 그 값을 반환한다.
    * */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Comment item = items.get(position);
        holder.setItem(item);
            }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView id;
        TextView reply;
        TextView time;

        /*
        * 생성자에는 뷰 객체가 전달된다. 그리고 전달 받은 이 객체를 부모 클래스의 변수에 담아두게 되는데 생성자 안에서 super() 메서드를 호출한다.
        * 그리고 전달받은 뷰 객체의 이미지나 텍스트를 findViewById() 로 찾아 변수에 할당하면 setItem() 으로 참조할 수 있다.
        * setItem() 은 이 뷰홀더에 들어있는 뷰 객체의 데이터를 다른 것으로 보이도록 하는 역할을 한다.
        * */
        ViewHolder(View itemView){
            super(itemView);

            id = itemView.findViewById(R.id.list_id);
            reply = itemView.findViewById(R.id.list_content);
            time = itemView.findViewById(R.id.list_time);
        }

        public void setItem(Comment item){
            id.setText(item.getId());
            reply.setText(item.getReply());
            time.setText(item.getTime());
        }
    }
    public void addItem(Comment item){
        items.add(item);
    }

    public void setItems(ArrayList<Comment> items){
        this.items = items;
    }

    public Comment getItem(int position){
        return items.get(position);
    }

    public void setItem(int position, Comment item){
        items.set(position, item);
    }
}
