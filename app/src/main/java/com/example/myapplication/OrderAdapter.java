package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    private Context context;
    private ArrayList name, email, mobileNo, address, amount, quantity;
    private Button btnOrdDone;

    public OrderAdapter(Context context, ArrayList<String> name, ArrayList<String> email, ArrayList<String> mobileNo, ArrayList<String> address,
                        ArrayList<String> amount, ArrayList<String> quantity) {
        this.context = context;
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
        this.address = address;
        this.amount = amount;
        this.quantity = quantity;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.orderadded, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        holder.tvName.setText(String.valueOf(name.get(position)));
        holder.tvEmail.setText(String.valueOf(email.get(position)));
        holder.tvMobileNo.setText(String.valueOf(mobileNo.get(position)));
        holder.tvAddress.setText(String.valueOf(address.get(position)));
        holder.tvAmount.setText(String.valueOf(amount.get(position)));
        holder.tvQuantity.setText(String.valueOf(quantity.get(position)));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvEmail, tvMobileNo, tvAddress, tvAmount, tvQuantity;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.name);
            tvEmail = itemView.findViewById(R.id.email);
            tvMobileNo = itemView.findViewById(R.id.MobileNO);
            tvAddress = itemView.findViewById(R.id.address);
            tvAmount = itemView.findViewById(R.id.amount);
            tvQuantity = itemView.findViewById(R.id.quantity);
        }
    }
}
