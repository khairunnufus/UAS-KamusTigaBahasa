package khairunnufus.kamustigabahasa.fragment;

import android.app.Fragment;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import khairunnufus.kamustigabahasa.DatabaseHelper;
import khairunnufus.kamustigabahasa.R;

public class TambahKata extends Fragment {
    private SQLiteDatabase db = null;
    private EditText editInggris;
    private EditText editIndo2;
    private EditText editSunda;
    private DatabaseHelper datakamus ;
    public static final String INGGRIS = "inggris";
    public static final String INDONESIA = "indonesia";
    public static final String SUNDA = "SUNDA";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        datakamus = new DatabaseHelper(getActivity());
        db = datakamus.getWritableDatabase();
        android.view.View rootView = inflater.inflate(R.layout.activity_tambah_kata, container, false);
        editInggris= (EditText)rootView.findViewById(R.id.editInggris);
        editIndo2 = (EditText) rootView.findViewById(R.id.editIndo2);
        editSunda = (EditText)rootView.findViewById(R.id.editSunda);
        Button btnSimpan1 = (Button)rootView.findViewById(R.id.btnSimpan);


        btnSimpan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bhsindonesia = editIndo2.getText().toString();

                String bhssunda = editSunda.getText().toString();
                String englishword = editInggris.getText().toString();
                ContentValues cv = new ContentValues();
                cv.put(INGGRIS, englishword);
                cv.put(INDONESIA, bhsindonesia);
                cv.put(SUNDA, bhssunda);
                if(editIndo2.getText().toString().isEmpty()||editSunda.getText().toString().isEmpty()||editInggris.getText().toString().isEmpty())  {
                    Toast.makeText(getActivity(), "Isi Semua terlebih dahulu!", Toast.LENGTH_LONG).show();
                } if (db.insert("kamus", INGGRIS, cv)>0){
                    Toast.makeText(getActivity(),"Save Data Success", Toast.LENGTH_SHORT).show();
                    editInggris.setText("");
                    editSunda.setText("");
                    editIndo2.setText("");
                }
            }
        });


                    return rootView;
        }


        @Override
    public void onDestroy() {
        super.onDestroy();
        db.close();
    }
}
