package com.petterp.bullet.core

import android.content.Context

object KtxContext {
    var context: Context? = null

    fun initContext(context: Context) {
        this.context = context
    }

    fun checkNull() {
        checkNotNull(context) {
            "Ktxcontext not Null!!"
        }
    }

}