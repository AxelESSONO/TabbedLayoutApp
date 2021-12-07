package com.axelessono.tabbedlayoutapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity(), PassDataListener {

    private lateinit var toolbar: Toolbar
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var myViewPagerAdapter: MyViewPagerAdapter

    private lateinit var mFragmentList: List<Fragment>
    private lateinit var mFragmentTitleList: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolBar)
        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        setSupportActionBar(toolbar)

        mFragmentList = arrayListOf(
            FirstFragment(),
            SecondFragment(),
            ThirdFragment(),
            ForthFragment(),
            FithFragment(),
            SixthFragment()
        )

        mFragmentTitleList = arrayListOf(
            "Premier",
            "Deuxième",
            "Troisième",
            "Quatrième",
            "Cinquième",
            "Sixième"
        )

        myViewPagerAdapter = MyViewPagerAdapter(
            supportFragmentManager,
            mFragmentList,
            mFragmentTitleList
        )

        viewPager.adapter = myViewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)

    }

    override fun onPassDataListener(firsName: String?, lastName: String?, age: Int?) {
        val tag = "android:switcher:"+R.id.viewPager.toString()+":"+1
        val secondFragment = supportFragmentManager.findFragmentByTag(tag) as SecondFragment
        secondFragment.getSentData(firsName, lastName, age)
        val currentItem = getItem(+1)
        viewPager.currentItem = currentItem
    }

    private fun getItem(position : Int) = viewPager.currentItem + position


}