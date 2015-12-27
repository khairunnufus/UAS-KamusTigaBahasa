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

public class IndoSundInggrisFragment extends Fragment {
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
        View rootView = inflater.inflate(R.layout.activity_indo_sund_inggris_fragment, container, false);

        final EditText editInggris2 = (EditText) rootView.findViewById(R.id.editInggris2);
        final EditText editIndo2 = (EditText) rootView.findViewById(R.id.editIndo2);
        final EditText editSunda = (EditText) rootView.findViewById(R.id.editSunda);
        Button button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bhsinggris = "";
                String bhssunda = "";
                String indoword = editIndo2.getText().toString().toLowerCase();
                kamusCursor = db.rawQuery("SELECT _ID,  INDONESIA, SUNDA, INGGRIS "
                        + "FROM kamus where INDONESIA='" + indoword
                        + "' ORDER BY INDONESIA", null);
                if (kamusCursor.moveToFirst()) {
                    for (; !kamusCursor.isAfterLast();
                         kamusCursor.moveToNext()) {
                        bhsinggris = kamusCursor.getString(2);
                        bhssunda = kamusCursor.getString(3);
                    }
                } else {

                    Toast.makeText(getActivity(), "Terjemahan Tidak Ditemukan", Toast.LENGTH_SHORT).show();
                }
                editSunda.setText(bhssunda);
                editInggris2.setText(bhsinggris);
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







