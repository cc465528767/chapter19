package chapter.android.aweme.ss.com.homework.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.R;
import chapter.android.aweme.ss.com.homework.model.Message;

public class ReAdapter extends RecyclerView.Adapter<ReAdapter.MyViewHolder>{
    private List<Message> messageList;

    private OnItemClickListener mOnItemClickListener = null;
    static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView texttitle;
        TextView textdescription;
        TextView texttime;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.iv_avatar);
            texttitle=(TextView)itemView.findViewById(R.id.tv_title);
            textdescription=(TextView)itemView.findViewById(R.id.tv_description);
            texttime=(TextView)itemView.findViewById(R.id.tv_time);
        }
    }

    public ReAdapter(List<Message> messages){

        messageList=messages;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.im_list_item,viewGroup,false);

        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder,final int i) {
    Message message=messageList.get(i);
    if(message.getIcon().equals("TYPE_ROBOT")){
    myViewHolder.imageView.setImageResource(R.drawable.session_robot);}
    else if(message.getIcon().equals("TYPE_GAME")){
        myViewHolder.imageView.setImageResource(R.drawable.session_system_notice);
    }else if(message.getIcon().equals("TYPE_USER")){
        myViewHolder.imageView.setImageResource(R.drawable.icon_girl);
    }else if(message.getIcon().equals("TYPE_SYSTEM")){
        myViewHolder.imageView.setImageResource(R.drawable.session_system_notice);
    }
    else{
        myViewHolder.imageView.setImageResource(R.drawable.session_stranger);
    }
        myViewHolder.texttitle.setText(message.getTitle());
        myViewHolder.texttime.setText(message.getTime());
        myViewHolder.textdescription.setText(message.getDescription());
        if( mOnItemClickListener!= null){
            myViewHolder.itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(i);
                }
            });
            myViewHolder. itemView.setOnLongClickListener( new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onLongClick(i);
                    return false;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public interface OnItemClickListener{
        void onClick( int position);
        void onLongClick( int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this.mOnItemClickListener=onItemClickListener; }

}