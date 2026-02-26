package com.example.studyflow

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val REQUEST_ADD_TASK = 1

    private val taskList = mutableListOf(
        StudyTask("Math homework", "Assignment"),
        StudyTask("Physics exam", "Exam"),
        StudyTask("English reading", "Assignment")
    )

    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.tasksRecyclerView)
        val addButton = findViewById<Button>(R.id.addTaskButton)

        adapter = TaskAdapter(taskList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        addButton.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivityForResult(intent, REQUEST_ADD_TASK)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_ADD_TASK && resultCode == RESULT_OK && data != null) {
            val title = data.getStringExtra("title") ?: return
            val type = data.getStringExtra("type") ?: return

            taskList.add(StudyTask(title, type))
            adapter.notifyItemInserted(taskList.size - 1)
        }
    }
}