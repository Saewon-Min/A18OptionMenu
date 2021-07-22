package com.kosmo.a18optionmenu;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 레이아웃과 이미지뷰를 멤버변수로 선언
    private RelativeLayout layout;
    private ImageView imageView;
    private float rotation;
    private float scaleXY=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);
        imageView = findViewById(R.id.imageview);

    }

    // 오버라이딩1 : 옵션 메뉴를 뷰에 추가하기 위한 메소드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 리소스에 정의한 option_menu.xml을 가져와서 액티비티에 전개한다.
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // 오버라이딩2 : 옵션메뉴를 클릭했을때 이벤트 처리
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            // 옵션메뉴1~3까지는 토스트를 띄워준다.
            case R.id.optmenu_1:
                Toast.makeText(this, "옵션메뉴1선택",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.optmenu_2:
                Toast.makeText(this, "옵션메뉴2선택",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.optmenu_3:
                Toast.makeText(this, "옵션메뉴3선택",
                        Toast.LENGTH_SHORT).show();
                break;
            /*
            RGB 메뉴를 클릭하는 경우 해당 레이아웃의 배경색을 변경한다.
            */
            case  R.id.bg_red:
                layout.setBackgroundColor(Color.RED);
                break;
            case  R.id.bg_green:
                layout.setBackgroundColor(Color.GREEN);
                break;
            case  R.id.bg_blue:
                layout.setBackgroundColor(Color.BLUE);
                break;

            // 이미지의 크기, 회전에 대한 처리
            case  R.id.image_rotation:
                if(rotation==360)
                    rotation =0;
                rotation += 90; // 한번에 90도 회전
                imageView.setRotation(rotation);
                break;
            case  R.id.image_scale_inc:
                if(scaleXY!=5)
                    scaleXY+=2;
                imageView.setScaleX(scaleXY); // 2배 확대
                imageView.setScaleY(scaleXY);
                break;
            case  R.id.image_scale_desc:
                if(scaleXY > 1)
                    scaleXY-=2; // 2배 축소
                imageView.setScaleX(scaleXY);
                imageView.setScaleY(scaleXY);
                break;


        }



        return super.onOptionsItemSelected(item);
    }
}