package pbp.projectuts.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pbp.projectuts.R;
import pbp.projectuts.User;

public class UserRecyclerViewAdapter extends RecyclerView.Adapter<UserRecyclerViewAdapter.UserViewHolder> {

    private User user;
    private Context context;
    private List<User> userList;

    public UserRecyclerViewAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        user = userList.get(position);
        holder.textName.setText(user.getNama());
        holder.textTelp.setText(user.getTelp());
        holder.textHarga.setText(user.getStringHarga());
        holder.textBerat.setText(user.getStringBerat());
        holder.textTglorder.setText(user.getStringOrder());
        holder.textTglambil.setText(user.getStringAmbil());
        holder.textStatus.setText(user.getStatus());

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
    public Filter getFilter() {
        return filterUser;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textTelp, textName, textHarga, textBerat, textTglorder, textTglambil, textStatus;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textTelp = itemView.findViewById(R.id.textTelp);
            textName = itemView.findViewById(R.id.full_name);
            textHarga = itemView.findViewById(R.id.textHarga);
            textBerat = itemView.findViewById(R.id.textBerat);
            textTglambil = itemView.findViewById(R.id.textTglambil);
            textTglorder = itemView.findViewById(R.id.textTglorder);
            textStatus = itemView.findViewById(R.id.textStatus);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }

    private Filter filterUser = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<User> filterList = new ArrayList<>();

            if(charSequence == null || charSequence.length() == 0) {
                filterList.addAll(userList) ;
            }
            else {
                String pattern = charSequence.toString().toLowerCase().trim();
                for(User user : userList) {
                    if(user.getNama().toLowerCase().contains(pattern))
                        filterList.add(user);
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterList;

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            userList.clear();

            userList.addAll((List<User>) filterResults.values);
            notifyDataSetChanged();
        }
    };
}
