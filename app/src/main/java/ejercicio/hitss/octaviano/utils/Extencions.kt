package ejercicio.hitss.octaviano.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import ejercicio.hitss.octaviano.R
import java.lang.Exception

fun ImageView.loadNetworkImage(url: String) {
    Glide
        .with(this.context)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .centerCrop()
        .into(this)
}

@SuppressWarnings("deprecation")
fun String.fromHtml(): String =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
        Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY).toString().trim()
    else
        Html.fromHtml(this).toString().trim()


fun RecyclerView.initHorizontal() {
    this.layoutManager =
        LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
}

fun Context.launchUrl(url: String) {
    try {
        val uri: Uri =
            Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        this.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(this, "Ocurrió un error al abrir al url", Toast.LENGTH_LONG).show()
    }
}

fun View.hiden() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun Activity.lockPortraitOrientation() {
    if (DeviceUtility.getDeviceType(this) == DeviceUtility.Device.PHONE)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
}

