package com.example.mvvmpattern.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvmpattern.R;
import com.example.mvvmpattern.model.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>{

    User[] users;


    public UserAdapter(User[] users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.user_list, parent, false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.name.setText(users[position].getLogin());
        holder.username.setText(users[position].getReposUrl());
        holder.id.setText(String.valueOf(users[position].getId()));

        Glide.with(holder.avatarImage.getContext()).load(users[position].getAvatarUrl()).into(holder.avatarImage);
    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        ImageView avatarImage;
        TextView name, username, id;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            avatarImage = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.name);
            username = itemView.findViewById(R.id.userName);
            id = itemView.findViewById(R.id.userid);


        }
    }
}
