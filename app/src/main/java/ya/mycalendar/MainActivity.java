package ya.mycalendar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends Activity{//implements View.OnClickListener {
    private Button nextMonthButton = null;				//次の月へボタン
    private Button previousMonthButton = null;			//前の月へボタン
    private TextView headerMonthText = null;			//年月表示テキストビュー

    private int currentYear = 0;						//現在表示中の年
    private int currentMonth = 0;						//現在表示中の月

    private int nowYear = 0;							//現在の年
    private int nowMonth = 0;							//現在の月
    private int nowDay = 0;								//現在の日

    // X軸最低スワイプ距離
    private static final int SWIPE_MIN_DISTANCE = 50;
    // X軸最低スワイプスピード
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    // Y軸の移動距離　これ以上なら横移動を判定しない
    private static final int SWIPE_MAX_OFF_PATH = 250;
    // タッチイベントを処理するためのインタフェース
    private GestureDetector mGestureDetector;


    //日表示テキスト情報リスト
    private ArrayList<DayTextViewInfo> dayTextList = new ArrayList<DayTextViewInfo>();
    /**
     * 各コントロール初期化
     */
    private void initializeControl() {

        this.nextMonthButton = (Button)findViewById(R.id.next_month_id);
        //this.nextMonthButton.setOnClickListener(this);
        this.nextMonthButton.setOnClickListener(new ButtonClickListener());
        this.previousMonthButton = (Button)findViewById(R.id.previous_month_button);
        //this.previousMonthButton.setOnClickListener(this);
        this.previousMonthButton.setOnClickListener(new ButtonClickListener());

        this.headerMonthText = (TextView)findViewById(R.id.header_month_text);

        DayTextViewInfo info = null;

        info = new DayTextViewInfo(R.id.one_su_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.one_mo_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.one_tu_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.one_we_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.one_th_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.one_fr_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.one_sa_text);
        this.dayTextList.add(info);

        info = new DayTextViewInfo(R.id.tow_su_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.tow_mo_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.tow_tu_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.tow_we_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.tow_th_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.tow_fr_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.tow_sa_text);
        this.dayTextList.add(info);

        info = new DayTextViewInfo(R.id.three_su_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.three_mo_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.three_tu_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.three_we_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.three_th_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.three_fr_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.three_sa_text);
        this.dayTextList.add(info);

        info = new DayTextViewInfo(R.id.four_su_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.four_mo_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.four_tu_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.four_we_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.four_th_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.four_fr_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.four_sa_text);
        this.dayTextList.add(info);

        info = new DayTextViewInfo(R.id.five_su_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.five_mo_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.five_tu_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.five_we_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.five_th_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.five_fr_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.five_sa_text);
        this.dayTextList.add(info);

        info = new DayTextViewInfo(R.id.six_su_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.six_mo_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.six_tu_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.six_we_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.six_th_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.six_fr_text);
        this.dayTextList.add(info);
        info = new DayTextViewInfo(R.id.six_sa_text);
        this.dayTextList.add(info);

        setNowYMD();


        setWeekEndColor();
        /*
        int id = 0;
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 7 ; j++){
                TextView tv = (TextView)findViewById(this.dayTextList.get(id).getTextViewId());
                tv.setOnClickListener(this);
                tv.setBackgroundResource(R.drawable.text_day_line);
                if(j == 0) {
                    //日曜日
                    tv.setTextColor(Color.RED);
                }
                if(j == 6) {
                    //土曜日
                    tv.setTextColor(Color.BLUE);
                }

                this.dayTextList.get(id).setTextObject(tv);
                id++;
            }
        }
        */


        this.SetCalendar(0);
    }
    /**
     * 現在の年月日を取得
     */
    private void setNowYMD() {
        Calendar cal1 = Calendar.getInstance();  			//(1)オブジェクトの生成

        this.currentYear = cal1.get(Calendar.YEAR);        //(2)現在の年を取得
        this.currentMonth = cal1.get(Calendar.MONTH) + 1;  //(3)現在の月を取得

        this.nowYear = this.currentYear;
        this.nowMonth = this.currentMonth;
        this.nowDay = cal1.get(Calendar.DATE);         		//(4)現在の日を取得


    }

   /**
     * カレンダー再描画
     */
    private void SetCalendar(int offset) {
        this.currentMonth += offset;

        if(currentMonth > 12){
            this.currentYear += 1;
            this.currentMonth = 1;
        }
        else if(currentMonth == 0){
            this.currentMonth = 12;
            this.currentYear -= 1;
        }

        //テキスト表示情報初期化
        for(int i = 0 ; i < this.dayTextList.size(); i++) {
            DayTextViewInfo tg = this.dayTextList.get(i);
            if(tg.isNowDay() || tg.isSelected() ) {
                tg.getTextObject().setBackgroundResource(R.drawable.text_day_line);
            }

            tg.setNowDay(false);
            tg.setDayNum(0);
            tg.setSelected(false);
            tg.getTextObject().setText(tg.getDispString());
        }

        //カレンダーテーブル作成
        CalendarInfo cl = new CalendarInfo(currentYear, currentMonth);

        //当番日計算
        Calendar clKijunBi = Calendar.getInstance();
        clKijunBi.clear();
        clKijunBi.set(2016,2-1,10); //月は0が1月のパラメーター
        Calendar clTukiShonichi = Calendar.getInstance();
        clTukiShonichi.clear();
        clTukiShonichi.set(currentYear,currentMonth-1,1);
        //日付の大小比較
        int diff;
        int sa = clKijunBi.compareTo(clTukiShonichi);
        if (sa == 0) {
            diff = getDiffDays(clTukiShonichi,clKijunBi);
        } else if (sa > 0) {
            diff = getDiffDays(clTukiShonichi,clKijunBi);
        } else {
            diff = getDiffDays(clKijunBi,clTukiShonichi);
        }

        if(diff<0){
            diff = diff*-1;
        }
        int mod = diff % 3;
        /*if(mod<0){
            mod = mod * -1;
        }*/

        int row = 0;
        int col = 0;
        for(int i = 0 ; i < this.dayTextList.size(); i++) {
            DayTextViewInfo tg = this.dayTextList.get(i);

            if(cl.calendarMatrix[row][col] != 0) {
                // 日付表示
                tg.setDayNum(cl.calendarMatrix[row][col]);
                tg.getTextObject().setText(tg.getDispString());
                if(this.nowYear == this.currentYear
                        && this.nowMonth == this.currentMonth
                        && cl.calendarMatrix[row][col] == nowDay) {

                  //  当日日付表示
                    this.dayTextList.get(i).setNowDay(true);
                    tg.getTextObject().setBackgroundResource(R.drawable.text_now_line);
                }

                //当番判定
                TextView tv = (TextView)findViewById(this.dayTextList.get(i).getTextViewId());
                tg.setToubanDay(false);
                if(mod ==0){
                    tg.setToubanDay(true);
                    //当番日
                    tv.setTextColor(Color.CYAN);
                }else{
                    tv.setTextColor(Color.GRAY);
                }
                if(mod < 3 - 1){mod++;}else {mod =0;}
            }

            col += 1;
            if(col == 7){
                row += 1;
                col = 0;
            }
        }

        //土日の色変え
        setWeekEndColor();

        //年月表示
        this.headerMonthText.setText(String.valueOf(this.currentYear)
                + "年" + String.valueOf(this.currentMonth) + "月" );
    }

    /**
     * 経過日数を取得する。
     */
    int getDiffDays(Calendar calendar1, Calendar calendar2) {
        //==== ミリ秒単位での差分算出 ====//
        long diffTime = calendar1.getTimeInMillis() - calendar2.getTimeInMillis();

        //==== 日単位に変換 ====//
        int MILLIS_OF_DAY = 1000 * 60 * 60 * 24;
        int diffDays = (int)(diffTime / MILLIS_OF_DAY);

        return diffDays;
    }

    /**
     * 土日の色を変える。
     */
    private void setWeekEndColor(){
        int id = 0;
        for (int i = 0; i < 6; i++) {

            for (int j = 0; j < 7; j++) {
                TextView tv = (TextView) findViewById(this.dayTextList.get(id).getTextViewId());
                //tv.setOnClickListener(new ButtonClickListener());
                tv.setBackgroundResource(R.drawable.text_day_line);
                if (j == 0 &! this.dayTextList.get(i).isToubanDay() &! this.dayTextList.get(i).isToubanDay()) {
                    //日曜日
                    tv.setTextColor(Color.RED);
                }
                if (j == 6 &! this.dayTextList.get(i).isToubanDay() &! this.dayTextList.get(i).isToubanDay()) {
                    //土曜日
                    tv.setTextColor(Color.BLUE);
                }

                this.dayTextList.get(id).setTextObject(tv);
                id++;
            }
        }
    }

   /*@Override
   public void onClick(View v) {
       // TODO 自動生成されたメソッド・スタブ
       if(v.getId() == R.id.next_month_id) {
           this.SetCalendar(+1);
       }
       else if(v.getId() == R.id.previous_month_button) {
           this.SetCalendar(-1);
       }
       else
       {
           for(int i = 0 ; i < this.dayTextList.size(); i++) {
               if(this.dayTextList.get(i).getTextViewId() == v.getId()) {
                   this.dayTextList.get(i).getTextObject().setBackgroundResource(R.drawable.text_selected_line);
                   this.dayTextList.get(i).setSelected(true);
               }
               else {
                   if(this.dayTextList.get(i).isNowDay() == true) {
                       this.dayTextList.get(i).getTextObject().setBackgroundResource(R.drawable.text_now_line);
                       this.dayTextList.get(i).setSelected(false);
                   }
                   else if(this.dayTextList.get(i).isSelected()) {
                       this.dayTextList.get(i).getTextObject().setBackgroundResource(R.drawable.text_day_line);
                       this.dayTextList.get(i).setSelected(false);
                   }
               }
           }
       }

   }*/

    private final GestureDetector.SimpleOnGestureListener mOnGestureListener = new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX, float velocityY) {

            try {

                if (Math.abs(event1.getY() - event2.getY()) > SWIPE_MAX_OFF_PATH) {
                    // 縦の移動距離が大きすぎる場合は無視
                    return false;
                }

                if (event1.getX() - event2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    // 開始位置から終了位置の移動距離が指定値より大きい
                    // X軸の移動速度が指定値より大きい"右から左"
                    SetCalendar(+1);
                } else if (event2.getX() - event1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    // 終了位置から開始位置の移動距離が指定値より大きい
                    // X軸の移動速度が指定値より大きい"左から右"
                    SetCalendar(-1);
                }

            } catch (Exception e) {
                // nothing
            }
            return false;
        }
    };

    // これがないとGestureDetectorが動かない
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mGestureDetector = new GestureDetector(this, mOnGestureListener);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        //初期化
        initializeControl();
    }

    //ボタンのリスナクラス
    class ButtonClickListener implements View.OnClickListener{
        public void onClick(View v){
            // TODO 自動生成されたメソッド・スタブ
            if(v.getId() == R.id.next_month_id) {
                SetCalendar(+1);
            }
            else if(v.getId() == R.id.previous_month_button) {
                SetCalendar(-1);
            }
            else
            {
                for(int i = 0 ; i < dayTextList.size(); i++) {
                    if(dayTextList.get(i).getTextViewId() == v.getId()) {
                        dayTextList.get(i).getTextObject().setBackgroundResource(R.drawable.text_selected_line);
                        dayTextList.get(i).setSelected(true);
                    }
                    else {
                        if(dayTextList.get(i).isNowDay() == true) {
                            dayTextList.get(i).getTextObject().setBackgroundResource(R.drawable.text_now_line);
                            dayTextList.get(i).setSelected(false);
                        }
                        else if(dayTextList.get(i).isSelected()) {
                            dayTextList.get(i).getTextObject().setBackgroundResource(R.drawable.text_day_line);
                            dayTextList.get(i).setSelected(false);
                        }
                    }
                }
            }

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        //return true;
        menu.add(Menu.NONE,0,0,"設定");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*// Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        */
        switch(item.getItemId()){
            case 0:
                Intent it = new Intent(getApplicationContext(),SettingActiviy.class);
                startActivityForResult(it, 1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
