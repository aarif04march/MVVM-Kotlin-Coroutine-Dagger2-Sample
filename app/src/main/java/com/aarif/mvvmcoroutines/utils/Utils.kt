package com.aarif.mvvmcoroutines.utils

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.util.Base64
import android.view.View
import android.widget.Toast
import com.aarif.mvvmcoroutines.R
import com.google.android.material.snackbar.Snackbar
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


/**
 * @author AaR!F
 * @desc Utils class used for utility operations and methods
 */
@Singleton
open class Utils @Inject constructor(val context: Context) {

     fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val capabilities =
                    connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        return true
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        return true
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                        return true
                    }
                }
            } else {
                try {
                    val activeNetworkInfo = connectivityManager.activeNetworkInfo
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                        AppLog.debugI("update_statut", "Network is available : true")
                        return true
                    }
                } catch (e: java.lang.Exception) {
                    AppLog.debugI("update_statut", "${e.message}")
                }
            }
        }
        AppLog.debugI("update_statut", "Network is available : FALSE ")
        return false
    }

    /**
     * This function is used to Print Hash Key
     */
    fun printKeyHash(): String? {
        val packageInfo: PackageInfo
        var key: String? = null
        try {
            // getting application package name, as defined in manifest
            val packageName = context.applicationContext
                .packageName

            // Retriving package info
            packageInfo = context.packageManager.getPackageInfo(
                packageName, PackageManager.GET_SIGNATURES
            )

            AppLog.debugD(
                "Package Name = " + context.applicationContext
                    .packageName
            )

            for (signature in packageInfo.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                key = String(Base64.encode(md.digest(), 0))
                AppLog.debugD("Key Hash = $key")
            }
        } catch (e: Exception) {
            AppLog.debugD("Exception =  $e")
        }

        return key
    }

    /**
     * @author AaR!F
     * @desc This function is used to show Toast Message
     */
    fun showToast(respMsg: String) {
        try {
            Toast.makeText(context, respMsg, Toast.LENGTH_SHORT)
                .show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    /**
     * @author AaR!F
     * @desc This function is used to show Snakebar with provided message
     */
    fun showSnakeBar(view: View, msg: String) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show()
    }

    fun showMessageDialog(context: Context, msg: String?) {
        val myAlertDialog = AlertDialog.Builder(context)
        myAlertDialog.setTitle(context.getString(R.string.dlg_title_alert))
        myAlertDialog.setCancelable(false)
        myAlertDialog.setMessage(msg)
        myAlertDialog.setPositiveButton(context.getString(R.string.dlg_btn_ok)) { dialog, _ ->
            dialog.dismiss()
        }
        val dialog = myAlertDialog.create()
        dialog.show()
    }

    fun isValidEmail(target: CharSequence?): Boolean {
        if (target == null) {
            return false
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
        }
    }

    /**
     * @author AaR!Fs
     */
    fun shareData(context: Context, subject: String, body: String) {
        try {
            val i = Intent(Intent.ACTION_SEND)
            i.type = "text/plain"
            i.putExtra(Intent.EXTRA_SUBJECT, subject)
            i.putExtra(Intent.EXTRA_TEXT, body)
            context.startActivity(Intent.createChooser(i, "choose one"))
        } catch (e: Exception) {
            AppLog.loadStackTrace(e)
        }
    }

    fun invokeDialIntent(phone: String){
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phone")
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

    fun invokeMessageIntent(phone: String){
        val smsIntent = Intent(Intent.ACTION_VIEW)
        smsIntent.type = "vnd.android-dir/mms-sms"
        smsIntent.putExtra("address", phone)
        smsIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(smsIntent)
    }

    fun getHoursFromDate(inputString: String): String{
        var outputTime: String
        val sdfInput = SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault())
        val sdfOut = SimpleDateFormat("HH:mm", Locale.getDefault())
        try {
            val date = sdfInput.parse(inputString)
            outputTime = sdfOut.format(date)
        }
        catch (e: Exception){
            outputTime = "INVALID DATE FORMAT"
        }
        return outputTime
    }

    fun getDurationFromMinutes(inputMins: Int): String{
        if(inputMins>0) {
            val hrs = inputMins / 60
            val mins = inputMins % 60
            return "${hrs}h ${mins}m"
        }
        else
            return "INVALID"
    }

    /*fun getRandomColor(){
        val generator = ColorGenerator.MATERIAL; // or use DEFAULT
// generate random color
        val color1 = generator.getRandomColor();
// generate color based on a key (same key returns the same color), useful for list/grid views
        val color2 = generator.getColor("user@gmail.com")

// declare the builder object once.
        TextDrawable.IBuilder builder = TextDrawable.builder()
            .beginConfig()
            .withBorder(4)
            .endConfig()
            .rect();
    }*/
}