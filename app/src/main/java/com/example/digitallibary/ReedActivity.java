package com.example.digitallibary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;

public class ReedActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Context mContext;
    ArrayList<String> titleArrayList;
    private RecyclerView mRecycleView;
    RecyclerView recyclerView;
    DrawerLayout drawerLayout;
    public Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        mContext = ReedActivity.this;
        titleArrayList = new ArrayList<String> ();

        titleArrayList.add ( Constant.Java_Chapter1 );
        titleArrayList.add ( Constant.Java_Chapter2 );
        titleArrayList.add ( Constant.Java_Chapter3 );
        titleArrayList.add ( Constant.Java_Chapter4 );
        titleArrayList.add ( Constant.Java_Chapter5 );
        setContentView ( R.layout.activity_main );
        //navigationView=( NavigationView ) findViewById ( R.id.navbar );
        //mRecycleView = ( RecyclerView ) findViewById ( R.id.recycler );
        mRecycleView.setHasFixedSize ( true );
        mRecycleView.setLayoutManager ( new LinearLayoutManager( getApplicationContext () ) );

        TitleAdapter adapter = new TitleAdapter ( mContext, titleArrayList, new CustomItemClickListner () {
            @Override
            public void onClickItem(View v, int position) {
                Intent deIntent = new Intent ( mContext, DescriptionActivity.class );
                deIntent.putExtra ( "titles", titleArrayList.get ( position ) );
                startActivity ( deIntent );


                Toast.makeText ( mContext, "Clicked" + titleArrayList.get ( position ), Toast.LENGTH_SHORT ).show ();
            }
        } );

        mRecycleView.setAdapter ( adapter );

        navigationView.setNavigationItemSelectedListener ( new NavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId ())
                {
                    case R.id.naveHome:
                        Toast.makeText ( ReedActivity.this,"Home",Toast.LENGTH_LONG ).show ();
                        break;

                    case R.id.facebook:
                        Toast.makeText ( ReedActivity.this,"Facebook",Toast.LENGTH_LONG ).show ();
                        break;

                    case R.id.moreapp:
                        Toast.makeText ( ReedActivity.this,"More App",Toast.LENGTH_LONG ).show ();
                        break;

                    case R.id.shareapp:
                        Toast.makeText ( ReedActivity.this,"Share APP",Toast.LENGTH_LONG ).show ();
                        break;

                    case R.id.setting:
                        Toast.makeText ( ReedActivity.this,"Setting",Toast.LENGTH_LONG ).show ();
                        break;

                    case R.id.about:
                        Toast.makeText ( ReedActivity.this,"About",Toast.LENGTH_LONG ).show ();
                        break;


                }

                return false;
            }
        } );




        handleToolBar ();
    }
    void handleToolBar()
    {
        drawerLayout=(DrawerLayout ) findViewById ( R.id.drawerLayout );
        toolbar = findViewById ( R.id.toolLayout );

        setSupportActionBar (toolbar);
        actionBarDrawerToggle=new ActionBarDrawerToggle ( this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);

        drawerLayout.addDrawerListener ( actionBarDrawerToggle );
        actionBarDrawerToggle.syncState ();
    }

}