package cejv669.concordia.com.week04contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button left = findViewById(R.id.button_left);
        Button right = findViewById(R.id.button_right);

        registerForContextMenu(left);
        registerForContextMenu(right);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.button_left) {
            menu.setHeaderTitle("Left Context Menu");
            menu.add(0, v.getId(), 0, "A");
            menu.add(0, v.getId(), 1, "B");
        }
        if (v.getId() == R.id.button_right) {
            menu.setHeaderTitle("Right Context Menu");
            menu.add(1, v.getId(), 0, "Red");
            menu.add(1, v.getId(), 1, "Blue");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.button_left) {
            Toast.makeText(getApplicationContext(), "Letter: " + item.getTitle(), Toast.LENGTH_LONG).show();
            return true;
        }
        if (item.getItemId() == R.id.button_right) {
            Toast.makeText(getApplicationContext(), "Color: " + item.getTitle(), Toast.LENGTH_LONG).show();
            return true;
        }
//        switch (item.getGroupId()) {
//            case 0:
//                Toast.makeText(getApplicationContext(), "Letter: " + item.toString(), Toast.LENGTH_LONG).show();
//                break;
//            case 1:
//                Toast.makeText(getApplicationContext(), "Color: " + item.toString(), Toast.LENGTH_LONG).show();
//                break;
//            default:
//                return false;
//        }
        return true;
    }
}
