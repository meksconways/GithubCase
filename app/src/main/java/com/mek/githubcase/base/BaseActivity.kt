package com.mek.githubcase.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mek.githubcase.di.Injector
import java.util.*

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var instanceId: String

    companion object {
        const val INSTANCE_ID_KEY: String = "instance_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            instanceId = it.getString(INSTANCE_ID_KEY).toString()
        } ?: run {
            instanceId = UUID.randomUUID().toString()
        }
        Injector.inject(this)
        super.onCreate(savedInstanceState)

    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(INSTANCE_ID_KEY,instanceId)
    }

    fun getInstanceId() = instanceId
}