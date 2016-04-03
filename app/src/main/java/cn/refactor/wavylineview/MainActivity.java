package cn.refactor.wavylineview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

import cn.refactor.library.WavyLineView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
    }

    private void setupViews() {

        final WavyLineView wavyLineView = (WavyLineView) findViewById(R.id.wavyLineView);
        float initPeriod = (float) (2 * Math.PI / 180);
        int initAmplitude = 25;
        int initStrokeWidth = 2;
        wavyLineView.setPeriod(initPeriod);
        wavyLineView.setAmplitude(initAmplitude);
        wavyLineView.setColor(getResources().getColor(R.color.colorAccent));
        wavyLineView.setStrokeWidth(dp2px(this, initStrokeWidth));

        SeekBar amplitudeSb = (SeekBar) findViewById(R.id.sb_amplitude);
        amplitudeSb.setMax(100);
        amplitudeSb.setProgress(initAmplitude);
        amplitudeSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                wavyLineView.setAmplitude(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar periodSb = (SeekBar) findViewById(R.id.sb_period);
        periodSb.setMax(720);
        periodSb.setProgress((int) (2 * Math.PI / initPeriod));
        periodSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                wavyLineView.setPeriod((float) (2 * Math.PI / progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar widthSb = (SeekBar) findViewById(R.id.sb_width);
        widthSb.setMax(15);
        widthSb.setProgress(dp2px(this, initStrokeWidth));
        widthSb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                wavyLineView.setStrokeWidth(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public static int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
