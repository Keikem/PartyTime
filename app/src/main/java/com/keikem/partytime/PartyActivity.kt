package com.keikem.partytime

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.keikem.partytime.databinding.ActivityPartyBinding
import kotlinx.android.synthetic.main.activity_party.*

class PartyActivity : AppCompatActivity() {

    private val viewModel by lazy {
        PartyViewModel(
            this,
            BindingHelper(R.layout.guest_item, BR.viewModel)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityPartyBinding>(this, R.layout.activity_party)
        binding.viewModel = viewModel

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        android.R.id.home -> {
            finish()
            true
        }
        else -> false
    }
}