package android.app.com.leftrightmind.DetailActivity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.app.com.leftrightmind.R
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.activity_detail_page.*
import kotlinx.android.synthetic.main.content_detail_page.*

class DetailPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)
        setSupportActionBar(toolbar)

        toolbar.setNavigationIcon(R.drawable.ic_back)
        toolbar.setNavigationOnClickListener { finish() }

        val i = intent.extras
        val uname = i.getString("name","")
        val imageUrl = i.getString("imageUrl","")
        val mobile = i.getString("mobile","")
        val uaddress = i.getString("address","")

        Glide
            .with(this)
            .load(imageUrl)
            .error(R.drawable.ic_placeholder)
            .into(imageView)

        name.text = uname
        mobileNo.text = mobile
        address.text = uaddress

    }

}
