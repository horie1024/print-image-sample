package com.horie1024.printsample

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.print.PrintHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val image = image.drawable as BitmapDrawable
            printImage(image)
        }
    }

    private fun printImage(drawable: BitmapDrawable) {
        if (PrintHelper.systemSupportsPrint()) {
            val printHelper = PrintHelper(this)
            printHelper.colorMode = PrintHelper.COLOR_MODE_COLOR
            printHelper.scaleMode = PrintHelper.SCALE_MODE_FIT
            printHelper.printBitmap("Print sample", drawable.bitmap)
        } else {
            Toast.makeText(
                this,
                "この端末では印刷をサポートしていません",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
