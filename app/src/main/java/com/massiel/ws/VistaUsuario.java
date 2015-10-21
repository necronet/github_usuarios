package com.massiel.ws;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

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


        //https://api.github.com/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubService service = retrofit.create(GitHubService.class);

        service.usuario().enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Response<Usuario> response, Retrofit retrofit) {
                Usuario usuario = response.body();
                Log.d("DEBUG", "Usuarios " + usuario.getAvatar());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("DEBUG", t.getMessage());
            }
        });
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
