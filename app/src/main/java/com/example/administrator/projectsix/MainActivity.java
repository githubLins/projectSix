package com.example.administrator.projectsix;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        TextView textView = (TextView) findViewById(R.id.textview1);
        registerForContextMenu(textView);}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_another:
                Toast.makeText(this, "其他", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(this, "新建", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_cannel:
                Toast.makeText(this, "取消", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateContextMenu(menu, view, menuInfo);
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_content, menu);

        }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_content1:
                Toast.makeText(MainActivity.this, "HelloChina！！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_content2:
                Toast.makeText(MainActivity.this, "HelloWorld！！", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
    public void showPopup(View view) {

        PopupMenu popup = new PopupMenu(this, view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.menu_popup);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_popup1:
                Toast.makeText(this, "HelloWorld", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_popup2:
                Toast.makeText(this, "HelloChina", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }

}
