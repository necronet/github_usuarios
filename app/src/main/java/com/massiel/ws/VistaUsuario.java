package com.massiel.ws;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * Created by payerdis on 10/20/15.
 */
public class VistaUsuario extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usuarios);

        ListView lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(new UsuarioAdapter(this));
    }


    static class UsuarioAdapter extends BaseAdapter{
        Context context;

        UsuarioAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return 199;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(context).inflate(R.layout.usuarioitem,null);
            return view;
        }
    }

}
