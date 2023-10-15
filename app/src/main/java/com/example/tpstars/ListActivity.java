package com.example.tpstars;



import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ShareCompat;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tpstars.adapter.StarAdapter;
import com.example.tpstars.beans.Star;
import com.example.tpstars.service.StarService;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private List<Star> stars;
    private RecyclerView recyclerView;
    private StarService service;
    private StarAdapter starAdapter = null;
    private Toolbar myToolbar;

    public ListActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Football Players");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.purple)));

        stars = new ArrayList<>();
        service = StarService.getInstance();
        init();
        recyclerView = findViewById(R.id.recycle_view);
        stars = service.findAll();
        starAdapter = new StarAdapter(this, stars);
        recyclerView.setAdapter(starAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    private void filterList(String s) {
        List<Star> filtredList = new ArrayList<>();
        for (Star star : stars) {
            if (star.getName().toLowerCase().startsWith(s.toLowerCase().trim())) {
                filtredList.add(star);
            }
           
            starAdapter.setFiltredList(filtredList);
        }
    }

    public void init() {
        service.create(new Star("achraf hakimi", "https://i.pinimg.com/564x/0b/ab/45/0bab4531eda17402d6e6e2dff94b5c88.jpg", 1, R.mipmap.morocco));
        service.create(new Star("Rafael Leao", "https://i.pinimg.com/564x/62/a2/67/62a2673b4fb21ba24bee4a9a7585dd01.jpg", 3.5f,R.mipmap.portugal));
        service.create(new Star("Erling haaland", "https://i.pinimg.com/564x/89/2a/b2/892ab2d6515ecfa82da621c7584631a1.jpg", 3,R.mipmap.norvege));
        service.create(new Star("Ronaldinho", "https://i.pinimg.com/564x/c2/f9/6a/c2f96a44c9be789c3a96ffe8de426c01.jpg", 5,R.mipmap.bresil));
        service.create(new Star("Antoine griezmann", "https://i.pinimg.com/564x/5a/40/6a/5a406ac813190b1531d8ede52a760caf.jpg", 1,R.mipmap.france));
        service.create(new Star("Lionnel messi", "https://i.pinimg.com/564x/52/4b/7a/524b7a00428da6c59270356948501188.jpg", 5,R.mipmap.argentine));
        service.create(new Star("lautaro martinez", "https://i.pinimg.com/564x/bd/ee/02/bdee02498de0ce1b328a5ab660217ddb.jpg", 1,R.mipmap.argentine));
        service.create(new Star("memphis depay", "https://i.pinimg.com/564x/96/07/ea/9607ea537db59f130de83779d3e5c404.jpg", 1,R.mipmap.netherlands));
        service.create(new Star("neymar jr", "https://i.pinimg.com/564x/1e/19/d3/1e19d37cac79a54c2ab31907a9f5f31e.jpg", 1,R.mipmap.bresil));
        service.create(new Star("marcus rashford", "https://i.pinimg.com/564x/4c/fb/d4/4cfbd4d2d684db1d13d7a5277e260b37.jpg", 1,R.mipmap.angleterre));
        service.create(new Star("jud bellingham", "https://i.pinimg.com/564x/ad/27/d1/ad27d1b8cb59d7476ab9e4736de54501.jpg", 1,R.mipmap.angleterre));
        service.create(new Star("luka modric", "https://i.pinimg.com/564x/63/32/f7/6332f782fe751c874004650c339f9885.jpg", 1,R.mipmap.croatie));
        service.create(new Star("robert levandovski", "https://i.pinimg.com/564x/fc/e2/2c/fce22c130b704a332f551788d9d593f5.jpg", 1,R.mipmap.pologne));
        service.create(new Star("kylian mbappe", "https://i.pinimg.com/564x/ec/04/db/ec04dbc14aabd0b58c5b6b7054365b7b.jpg", 1,R.mipmap.france));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);
                return false;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.share) {
            String txt = "Stars";
            String mimeType = "text/plain";
            ShareCompat.IntentBuilder
                    .from(this)
                    .setType(mimeType)
                    .setChooserTitle("Stars")
                    .setText(txt)
                    .startChooser();
        }
        return super.onOptionsItemSelected(item);


    }
}