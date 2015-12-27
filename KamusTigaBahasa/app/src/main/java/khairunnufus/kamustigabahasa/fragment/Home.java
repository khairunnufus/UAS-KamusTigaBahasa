package khairunnufus.kamustigabahasa.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import khairunnufus.kamustigabahasa.R;


public class Home extends Fragment{


        public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_home, container, false);

           Button btnISI = (Button)rootView.findViewById(R.id.btnISI);
           Button btnIIS = (Button)rootView.findViewById(R.id.btnIIS);
           Button btnSII = (Button)rootView.findViewById(R.id.btnSII);

            btnISI.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    IndoSundInggrisFragment frag = new IndoSundInggrisFragment();
                    FragmentManager manager = getFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    /*parameter|id layout,objek fragment, String berguna untuk findFragmentByTag()|*/
                    transaction.replace(R.id.fragment_detail, frag);
                    transaction.commit();

                }
            });
            btnIIS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    InggIndoSund frag2 = new InggIndoSund();
                    FragmentManager manager = getFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    /*parameter|id layout,objek fragment, String berguna untuk findFragmentByTag()|*/
                    transaction.replace(R.id.fragment_detail, frag2);
                    transaction.commit();

                }
            });
            btnSII.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SundIndoInggris frag3 = new SundIndoInggris();
                    FragmentManager manager = getFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    /*parameter|id layout,objek fragment, String berguna untuk findFragmentByTag()|*/
                    transaction.replace(R.id.fragment_detail, frag3);
                    transaction.commit();

                }
            });
        return rootView;
    }


}

