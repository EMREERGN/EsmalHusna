package emremedia.com.esmalhsna;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by EMRE on 11.04.2018.
 */

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;


    // Resim listesi

    public int[] lst_images = {
            R.drawable.allah, //1
            R.drawable.er_rahman,   //2
            R.drawable.er_rahim,    //3
            R.drawable.el_melik,    //4
            R.drawable.el_kuddus,   //5
            R.drawable.es_selam,    //6
            R.drawable.el_mumin,    //7
            R.drawable.el_muheymin, //8
            R.drawable.el_aziz,     //9
            R.drawable.el_cebbar,
            R.drawable.el_mutekebbir,
            R.drawable.el_halik,
            R.drawable.el_bari,     //13
            R.drawable.el_musavvir,
            R.drawable.el_gaffar,
            R.drawable.el_kahhar,
            R.drawable.el_vehhab,
            R.drawable.er_rezzak,
            R.drawable.el_fettah,
            R.drawable.el_alim,
            R.drawable.el_kabid,
            R.drawable.el_basit,
            R.drawable.el_hafid,        //23
            R.drawable.er_rafi,
            R.drawable.el_muizz,
            R.drawable.el_muzill,
            R.drawable.es_semi,
            R.drawable.el_basir,
            R.drawable.el_hakem,
            R.drawable.el_adl,
            R.drawable.el_latif,
            R.drawable.el_habir,
            R.drawable.el_halim,
            R.drawable.el_azim,     //34
            R.drawable.el_gafur,
            R.drawable.es_sekur,
            R.drawable.el_aliyy,
            R.drawable.el_kebir,
            R.drawable.el_hafiz,
            R.drawable.el_mukit,
            R.drawable.el_hasib,
            R.drawable.el_celil,
            R.drawable.el_kerim,
            R.drawable.er_rakib,        //44
            R.drawable.el_mucib,
            R.drawable.el_vasi,
            R.drawable.el_hakim,
            R.drawable.el_vedud,
            R.drawable.el_mecid,
            R.drawable.el_bais,
            R.drawable.es_sehid,
            R.drawable.el_hakk,
            R.drawable.el_vekil,
            R.drawable.el_kaviyy,
            R.drawable.el_metin,
            R.drawable.el_veli,
            R.drawable.el_hamid,
            R.drawable.el_muhsi,
            R.drawable.el_mubdi,        //59
            R.drawable.el_muid,
            R.drawable.el_muhyi,
            R.drawable.el_mumit,
            R.drawable.el_hayy,
            R.drawable.el_kayyum,
            R.drawable.el_vacid,
            R.drawable.el_macid,
            R.drawable.el_vahid,    //67
            R.drawable.es_samed,
            R.drawable.el_kadir,
            R.drawable.el_muktedir,
            R.drawable.el_mukaddim,
            R.drawable.el_muahhir,
            R.drawable.el_evvel,
            R.drawable.el_ahir,
            R.drawable.ez_zahir,
            R.drawable.el_batin,        //76
            R.drawable.el_vali,
            R.drawable.el_muteali,
            R.drawable.el_berr,
            R.drawable.et_tevvab,
            R.drawable.el_muntekim,
            R.drawable.el_afuvv,
            R.drawable.er_rauf,
            R.drawable.malikul_mulk,
            R.drawable.zul_celali_vel_ikram,     //85
            R.drawable.el_muksit,
            R.drawable.el_cami,
            R.drawable.el_ganiyy,
            R.drawable.el_mugni,
            R.drawable.el_mani,
            R.drawable.ed_darr,
            R.drawable.en_nafi,
            R.drawable.en_nur,
            R.drawable.el_hadi,         //94
            R.drawable.el_bedi,
            R.drawable.el_baki,
            R.drawable.el_varis,
            R.drawable.er_resid,
            R.drawable.es_sabur         //99
    };
    // list of titles
    public String[] lst_title = {
            "Allah",
            "Er Rahman",
            "Er Rahim",
            "El Melik",
            "El Kuddüs",
            "Es Selam",
            "El Mü'min",
            "El Müheymin",
            "El Azîz",
            "El Cebbâr",
            "El Mütekebbir",
            "El Hâlık",
            "El Bâri",
            "El Musavvir",
            "El Gaffâr",
            "El Kahhâr",
            "El Vehhâb",
            "Er Rezzâk",
            "El Fettâh",
            "El Alîm",
            "El Kâbıd",
            "El Bâsıt",
            "El Hâfıd",
            "Er Râfi",
            "El Mu'ız",
            "El Müzil",
            "Es Semi",
            "El Basîr",
            "El Hakem",
            "El Adl",
            "El Latîf",
            "El Habîr",
            "El Halîm",
            "El Azîm",
            "El Gafûr",
            "Eş Şekûr",
            "El Aliyy",
            "El Kebîr",
            "El Hafîz",
            "El Mukît",
            "El Hasîb",
            "El Celîl",
            "El Kerîm",
            "Er Rakîb",
            "El Mucîb",
            "El Vâsi",
            "El Hakîm",
            "El Vedûd",
            "El Mecîd",
            "El Bâis",
            "Eş Şehîd",
            "El Hakk",
            "El Vekîl",
            "El Kaviyy",
            "El Metîn",
            "El Veliyy",
            "El Hamîd",
            "El Muhsî",
            "El Mübdi",
            "El Muîd",
            "El Muhyî",
            "El Mümît",
            "El Hayy",
            "El Kayyûm",
            "El Vâcid",
            "El Macîd",
            "El Vâhid",
            "Es Samed",
            "El Kâdir",
            "El Muktedir",
            "El Mukaddim",
            "El Muahhir",
            "El Evvel",
            "El Âhir",
            "El Zâhir",
            "El Bâtın",
            "El Vâlî",
            "El Müteâlî",
            "El Berr",
            "Et -Tevvâb",
            "El Müntekim",
            "El Afüvv",
            "Er Raûf",
            "Mâlik-ül Mülk",
            "Zü lCelâli vel ikrâm",
            "El Muksit",
            "El Câmi",
            "El Ganiyy",
            "El Mugnî",
            "El Mâni",
            "Ed Dârr",
            "En Nâfi",
            "En Nûr",
            "El Hâdî",
            "El Bedî",
            "El Bâkî",
            "El Vâris",
            "Er Reşîd",
            "Es Sabûr"
    };

    public String[] lst_description = {
            "O'nun zat ve özel ismidir. Diğer isimler, fiilleri, sıfatları ve tecellileri ile ilgilidir",
            "Dünyada bütün mahlûkata merhamet eden, şefkat gösteren, ihsan eden",
            "Ahirette, sadece müminlere acıyan, merhamet eden",
            "Çok mülkü olan, her şeyin sahibi ve Malikî, onları terbiye edip yetiştiren, mülk ve güç veren",
            "Her türlü çirkinlik, noksanlık ve ayıplardan uzak, tertemiz, bütün kemal sıfatları kendisinde toplayan, güzellik, iyilik ve faziletlerle övülen",
            "Eksiklik, acizlik, hastalık, ölüm ve benzeri şeylerden salim olan, kullarına güven ve selamet veren",
            "Yarattıklarına güven veren",
            "Her şeyi görüp gözeten",
            "İzzet sahibi, her şeye galip olan.",
            "Azamet ve kudret sahibi. Dilediğini yapan ve yaptıran.",
            "Büyüklükte eşi, benzeri olmayan.",
            "Yaratan, yoktan var eden.",
            "Her şeyi kusursuz ve uyumlu yaratan.",
            "Varlıklara şekil veren.",
            "Günahları örten ve çok mağfiret eden",
            "Her şeye, her istediğini yapacak surette, galip ve hakim olan.",
            "Karşılıksız hibeler veren, çok fazla ihsan eden.",
            "Bütün mahlükatın rızkını veren ve ihtiyacını karşılayan",
            "Her türlü müşkülleri açan ve kolaylaştıran, darlıktan kurtaran.",
            "Gizli açık, geçmiş, gelecek, her şeyi en ince detaylarına kadar bilen.",
            "Dilediğine darlık veren, sıkan, daraltan.",
            "Dilediğine bolluk veren, açan, genişleten.",
            "Dereceleri alçaltan",
            "Şeref verip yükselten",
            "Dilediğini aziz eden, izzet veren",
            "Dilediğini zillete düşüren",
            "Her şeyi en iyi işiten",
            "Gizli açık, her şeyi en iyi gören",
            "Mutlak hakim, hakkı batıldan ayıran. Hikmetle hükmeden",
            "Mutlak adil, çok adaletli",
            "Lütuf ve ihsan sahibi olan. Bütün incelikleri bilen",
            "Olmuş olacak her şeyden haberdar",
            "Cezada, acele etmeyen, yumuşak davranan",
            "Büyüklükte benzeri yok. Pek yüce",
            "Affı, mağfireti bol",
            "Az amele, çok sevap veren",
            "Yüceler yücesi, çok yüce",
            "Büyüklükte benzeri yok, pek büyük",
            "Her şeyi koruyucu olan",
            "Her yaratılmışın rızkını, gıdasını veren, tayin eden",
            "Kulların hesabını en iyi gören",
            "Celal ve azamet sahibi olan",
            "Keremi, lütuf ve ihsanı bol, karşılıksız veren, çok ikram eden",
            "Her varlığı, her işi her an görüp, gözeten, kontrolü altında tutan",
            "Duaları, istekleri kabul eden",
            "Rahmet, kudret ve ilmi ile her şeyi ihata eden",
            "Her işi hikmetli, her şeyi hikmetle yaratan.",
            "Kullarını en fazla seven, sevilmeye en layık olan",
            "Her türlü övgüye layık bulunan",
            "Ölüleri dirilten",
            "Her zaman her yerde hazır ve nazır olan",
            "Varlığı hiç değişmeden duran. Var olan, hakkı ortaya çıkaran",
            "Kendisine tevekkül edenlerin işlerini en iyi neticeye ulaştıran",
            "Kudreti en üstün ve hiç azalmaz",
            "Kuvvet ve kudret kaynağı, pek güçlü",
            "İnananların dostu, onları sevip yardım eden",
            "Her türlü hamd ve senaya layık olan",
            "Yarattığı ve yaratacağı bütün varlıkların sayısını bilen",
            "Maddesiz, örneksiz yaratan",
            "Yarattıklarını yok edip, sonra tekrar diriltecek olan",
            "İhya eden, dirilten, can veren",
            "Her canlıya ölümü tattıran",
            "Ezeli ve ebedi hayat sahib",
            "Varlıkları diri tutan, zatı ile kaim olan",
            "Kendisinden hiçbir şey gizli kalmayan, istediğini, istediği vakit bulan",
            "Kadri ve şanı büyük, keremi, ihsanı bol olan",
            "Zat, sıfat ve fiillerinde benzeri ve ortağı olmayan, tek olan",
            "Hiçbir şeye ihtiyacı olmayan, herkesin muhtaç olduğu",
            "Dilediğini dilediği gibi yaratmaya muktedir olan",
            "Dilediği gibi tasarruf eden, her şeyi kolayca yaratan kudret sahibi",
            "Dilediğini, öne alan, yükselten",
            "Dilediğini sona alan, erteleyen, alçaltan",
            "Ezeli olan, varlığının başlangıcı olmayan",
            "Ebedi olan, varlığının sonu olmayan",
            "Varlığı açık, aşikar olan, kesin delillerle bilinen",
            "Akılların idrak edemeyeceği, yüceliği gizli olan",
            "Bütün kainatı idare eden",
            "Son derece yüce olan",
            "İyilik ve ihsanı bol, iyilik ve ihsan kaynağı",
            "Tevbeleri kabul edip, günahları bağışlayan",
            "Zalimlerin cezasını veren, intikam alan",
            "Affı çok olan, günahları affetmeyi seven",
            "Çok merhametli, pek şefkatli",
            "Mülkün, her varlığın sahibi",
            "Celal, azamet ve pek büyük ikram sahibi",
            "Her işi birbirine uygun yapan",
            "Mahşerde her mahlükatı bir araya toplayan",
            "Her türlü zenginlik sahibi, ihtiyacı olmayan",
            "Müstağni kılan. ihtiyaç gideren, zengin eden",
            "Dilemediği şeye mani olan, engelleyen",
            "Elem, zarar verenleri yaratan",
            "Fayda veren şeyleri yaratan",
            "Alemleri nurlandıran, dilediğine nur veren",
            "Hidayet veren",
            "Eşi ve benzeri olmayan güzellik sahibi, eşsiz yaratan",
            "Varlığının sonu olmayan, ebedi olan",
            "Her şeyin asıl sahibi olan",
            "İrşada muhtaç olmayan, doğru yolu gösteren",
            "Ceza vermede acele etmeyen"

    };

    // list of background colors
   /* public int[]  lst_backgroundcolor = {
            Color.rgb(51, 51, 51)
    };*/

    public SlideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {

        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (ConstraintLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.slide, container, false);
        ConstraintLayout layoutslide = (ConstraintLayout) view.findViewById(R.id.slidelinearlayout);

        ImageView imgslide = (ImageView) view.findViewById(R.id.profile_image);
        TextView txttitle = (TextView) view.findViewById(R.id.txtAd);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);

        //layoutslide.setBackgroundColor( Color.rgb(51, 51, 51));
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
