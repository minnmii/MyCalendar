package ya.mycalendar;
import android.widget.TextView;

/**
 * Created by shuji on 2015/11/20.
 */
public class DayTextViewInfo {

    private int textViewId = 0;					//テキストビューＩＤ
    private TextView textObject = null;			//テキストオブジェクト
    private int dayNum = 0;						//設定日付
    private boolean isNowDay = false;			//当日フラグ
    private boolean isSelected = false;			//選択フラグ

    private boolean isToubanDay = false;			//当日フラグ

    /**
     * コンストラクタ
     */
    public DayTextViewInfo(int controlId){
        this.setTextViewId(controlId);
    }

    /**
     * @return textViewId
     */
    public int getTextViewId() {
        return textViewId;
    }
    /**
     * @param textViewId セットする textViewId
     */
    public void setTextViewId(int textViewId) {
        this.textViewId = textViewId;
    }

    /**
     * textObject 取得
     * @return textObject
     */
    public TextView getTextObject() {
        return textObject;
    }
    /**
     * @param textObject 設定 textObject
     */
    public void setTextObject(TextView textObject) {
        this.textObject = textObject;
    }

    /**
     * dayNum 取得
     * @return dayNum
     */
    public int getDayNum() {
        return dayNum;
    }
    /**
     * @param dayNum 設定 dayNum
     */
    public void setDayNum(int dayNum) {
        this.dayNum = dayNum;
    }

    /**
     * isNowDay 取得
     * @return isNowDay
     */
    public boolean isNowDay() {
        return isNowDay;
    }
    /**
     * @param isNowDay 設定 isNowDay
     */
    public void setNowDay(boolean isNowDay) {
        this.isNowDay = isNowDay;
    }

    /**
     * isSelected 取得
     * @return isSelected
     */
    public boolean isSelected() {
        return isSelected;
    }
    /**
     * @param isSelected 設定 isSelected
     */
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    /**
     * 表示文字列を返す
     * @return
     */
    public String getDispString() {

        if(this.dayNum != 0) {
            return String.valueOf(this.dayNum) + "\n";
        }
        else {
            return "";

        }
    }

    /**
     * @param isToubanDay 設定 isToubanDay
     */
    public void setToubanDay(boolean isToubanDay) {
        this.isToubanDay = isToubanDay;
    }
    /**
     * isToubanDay 取得
     * @return isToubanDay
     */
    public boolean isToubanDay() {
        return isToubanDay;
    }
}
