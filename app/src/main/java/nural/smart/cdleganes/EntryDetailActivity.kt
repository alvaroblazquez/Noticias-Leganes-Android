package nural.smart.cdleganes

/**
 * Created by alvaro on 23/11/17.
 */


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class EntryDetailActivity: AppCompatActivity() {
    companion object {
        val TITLE = "title"
        val DATE = "date"
        val DESCRIPTION = "description"
        val IMAGE = "image"
        val URL = "url"
        val ORIGEN = "origen"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry_detail)

        val titleTextView = findViewById(R.id.titleEntryDetail) as TextView
        val dateTextView = findViewById(R.id.dateEntryDetail) as TextView
        val descriptionTextView = findViewById(R.id.descriptionEntryDetail) as TextView
        val moreButton = findViewById(R.id.buttonEntryDetail) as Button
        val imageView = findViewById(R.id.imageEntryDetail) as ImageView

        titleTextView.text = intent.getStringExtra(TITLE)
        dateTextView.text = intent.getStringExtra(DATE)
        var description = intent.getStringExtra(DESCRIPTION)
        if (description.length > 0 && description.substring(description.length - 1) != ".") {
            description = description + "..."
        }
        descriptionTextView.text = description
        moreButton.text = "Ver noticia en " + intent.getStringExtra(ORIGEN)
        val imageUrl = intent.getStringExtra(IMAGE)

        Picasso.with(this).load(imageUrl).placeholder(R.mipmap.ic_launcher_bn).into(imageView)
        val url = intent.getStringExtra(URL)

        moreButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
    }

}