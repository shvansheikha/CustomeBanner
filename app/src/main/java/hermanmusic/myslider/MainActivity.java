package hermanmusic.myslider;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;


public class MainActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayout linearLayout=findViewById(R.id.layout_line);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.blue_grey_400));

        SquareImageView square_1=new SquareImageView(this);
        square_1.setBackgroundColor(getResources().getColor(R.color.pink_400));

        SquareImageView square_2=new SquareImageView(this);
        square_2.setBackgroundColor(getResources().getColor(R.color.indigo_400));

        SquareImageView square_3=new SquareImageView(this);
        square_3.setBackgroundColor(getResources().getColor(R.color.teal_400));

        SquareImageView square_4=new SquareImageView(this);
        square_4.setBackgroundColor(getResources().getColor(R.color.deep_orange_400));

       /* linearLayout.addView(square_1);
        linearLayout.addView(square_2);
        linearLayout.addView(square_3);
        linearLayout.addView(square_4);
*/
       // boolean online = hostAvailable("www.google.com",80);

    }

    private boolean hostAvailable(String host,int port) {
        try (Socket socket=new Socket()){
            socket.connect(new InetSocketAddress(host,port));
            return true;
        }catch (IOException e){
            return false;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_show_list) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}