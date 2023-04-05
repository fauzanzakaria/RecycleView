package com.example.recycleview.viewholder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recycleview.R;
import com.example.recycleview.adapter.ContactAdapter;
import com.example.recycleview.model.Contact;

public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    //Deklarasi sesuai item
    TextView _txNama,_txEmail;
    ImageView _foto;
    Context _context;
    Button _dell;
    ContactAdapter.OnItemClickListener listener;


    //Getter
    public TextView get_txNama() {
        return _txNama;
    }

    public TextView get_txEmail() {
        return _txEmail;
    }

    public ImageView get_foto() {
        return _foto;
    }

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        //Inisialisasi
        _context = itemView.getContext();
        _txNama = itemView.findViewById(R.id.txNama);
        _txEmail = itemView.findViewById(R.id.txEmail);
        _txEmail.setOnClickListener(this);
        _foto = itemView.findViewById(R.id.foto);
        _dell = itemView.findViewById(R.id.DelData);
        _dell.setOnClickListener(this);
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
            if(v == _dell){
                listener.onDeleteClick(getAdapterPosition());
            }else{
                //Implicit Intent
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("message/rfc822");
                Email.putExtra(Intent.EXTRA_EMAIL,
                        " " + _txEmail.getText().toString());
                Email.putExtra(Intent.EXTRA_SUBJECT, "Title");
                Email.putExtra(Intent.EXTRA_TEXT, "Email Message.");
                _context.startActivity(Email);
            }
        }
    }

