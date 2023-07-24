package com.abrark.tippyclone2

import android.animation.ArgbEvaluator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.content.ContextCompat

private const val TAG = "MainActivity"
private const val INITIAL_TIP_PERCENT = 15
class MainActivity : AppCompatActivity() {
    private lateinit var etBaseAmount: EditText
    private lateinit var seekBarTip: SeekBar
    private lateinit var tvTipPercentLabel: TextView
    private lateinit var tvTipAmount: TextView
    private lateinit var tvTotalAmount: TextView
    private lateinit var tvTipDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etBaseAmount = findViewById(R.id.etBaseAmount)
        seekBarTip = findViewById(R.id.seekBarTip)
        tvTipPercentLabel = findViewById(R.id.tvTipPercentLabel)
        tvTipAmount = findViewById(R.id.tvTipAmount)
        tvTotalAmount = findViewById(R.id.tvTotalAmount)
        tvTipDescription = findViewById(R.id.tvTipDescription)

        seekBarTip.progress = INITIAL_TIP_PERCENT
        tvTipDescription.text = "$INITIAL_TIP_PERCENT%"
        updateTipDescription(INITIAL_TIP_PERCENT)
        seekBarTip.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, progress: Int, fromUser: Boolean) {
                Log.i(TAG, "onProgressChanged: $progress")
                tvTipPercentLabel.text = "$progress%"
                computeTipAndTotal()
                updateTipDescription(progress)
//                TODO("Not yet implemented")
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
//                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
//                TODO("Not yet implemented")
            }
        })
        etBaseAmount.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//                TODO("Not yet implemented")
            }

            override fun afterTextChanged(s: Editable?) {
                Log.i(TAG, "afterTextChanged: $s")
                computeTipAndTotal()
            }

        })
    }

    private fun updateTipDescription(tipPercent: Int) {
        val tipDescription = when(tipPercent) {
            in 0..9 -> "Poor"
            in 10..14 -> "Acceptable"
            in 15..19 -> "Good"
            in 20..24 -> "Great"
            else -> "Amazing"
        }
        tvTipDescription.text = tipDescription
        val color = ArgbEvaluator().evaluate(
            (tipPercent / seekBarTip.max).toFloat(),
            ContextCompat.getColor(this, R.color.color_worst_tip),
            ContextCompat.getColor(this, R.color.color_best_tip))
        tvTipDescription.setTextColor(color as Int)
    }

    private fun computeTipAndTotal() {
        // 1. Get the value of base amount and tip percent
        if (etBaseAmount.text.toString().isEmpty()) {
            tvTipAmount.text = ""
            tvTotalAmount.text = ""
            return
        } else {
            val baseAmount = etBaseAmount.text.toString().toDouble();
            val tipPercent = seekBarTip.progress;
            // 2. calculate the value of tip and total
            val tipAmount = baseAmount * tipPercent / 100
            val totalAmount = tipAmount + baseAmount
            // 3. update the UI
            tvTipAmount.text = "%.2f".format(tipAmount)
            tvTotalAmount.text = "%.2f".format(totalAmount)
        }
    }
}