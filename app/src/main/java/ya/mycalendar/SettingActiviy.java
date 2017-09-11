package ya.mycalendar;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class SettingActiviy extends AppCompatActivity {
    // 日付設定ダイアログのインスタンスを格納する変数
    private DatePickerDialog.OnDateSetListener varDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        // エディットテキストのインスタンスを取得
        final EditText editText = (EditText) findViewById(R.id.editTextKijunBi);

        // 日付設定ダイアログに登録する
        //イベントリスナーのインスタンス化
        varDateSetListener = new DatePickerDialog.OnDateSetListener() {
            // 日付設定ダイアログの[OK]ボタンがクリックされたときの処理
            @Override
            public void onDateSet( DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // データをエディットテキストに書き込む
                editText.setText(year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
            }
         };

        ((Button)findViewById(R.id.button)) .setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                // 現在日時を取得
                Calendar calendar = Calendar.getInstance();
                // 日時設定ダイアログのインスタンスを生成
                DatePickerDialog dateDialog =
                        new DatePickerDialog(
                                SettingActiviy.this,
                                varDateSetListener,
                                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                // 日付設定ダイアログを表示
                dateDialog.show(); } });
    }
}
