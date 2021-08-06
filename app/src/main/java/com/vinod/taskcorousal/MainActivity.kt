package com.vinod.taskcorousal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.vinod.taskcorousal.adapters.ImagesAdapter
import com.vinod.taskcorousal.adapters.IndicatorAdapter
import com.vinod.taskcorousal.adapters.ItemsAdapter
import com.vinod.taskcorousal.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var adapterItems: ItemsAdapter
    private lateinit var adapterIndicator: IndicatorAdapter
    private lateinit var binding: ActivityMainBinding

    val data: MutableMap<Int, MutableList<String>> by lazy { Utils.getPageWiseData() }
    var selectedList: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        adapterIndicator = IndicatorAdapter(0)
        adapterItems = ItemsAdapter(selectedList)
        setListeners()
    }

    private fun setListeners() {
        binding.apply {
            rvIndicator.adapter = adapterIndicator
            rvItems.adapter = adapterItems
            viewpager.adapter = ImagesAdapter(0)
            viewpager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    adapterIndicator.refresh(position)
                    selectedList = data[position] ?: mutableListOf()
                    adapterItems.refresh(selectedList)
                    etSearch.setText("")
                }
            })
            etSearch.addTextChangedListener {
                adapterItems.refresh(Utils.getFilteredData(it.toString(),selectedList))
            }
        }

    }
}