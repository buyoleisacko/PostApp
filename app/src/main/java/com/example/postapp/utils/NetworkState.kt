package com.example.postapp.utils

import android.content.Context
import com.example.postapp.extension.networkInfo
import javax.inject.Inject

interface NetworkState {
    fun isConnected(): Boolean
}

class NetworkStateImpl @Inject constructor(private val context: Context) : NetworkState {
    override fun isConnected(): Boolean = context.networkInfo()
}