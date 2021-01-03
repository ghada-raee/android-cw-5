package com.example.books;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String six = "Ketterdam: a bustling hub of international trade where anything can be had for the right price—and no one knows that better than criminal prodigy Kaz Brekker. Kaz is offered a chance at a deadly heist that could make him rich beyond his wildest dreams. But he can’t pull it off alone. . . .";
        String crooked = "Kaz Brekker and his crew of deadly outcasts have just pulled off a heist so daring even they didn't think they'd survive. But instead of divvying up a fat reward, they're right back to fighting for their lives.";
        String blade ="Celaena Sardothien is Adarlan's most feared assassin. As part of the Assassin's Guild, her allegiance is to her master, Arobynn Hamel, yet Celaena listens to no one and trusts only her fellow killer-for-hire, Sam. In these action-packed novellas - together in one edition for the first time - Celaena embarks on five daring missions. They take her from remote islands to hostile deserts, where she fights to liberate slaves and seeks to avenge the tyrannous. But she is acting against Arobynn's orders and could suffer an unimaginable punishment for such treachery. Will Celaena ever be truly free? Explore the dark underworld of this kick-ass heroine to find out.";
        String prince ="Jude was seven when her parents were murdered and she and her two sisters were stolen away to live in the treacherous High Court of Faerie. Ten years later, Jude wants nothing more than to belong there, despite her mortality. But many of the fey despise humans. Especially Prince Cardan, the youngest and wickedest son of the High King.\n" +
                "\n" +
                "To win a place at the Court, she must defy him–and face the consequences.";
        ArrayList<Book> books = new ArrayList<>();
         books.add(new Book("Six of crows","Leigh Bardugo","Young adult",4.8,R.drawable.sixofcrows,"1627792120 (ISBN13: 9781627792127)","Six of Crows #1, Grishaverse #4",six ));
        books.add(new Book("Crooked kingdom","Leigh Bardugo","Young adult",4.7,R.drawable.crooked,"B0117K9N3Q","Six of Crows #2, Grishaverse #5",crooked));
        books.add(new Book("The assassin's blade ","Sarah J. Mass","Fantasy",4.2,R.drawable.blade,"1408852594 (ISBN13: 9781408852590)","Throne of Glass #0.1 - 0.5",blade));
        books.add(new Book("The cruel prince","Holly Black","Fantasy",3.8, R.drawable.cruel,"9780316310314","The Folk of the Air #1",prince));
        LinearLayout ll = findViewById(R.id.linearLayout);
        RecyclerView booklist = findViewById(R.id.rv);
        booklist.setHasFixedSize(true);
        RecyclerView.LayoutManager lm= new LinearLayoutManager(this);
        booklist.setLayoutManager(lm);
        BookAdapter ba = new BookAdapter(books,MainActivity.this,ll);
        booklist.setAdapter(ba);
        Toolbar toolbar = findViewById(R.id.toolbar);
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Home").withIcon(R.drawable.ic_baseline_home_24);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Profile").withIcon(R.drawable.ic_baseline_account_circle_24);
        SecondaryDrawerItem item3 = new SecondaryDrawerItem().withIdentifier(3).withName("Settings");

//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(
                        item1,
                        item2,
                        new DividerDrawerItem(),
                        item3

                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        // do something with the clicked item :D


                        return true;
                    }
                })
                .build();

    }
}