package com.example.recycleview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.recycleview.R;
import com.example.recycleview.model.Contact;
import com.example.recycleview.viewholder.ContactViewHolder;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    //Deklarasi
    public ArrayList<Contact> _kontakList;
    private final Context _context;

    //Constructor
    public ContactAdapter(ArrayList<Contact> _kontakList, Context _context) {
        this._kontakList = _kontakList;
        this._context = _context;
    }



    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View holder = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent, false);
        return new ContactViewHolder(holder);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

    holder.get_txNama().setText(_kontakList.get(position).getNama());
    Glide.with(_context).load(_kontakList.get(position).getFoto()).into(holder.get_foto());
    holder.get_txEmail().setText(_kontakList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return _kontakList.size();
    }

    // Method untuk menghapus data pada posisi tertentu
    public void deleteItem(int position) {
        _kontakList.remove(position);
        notifyItemRemoved(position);
    }

    // Interface untuk listener onClick tombol delete
    public interface OnItemClickListener {
        void onDeleteClick(int position);
    }
}
