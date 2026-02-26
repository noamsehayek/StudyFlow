package com.example.studyflow

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AddTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val titleInput = findViewById<EditText>(R.id.taskTitleInput)
        val spinner = findViewById<Spinner>(R.id.taskTypeSpinner)
        val saveButton = findViewById<Button>(R.id.saveTaskButton)

        val types = arrayOf("Assignment", "Exam")
        spinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            types
        )

        saveButton.setOnClickListener {
            val title = titleInput.text.toString().trim()
            val type = spinner.selectedItem.toString()

            if (title.isEmpty()) {
                Toast.makeText(this, "Please enter a title", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = Intent()
            result.putExtra("title", title)
            result.putExtra("type", type)
            setResult(RESULT_OK, result)
            finish()
        }
    }
}