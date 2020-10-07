package com.example.test_m2u.custom

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.viewbinding.ViewBinding
import com.example.test_m2u.base.ContextFinder
import com.squareup.picasso.Picasso
import kotlin.reflect.KClass
import kotlin.reflect.KFunction0

val Context.inflater get() = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

@Suppress("UNCHECKED_CAST")
inline fun <reified Binding : ViewBinding> ContextFinder.viewBind() = lazy {
    Binding::class.java.getMethod("inflate", LayoutInflater::class.java)
        .invoke(null, cont.inflater) as Binding
}
@Suppress("UNCHECKED_CAST") // Converts Pixel value to DensityPixel value
val <N : Number> N.dp
    get() = (toFloat() * Resources.getSystem().displayMetrics.density) as N
val <N : Number> N.sp
    get() = (toFloat() * Resources.getSystem().displayMetrics.scaledDensity) as N

@Suppress("UNCHECKED_CAST")
fun <Binding : ViewBinding> Context.viewBind(klass: KClass<Binding>) =
    klass.java.getMethod("inflate", LayoutInflater::class.java)
        .invoke(null, inflater) as Binding

fun <T : Any> Context.launchActivity(clazz: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, clazz)
    startActivity(intent.putExtras(Bundle().apply(extras)))
}

fun <V : View> V.onClick(function: V.() -> Unit = {}) {
    setOnClickListener { function() }
}

fun <V : View> V.onClick(function: KFunction0<*>) {
    setOnClickListener { function() }
}

val Context.activity: Activity
    get() = when (this) {
        is Activity -> this
        else -> (this as ContextWrapper).baseContext.activity
    }

infix fun ImageView.setImageFromURL(url: Any?) = Picasso.get().load(url.toString()).into(this)

fun ImageView.setImageFromURLwError(url: Any?, placeholder: Int) = Picasso.get().load(url.toString()).error(placeholder).into(this)


