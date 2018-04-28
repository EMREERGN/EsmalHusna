package emremedia.com.esmalhsna;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private SlideAdapter myadapter;
    private InterstitialAd mInterstitialAd;

    Vibrator vibrator;
    FloatingActionButton fab;
    TextDrawable drawable;
    ImageView image;

    boolean gecis_mi = false;
    int gecis_sayisi = 0;

    int sayfa_no = 0; // gecerli sayfanın id si
    int [ ] indisdeki_zikir_sayisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        indisdeki_zikir_sayisi=new int [99];


        //****** REKLAM AYARLARI ***************************************************************
        //MobileAds.initialize(this,"ca-app-pub-5502582458031158~7849526209");

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-5502582458031158/6898093538");  // resmi
        //mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");  // ==> test with test ads

        mInterstitialAd.loadAd(new AdRequest.Builder().build()); // test olmayan
        //mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("75EC9B35B5AA4EFC8720D9BC23E58319").build()); // test için

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build()); // diğer reklam için yükleme yapar
                //mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).addTestDevice("75EC9B35B5AA4EFC8720D9BC23E58319").build()); // test için
                if (gecis_mi) // gecis sırasında ki reklam mı
                {
                    viewPageChangeListener.onPageSelected(sayfa_no);
                    gecis_mi = false;
                } else
                    finish();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                Toast.makeText(MainActivity.this, Integer.toString(i), Toast.LENGTH_LONG).show();

            }
        });
        // *****************************************************************************************
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); // titreşim için atama

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);
        viewPager.addOnPageChangeListener(viewPageChangeListener);
        // ----------------------------------------------
        image = (ImageView) findViewById(R.id.image_view);
        drawable = TextDrawable.builder()
                .beginConfig()
                .textColor(Color.BLACK)
                .endConfig()
                .buildRound("0", Color.parseColor("#a6a6a6"));
        image.setImageDrawable(drawable);

        // ----------------------------------------------


        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) // butona tıklanma olayı
            {
                indisdeki_zikir_sayisi[sayfa_no] += 1;
                if ( indisdeki_zikir_sayisi[sayfa_no] % 10 == 0)
                    vibrator.vibrate(300);
                zikirTextAtamasi( indisdeki_zikir_sayisi[sayfa_no]);
            }
        });

    }

    @Override
    public void onBackPressed() { //m geriye basıldığı zman reklam gelecktir
        AlertDialog.Builder builder;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(MainActivity.this);
        }
        builder.setTitle("Çıkış")
                .setMessage("Çıkış Yapılsın mı ?")
                .setPositiveButton("EVET", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // eğer çıkış yapılacaksa reklam gösterilir
                        if (mInterstitialAd.isLoaded()) { // reklam yüklendiyse  eğer gösterime hazırdır
                            mInterstitialAd.show();
                        }
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


    private void zikirTextAtamasi(int zikir) {


        drawable = TextDrawable.builder()
                .beginConfig()
                .textColor(Color.BLACK)
                .endConfig()
                .buildRound(Integer.toString(zikir), Color.parseColor("#a6a6a6"));
        image.setImageDrawable(drawable);

    }

    ViewPager.OnPageChangeListener viewPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            sayfa_no = position;
            zikirTextAtamasi( indisdeki_zikir_sayisi[sayfa_no]);

            if (gecis_sayisi % 23 == 0) // 20 ve katları sayfayı gecerken reklam gelir
            {
                if (mInterstitialAd.isLoaded()) { // reklam yüklendiyse  eğer gösterime hazırdır
                    sayfa_no = position;
                    gecis_mi = true;
                    mInterstitialAd.show(); // reklam gösterilir

                }
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == ViewPager.SCROLL_STATE_SETTLING) // her sayfa yerleşince bu değer artar
                gecis_sayisi++;
        }

    };
}
