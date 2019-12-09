package com.sample.usabillasample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.usabilla.sdk.ubform.Usabilla

class MainActivity : AppCompatActivity() {


    var usabillaID = "";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//Usabilla
            Usabilla.getInstance(baseContext).initialize(
                baseContext,usabillaID // Apcoa App id
            )
        sendUsabillaEvent(this, "IT_App_Open")

    }

    fun sendUsabillaEvent(activity: FragmentActivity?, eventName: String) {
        var usabilla = Usabilla.getInstance(baseContext)
        usabilla.customVariables.put(
            UsabillaCustomVariables.STATUS,
            UsabillaCustomVariables.GUEST
        )
        usabilla.initialize(activity!!, usabillaID)
        usabilla.updateFragmentManager(activity!!.getSupportFragmentManager())
        usabilla.sendEvent(activity!!.getApplicationContext(), eventName)
    }

    object UsabillaCustomVariables {
        val STATUS = "Status"
        val REGISTERED = "Registered"
        val GUEST = "Guest"
        val RFID_OREDERED = "RFID Ordered"
        val YES = "Yes"
        val NO = "No"
        val CUSTOMER_ID = "Customer_ID"
        val LANGUAGE = "Language"
        val PLATFORM = "Platform"
    }


}
