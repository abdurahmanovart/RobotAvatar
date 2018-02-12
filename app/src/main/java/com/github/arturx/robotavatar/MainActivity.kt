package com.github.arturx.robotavatar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.github.arturx.robotavatar.net.RoboService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    var disposable: Disposable? = null
    lateinit var textview: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textview = findViewById(R.id.text_view_1)
        getRoboAvatar("arturx")
    }

    private val roboServ by lazy {
        RoboService.create()
    }

    private fun getRoboAvatar(text: String) {
        disposable =
                roboServ.getAvatar(text)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { result -> textview.setText(result.toString()) },
                                { error -> print("ERROORA" + error) }
                        )

    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

}
