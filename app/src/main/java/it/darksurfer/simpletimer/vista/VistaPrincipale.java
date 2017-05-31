package it.darksurfer.simpletimer.vista;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import it.darksurfer.simpletimer.Applicazione;
import it.darksurfer.simpletimer.R;

public class VistaPrincipale extends Fragment {
    private TextView label;
    private Button bottoneStart;
    private Button bottoneStop;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_principale, container, false);
        this.label = (TextView) vista.findViewById(R.id.label);
        this.bottoneStart = (Button) vista.findViewById(R.id.bottoneStart);
        this.bottoneStop = (Button) vista.findViewById(R.id.bottoneStop);
        bottoneStart.setOnClickListener(Applicazione.getInstance().getControlloPrincipale().getAzioneStart());
        bottoneStop.setOnClickListener(Applicazione.getInstance().getControlloPrincipale().getAzioneStop());
        bottoneStop.setClickable(false);
        return vista;
    }

    public void setLabel(String s) {
        this.label.setText(s);
    }

    public TextView getLabel() {
        return label;
    }

    public Button getBottoneStart() {
        return bottoneStart;
    }

    public Button getBottoneStop() {
        return bottoneStop;
    }
}