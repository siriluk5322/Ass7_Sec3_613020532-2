package com.example.ass7_sec3_613020532_2

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.emp_item_layout.view.*

class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
    val tvName = view.tv_name
    val tvGender = view.tv_gender
    val tvEmail = view.tv_email
    val tvSalary = view.tv_salary
}