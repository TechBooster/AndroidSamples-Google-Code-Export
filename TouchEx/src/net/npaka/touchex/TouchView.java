package net.npaka.touchex;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.MotionEvent;
import android.widget.TextView;

//�^�b�`�C�x���g�̏���
public class TouchView extends View {
    private static int count = 0;
    
    //�R���X�g���N�^
    public TouchView(Context context) {
        super(context);
        setBackgroundColor(Color.WHITE);
    }
    
    //�`��
    @Override 
    protected void onDraw(Canvas canvas) {

        count++;        
        //�`��I�u�W�F�N�g�̐���
        Paint paint=new Paint(); 
        paint.setAntiAlias(true);
        paint.setTextSize(30);
        
        //�^�b�`XY���W�̕`��
        canvas.drawText("Count>"+count,0,40*1,paint);

    }
}