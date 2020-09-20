package com.example.ass7_sec3_613020532_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.*

class MainActivity : AppCompatActivity() {
    val EmployeeList = arrayListOf<Employee>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        employeeData()
        recycler_view.adapter = EmployeeAdapter(this.EmployeeList, applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
        recycler_view.itemAnimator = DefaultItemAnimator()
    }

    fun employeeData(){
        EmployeeList.add(Employee("Kasama","female","edefe@gmail.com", 5000))
        EmployeeList.add(Employee("Waranya","male","fefef@gmail.com", 1000))
    }

    fun addEmployee(view: View) {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout, null)
        val myBuilder = AlertDialog.Builder(this)
        myBuilder.setView(mDialogView)
        val mAlertDialog = myBuilder.show()
        mAlertDialog.btnAdd.setOnClickListener(){
            val radioGroupId: Int = mAlertDialog.radioGroup.checkedRadioButtonId
            val selected: RadioButton? = mAlertDialog.findViewById(radioGroupId)
            EmployeeList.add(
                Employee(
                    mAlertDialog.edt_name.text.toString(),
                    selected?.text.toString(),
                    mAlertDialog.edt_email.text.toString(),
                    mAlertDialog.edt_salary.text.toString().toInt()
                )
            )
            recycler_view.adapter?.notifyDataSetChanged()
            Toast.makeText(
                applicationContext,
                "The student is added successfully",
                Toast.LENGTH_LONG
            ).show()
            mAlertDialog.dismiss()
        }
        mAlertDialog.btnCancel.setOnClickListener(){
            mAlertDialog.dismiss()
        }

    }
}

