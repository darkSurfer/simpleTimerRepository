package it.darksurfer.simpletimer.controllo;

import android.os.CountDownTimer;
import android.view.View;

import java.util.concurrent.TimeUnit;

import it.darksurfer.simpletimer.Applicazione;
import it.darksurfer.simpletimer.activity.ActivityPrincipale;
import it.darksurfer.simpletimer.vista.VistaPrincipale;

/**
 * Created by spinBit on 31/05/2017.
 */

public class ControlloPrincipale {
    public static final String TAG = ControlloPrincipale.class.getSimpleName();

    private View.OnClickListener azioneStart = new AzioneStart();
    private View.OnClickListener azioneStop = new AzioneStop();
    private CountDownTimer countDownTimer = null;

    private class AzioneStart implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            countDownTimer = new CountDownTimer(10000, 1) {
                ActivityPrincipale activityPrincipale = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
                VistaPrincipale vistaPrincipale = activityPrincipale.getVistaPrincipale();

                @Override
                public void onTick(long millisUntilFinished) {
                    String formattedTime = "" + String.format("%d min, %d sec",
                            TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
                            TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                    vistaPrincipale.setLabel(formattedTime);
                    vistaPrincipale.getBottoneStart().setClickable(false);
                    vistaPrincipale.getBottoneStop().setClickable(true);
                }

                @Override
                public void onFinish() {
                    vistaPrincipale.getBottoneStart().setClickable(true);
                    vistaPrincipale.getBottoneStop().setClickable(false);
                    vistaPrincipale.setLabel("Tempo scaduto");
                }
            }.start();

        }
    }

    private class AzioneStop implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            countDownTimer.cancel();
            ActivityPrincipale activityPrincipale = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
            VistaPrincipale vistaPrincipale = activityPrincipale.getVistaPrincipale();
            vistaPrincipale.getBottoneStart().setClickable(true);
            vistaPrincipale.setLabel("Stopped");
        }
    }

    public View.OnClickListener getAzioneStart() {
        return azioneStart;
    }

    public View.OnClickListener getAzioneStop() {
        return azioneStop;
    }
}
