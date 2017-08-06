package com.tweekerz.dtmfbuzzer;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * Created by Koustuv Ganguly on 05-Aug-17.
 */

public class Act1 extends AppCompatActivity {

    private ImageButton mBuzzer;
    private Button mD1;
    private Button mD2;
    private Button mD3;
    private Button mD4;
    private Button mD5;
    private Button mD6;
    private Button mD7;
    private Button mD8;
    private Button mD9;
    private int mSoundConst = 1;
    private ToneGenerator mToneGenerator;
    private boolean mIsBuzzing = false;
    private CountDownTimer mCountDownTimer;
    private LinearLayout mLl1;
    private Button mCurrentBtn;

    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.act1_lyt1);
            initView();
            initListener();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initListener() {
        try {
            mD1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mSoundConst = 1;
                    mCurrentBtn = (Button) view;
                    mLl1.setBackground(mCurrentBtn.getBackground());
                }
            });
            mD2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mSoundConst = 2;
                    mCurrentBtn = (Button) view;
                    mLl1.setBackground(mCurrentBtn.getBackground());
                }
            });
            mD3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mSoundConst = 3;
                    mCurrentBtn = (Button) view;
                    mLl1.setBackground(mCurrentBtn.getBackground());
                }
            });
            mD4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mSoundConst = 4;
                    mCurrentBtn = (Button) view;
                    mLl1.setBackground(mCurrentBtn.getBackground());
                }
            });
            mD5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mSoundConst = 5;
                    mCurrentBtn = (Button) view;
                    mLl1.setBackground(mCurrentBtn.getBackground());
                }
            });
            mD6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mSoundConst = 6;
                    mCurrentBtn = (Button) view;
                    mLl1.setBackground(mCurrentBtn.getBackground());
                }
            });
            mD7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mSoundConst = 7;
                    mCurrentBtn = (Button) view;
                    mLl1.setBackground(mCurrentBtn.getBackground());
                }
            });
            mD8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mSoundConst = 8;
                    mCurrentBtn = (Button) view;
                    mLl1.setBackground(mCurrentBtn.getBackground());
                }
            });
            mD9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mSoundConst = 9;
                    mCurrentBtn = (Button) view;
                    mLl1.setBackground(mCurrentBtn.getBackground());
                }
            });
            mBuzzer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        if (!mIsBuzzing) {
                            if (mCountDownTimer != null)
                                mCountDownTimer.start();
                            mIsBuzzing = true;
                        } else {
                            mIsBuzzing = false;
                            if (mCountDownTimer != null)
                                mCountDownTimer.cancel();
                            mBuzzer.setBackground(ContextCompat.getDrawable(Act1.this, R.drawable.icon_buzzer));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
            mCountDownTimer = new CountDownTimer(840000, 2000) {
                @Override
                public void onTick(long l) {
                    try {
                        mToneGenerator.stopTone();
                        mBuzzer.setBackground(ContextCompat.getDrawable(Act1.this, R.drawable.icon_green));
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    mBuzzer.setBackground(ContextCompat.getDrawable(Act1.this, R.drawable.icon_buzzer));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 400);
                        mToneGenerator.startTone(mSoundConst, 400);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    mBuzzer.setBackground(ContextCompat.getDrawable(Act1.this, R.drawable.icon_green));
                                    mToneGenerator.startTone(mSoundConst, 400);
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                mBuzzer.setBackground(ContextCompat.getDrawable(Act1.this, R.drawable.icon_buzzer));
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }, 400);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 1200);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFinish() {
                    try {
                        mToneGenerator.stopTone();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initView() {
        try {
            mBuzzer = (ImageButton) findViewById(R.id.buttonBuzzer);
            mD1 = (Button) findViewById(R.id.button1);
            mD2 = (Button) findViewById(R.id.button2);
            mD3 = (Button) findViewById(R.id.button3);
            mD4 = (Button) findViewById(R.id.button4);
            mD5 = (Button) findViewById(R.id.button5);
            mD6 = (Button) findViewById(R.id.button6);
            mD7 = (Button) findViewById(R.id.button7);
            mD8 = (Button) findViewById(R.id.button8);
            mD9 = (Button) findViewById(R.id.button9);
            mCurrentBtn = mD1;
            if (mToneGenerator == null)
                mToneGenerator = new ToneGenerator(AudioManager.STREAM_DTMF, 100);
            mLl1 = (LinearLayout) findViewById(R.id.ll1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        try {
            super.onStart();
            if (mToneGenerator == null)
                mToneGenerator = new ToneGenerator(AudioManager.STREAM_DTMF, 100);
            mIsBuzzing = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        try {
            super.onStop();
            if (mToneGenerator != null) {
                mToneGenerator.stopTone();
                if (this.isFinishing())
                    mToneGenerator.release();
                mIsBuzzing = false;
            }
            if (mCountDownTimer != null)
                mCountDownTimer.cancel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        try {
            super.onDestroy();
            if (mToneGenerator != null) {
                mToneGenerator.stopTone();
                if (this.isFinishing())
                    mToneGenerator.release();
                mIsBuzzing = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        try {
            super.onPause();
            if (mToneGenerator != null) {
                mToneGenerator.stopTone();
                if (this.isFinishing())
                    mToneGenerator.release();
                mIsBuzzing = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
    @Override
    protected void onResume() {
        super.onResume();
        if (mToneGenerator == null)
            mToneGenerator = new ToneGenerator(AudioManager.STREAM_DTMF, 100);
        mIsBuzzing = false;
    }
}
