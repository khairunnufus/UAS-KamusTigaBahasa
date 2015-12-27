package khairunnufus.kamustigabahasa.fragment;

import android.app.Fragment;
import android.database.Cursor;
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

public class InggIndoSund extends Fragment {
    private SQLiteDatabase db = null;
    private Cursor kamusCursor = null;
    private EditText editInggris2;
    private EditText editIndo2;
    private EditText editSunda;
    private DatabaseHelper datakamus;
    public static final String INGGRIS = "inggris";
    public static final String INDONESIA = "indonesia";
    public static final String SUNDA = "sunda";


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        datakamus = new DatabaseHelper(getActivity());
        db = datakamus.getWritableDatabase();
        android.view.View rootView = inflater.inflate(R.layout.activity_ingg_indo_sund, container, false);
        final EditText editInggris = (EditText) rootView.findViewById(R.id.editInggris);
        final EditText editIndo2 = (EditText) rootView.findViewById(R.id.editText);
        final EditText editSunda = (EditText) rootView.findViewById(R.id.editText2);
        Button btnterjemah1 = (Button) rootView.findViewById(R.id.btnterjemah1);
        btnterjemah1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bhsindonesia = "";
                String bhssunda = "";
                String englishword = editInggris.getText().toString();
                kamusCursor = db.rawQuery("SELECT _ID, INGGRIS, INDONESIA, SUNDA "
                        + "FROM kamus where INGGRIS='" + englishword
                        + "' ORDER BY INGGRIS", null);
                if (kamusCursor.moveToFirst()) {
                    for (; !kamusCursor.isAfterLast();
                         kamusCursor.moveToNext()) {
                        bhsindonesia = kamusCursor.getString(2);
                        bhssunda = kamusCursor.getString(3);
                    }
                } else {
                    Toast.makeText(getActivity(), "Terjemahan Tidak ditemukan", Toast.LENGTH_SHORT).show();
                }
                editIndo2.setText(bhsindonesia);
                editSunda.setText(bhssunda);
            }


        });

        return rootView;
    }
    public void onDestroy() {
        super.onDestroy();
        try {
            kamusCursor.close();
            db.close();
        } catch (Exception e) {
        }
    }
}
