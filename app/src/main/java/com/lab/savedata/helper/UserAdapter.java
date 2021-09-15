package com.lab.savedata.helper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lab.savedata.model.User;
import com.lab.savedata.R;
import com.lab.savedata.model.User;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;

    public static class UserViewHolder extends RecyclerView.ViewHolder {

        public TextView nameText, ageText, addressText;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.nameTextCard);
            ageText = itemView.findViewById(R.id.ageTextCard);
            addressText = itemView.findViewById(R.id.addressTextCard);
        }
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        UserViewHolder animeViewHolder = new UserViewHolder(v);

        return animeViewHolder;
    }

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.UserViewHolder holder, int position) {
        User currentUser = userList.get(position);

        holder.nameText.setText(currentUser.getName());
        holder.ageText.setText(currentUser.getAge());
        holder.addressText.setText(currentUser.getAddress());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}