package com.axelessono.tabbedlayoutapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyViewPagerAdapter(
    fragmentManager: FragmentManager,
    private val mFragmentList: List<Fragment>,
    private val mFragmentTitleList: List<String>) : FragmentPagerAdapter(fragmentManager){


    override fun getCount(): Int = mFragmentList.size

    override fun getItem(position: Int): Fragment = mFragmentList[position]

    override fun getPageTitle(position: Int): CharSequence = mFragmentTitleList[position]

}